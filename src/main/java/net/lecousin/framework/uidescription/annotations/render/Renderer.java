package net.lecousin.framework.uidescription.annotations.render;

import java.lang.reflect.Field;

import net.lecousin.framework.locale.ILocalizableString;

/** Interface for a renderer, which is able to convert a field content into a displayable string. */
public interface Renderer {

	/** Convert a field content into a displayable string. */
	public ILocalizableString toDisplayString(Object instance, Field field);
	
}
