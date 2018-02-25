package net.lecousin.framework.ui_description.annotations.render;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.lecousin.framework.geometry.HorizontalAlignment;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TextAlign {

	public HorizontalAlignment value();
	
}
