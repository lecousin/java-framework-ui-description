package net.lecousin.framework.uidescription.annotations.render;

import net.lecousin.framework.io.serialization.TypeDefinition;
import net.lecousin.framework.locale.FixedLocalizedString;
import net.lecousin.framework.locale.ILocalizableString;
import net.lecousin.framework.util.GUIDUtil;

public class GUIDRenderer implements Renderer {

	@Override
	public ILocalizableString toDisplayString(TypeDefinition type, Object value) {
		try {
			return new FixedLocalizedString(GUIDUtil.GUIDToString((byte[])value));
		} catch (Throwable t) {
			return new FixedLocalizedString("");
		}
	}
	
}
