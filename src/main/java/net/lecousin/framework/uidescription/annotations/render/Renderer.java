package net.lecousin.framework.uidescription.annotations.render;

import net.lecousin.framework.io.serialization.TypeDefinition;
import net.lecousin.framework.locale.ILocalizableString;

/** Interface for a renderer, which is able to convert a field content into a displayable string. */
public interface Renderer {

	/** Convert a value into a displayable string. */
	public ILocalizableString toDisplayString(TypeDefinition type, Object value);
	
}
