package net.lecousin.framework.uidescription.annotations.name;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Localized name. */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface LocalizedName {

	/** Locale namespace. */
	String namespace();

	/** Locale key. */
	String key();
	
}
