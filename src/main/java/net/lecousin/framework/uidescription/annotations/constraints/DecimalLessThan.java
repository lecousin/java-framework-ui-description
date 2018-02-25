package net.lecousin.framework.uidescription.annotations.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Decimal must be less than the specified value. */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DecimalLessThan {

	/** Decimal must be less than the specified value. */
	public double value();
	
}
