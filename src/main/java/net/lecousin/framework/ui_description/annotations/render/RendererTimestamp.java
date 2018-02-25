package net.lecousin.framework.ui_description.annotations.render;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import net.lecousin.framework.application.LCCore;
import net.lecousin.framework.locale.FixedLocalizedString;
import net.lecousin.framework.locale.ILocalizableString;

public class RendererTimestamp implements Renderer {

	@Override
	public ILocalizableString toDisplayString(Object instance, Field field) {
		String s;
		try {
			Object value = field.get(instance);
			if (value == null)
				s = "";
			else {
				Date date = null;
				if (value instanceof Date)
					date = (Date)value;
				else if (value instanceof Calendar)
					date = ((Calendar)value).getTime();
				else if (value instanceof Number)
					date = new Date(((Number)value).longValue());
				if (date != null)
					s = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG, LCCore.getApplication().getLocale()).format(date);
				else
					s = "";
			}
		} catch (Throwable t) { s = ""; }
		return new FixedLocalizedString(s);
	}
	
}
