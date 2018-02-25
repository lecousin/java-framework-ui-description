package net.lecousin.framework.ui_description.annotations.render;

import java.lang.reflect.Field;

import net.lecousin.framework.locale.ILocalizableString;

public interface Renderer {

	public ILocalizableString toDisplayString(Object instance, Field field);
	
}
