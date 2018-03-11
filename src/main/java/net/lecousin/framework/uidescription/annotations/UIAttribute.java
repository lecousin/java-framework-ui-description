package net.lecousin.framework.uidescription.annotations;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import net.lecousin.framework.geometry.HorizontalAlignment;
import net.lecousin.framework.io.serialization.TypeDefinition;
import net.lecousin.framework.locale.FixedLocalizedString;
import net.lecousin.framework.locale.ILocalizableString;
import net.lecousin.framework.uidescription.annotations.render.Render;
import net.lecousin.framework.uidescription.annotations.render.TextAlign;

public class UIAttribute {

	private ILocalizableString name;
	
	private Object instance;
	private Field field;
	private Method getter;
	
	public UIAttribute(ILocalizableString name, Object instance, Field field) {
		this.name = name;
		this.instance = instance;
		this.field = field;
	}
	
	public UIAttribute(ILocalizableString name, Object instance, Method getter) {
		this.name = name;
		this.instance = instance;
		this.getter = getter;
	}
	
	public ILocalizableString getName() {
		return name;
	}
	
	public TypeDefinition getType() {
		if (field != null)
			return new TypeDefinition(new TypeDefinition(instance.getClass()), field.getGenericType());
		return new TypeDefinition(new TypeDefinition(instance.getClass()), getter.getGenericReturnType());
	}
	
	public Object getValue() throws ReflectiveOperationException {
		if (field != null)
			return field.get(instance);
		return getter.invoke(instance);
	}
	
	public AnnotatedElement getElement() {
		return field != null ? field : getter;
	}
	
	public HorizontalAlignment getTextAlignment(HorizontalAlignment defaultValue) {
		return getTextAlignment(getElement(), defaultValue);
	}

	public static HorizontalAlignment getTextAlignment(AnnotatedElement element, HorizontalAlignment defaultValue) {
		TextAlign align = element.getAnnotation(TextAlign.class);
		if (align == null) return defaultValue;
		return align.value();
	}

	public ILocalizableString getStringValue() {
		AnnotatedElement element = getElement();
		Render r = element.getAnnotation(Render.class);
		try {
			Object value = getValue();
			TypeDefinition type = getType();
			if (r != null)
				return r.value().newInstance().toDisplayString(type, value);
			if (value == null)
				return new FixedLocalizedString("");
			if (value instanceof ILocalizableString)
				return (ILocalizableString)value;
			return new FixedLocalizedString(value.toString());
		} catch (Throwable t) {
			return new FixedLocalizedString("");
		}
	}
	
}
