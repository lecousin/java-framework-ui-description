package net.lecousin.framework.uidescription.annotations.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** The attached field is displayable only if the given enum field has the given enum value. */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface OnlyIfEnum {

	/** Enum field's name. */
	public String name();

	/** Enum field's value. */
	public String value();
	
}
