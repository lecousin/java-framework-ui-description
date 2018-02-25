package net.lecousin.framework.uidescription.annotations.render;

import java.lang.reflect.Field;

import net.lecousin.framework.locale.FixedLocalizedString;
import net.lecousin.framework.locale.ILocalizableString;
import net.lecousin.framework.util.StringUtil;

/** Render as a size. */
public class RendererSize implements Renderer {

	@Override
	public ILocalizableString toDisplayString(Object instance, Field field) {
		String s = "";
		try {
			if (field.getType().isPrimitive()) {
				s = StringUtil.size(field.getLong(instance));
			} else if (Number.class.isAssignableFrom(field.getType())) {
				Number n = (Number)field.get(instance);
				if (n != null)
					s = StringUtil.size(n);
			}
		} catch (Throwable t) {
			// ignore
		}
		return new FixedLocalizedString(s);
	}
	
}
