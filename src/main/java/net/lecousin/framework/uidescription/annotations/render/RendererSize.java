package net.lecousin.framework.uidescription.annotations.render;

import net.lecousin.framework.io.serialization.TypeDefinition;
import net.lecousin.framework.locale.FixedLocalizedString;
import net.lecousin.framework.locale.ILocalizableString;
import net.lecousin.framework.util.StringUtil;

/** Render as a size. */
public class RendererSize implements Renderer {

	@Override
	public ILocalizableString toDisplayString(TypeDefinition type, Object value) {
		if (value instanceof Number)
			return new FixedLocalizedString(StringUtil.size((Number)value));
		return new FixedLocalizedString("");
	}
	
}
