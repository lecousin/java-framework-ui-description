package net.lecousin.framework.uidescription.annotations;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.lecousin.framework.locale.FixedLocalizedString;
import net.lecousin.framework.locale.ILocalizableString;
import net.lecousin.framework.locale.LocalizableString;
import net.lecousin.framework.uidescription.annotations.name.FixedName;
import net.lecousin.framework.uidescription.annotations.name.LocalizedName;
import net.lecousin.framework.util.ClassUtil;

public class UIAnnotations {

	protected UIAnnotations() { /* no instance. */ }
	
	public static List<UIAttributeCategory> getObjectAttributes(Object obj) {
		List<UIAttributeCategory> categories = new ArrayList<>();
		if (obj == null) return categories;
		for (Field field : ClassUtil.getAllFieldsInheritedFirst(obj.getClass())) {
			ILocalizableString name = getName(field);
			if (name == null)
				continue;
			UIAttributeCategory cat = getOrCreateCategory(categories, field);
			cat.addAttribute(new UIAttribute(name, obj, field));
		}
		for (Method m : ClassUtil.getAllMethodsInheritedFirst(obj.getClass())) {
			if (m.getParameterCount() > 0)
				continue;
			if (m.getReturnType().equals(void.class))
				continue;
			ILocalizableString name = getName(m);
			if (name == null)
				continue;
			UIAttributeCategory cat = getOrCreateCategory(categories, m);
			cat.addAttribute(new UIAttribute(name, obj, m));
		}
		return categories;
	}
	
	public static ILocalizableString getName(AnnotatedElement element) {
		FixedName fixed = element.getAnnotation(FixedName.class);
		if (fixed != null)
			return new FixedLocalizedString(fixed.value());
		LocalizedName locale = element.getAnnotation(LocalizedName.class);
		if (locale != null)
			return new LocalizableString(locale.namespace(), locale.key());
		return null;
	}
	
	public static UIAttributeCategory getOrCreateCategory(List<UIAttributeCategory> categories, AnnotatedElement element) {
		Category c = element.getAnnotation(Category.class);
		if (c == null) {
			for (UIAttributeCategory cat : categories)
				if (!cat.hasName())
					return cat;
			UIAttributeCategory cat = new UIAttributeCategory((ILocalizableString)null);
			categories.add(cat);
			return cat;
		}
		for (UIAttributeCategory cat : categories)
			if (cat.isSame(c))
				return cat;
		UIAttributeCategory cat = new UIAttributeCategory(c);
		categories.add(cat);
		return cat;
	}
	
}
