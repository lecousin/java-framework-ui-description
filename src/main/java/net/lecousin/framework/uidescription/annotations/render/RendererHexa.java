package net.lecousin.framework.uidescription.annotations.render;

import net.lecousin.framework.io.serialization.TypeDefinition;
import net.lecousin.framework.locale.FixedLocalizedString;
import net.lecousin.framework.locale.ILocalizableString;
import net.lecousin.framework.util.StringUtil;

public class RendererHexa implements Renderer {

	@Override
	public ILocalizableString toDisplayString(TypeDefinition type, Object value) {
		if (value != null) {
			if (value instanceof Number)
				return new FixedLocalizedString(StringUtil.encodeHexaPadding(((Number)value).longValue()));
			if (value.getClass().isArray() && value.getClass().getComponentType().equals(byte.class))
				return new FixedLocalizedString(StringUtil.encodeHexa((byte[])value));
		}
		return new FixedLocalizedString("");
	}
}
