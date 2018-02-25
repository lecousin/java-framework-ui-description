package net.lecousin.framework.uidescription.annotations.render;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.lecousin.framework.geometry.HorizontalAlignment;

/** Horizontal text alignment. */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TextAlign {

	/** Horizontal text alignment. */
	public HorizontalAlignment value();
	
}
