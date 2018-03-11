package net.lecousin.framework.uidescription.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Category {

	String fixedName() default "";
	String localeNamespace() default "";
	String localeKey() default "";
	
}
