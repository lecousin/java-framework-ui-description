package net.lecousin.framework.uidescription.annotations.render;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Associate a renderer. */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Render {

	/** Renderer implementation to use. */
	Class<? extends Renderer> value();
	
}
