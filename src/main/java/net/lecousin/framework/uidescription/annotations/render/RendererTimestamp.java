package net.lecousin.framework.uidescription.annotations.render;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import net.lecousin.framework.application.LCCore;
import net.lecousin.framework.io.serialization.TypeDefinition;
import net.lecousin.framework.locale.FixedLocalizedString;
import net.lecousin.framework.locale.ILocalizableString;

/** Render a timestamp, date or calendar. */
public class RendererTimestamp implements Renderer {

	@Override
	public ILocalizableString toDisplayString(TypeDefinition type, Object value) {
		String s;
		try {
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
					s = DateFormat.getDateTimeInstance(
						DateFormat.SHORT, DateFormat.LONG, LCCore.getApplication().getLocale()).format(date);
				else
					s = "";
			}
		} catch (Throwable t) { s = ""; }
		return new FixedLocalizedString(s);
	}
	
}
