package net.lecousin.framework.uidescription.resources;

import net.lecousin.framework.geometry.HorizontalAlignment;
import net.lecousin.framework.geometry.VerticalAlignment;

/**
 * A main image with another image as decoration.
 * Typical usage is an icon with a small add or remove icon at a corner.
 */
public class ImageDecorated implements ImageDescriptor {

	/** Constructor. */
	public ImageDecorated(ImageDescriptor main, ImageDescriptor decoration, VerticalAlignment valign, HorizontalAlignment halign) {
		this.main = main;
		this.decoration = decoration;
		this.valign = valign;
		this.halign = halign;
	}
	
	private ImageDescriptor main;
	private ImageDescriptor decoration;
	private VerticalAlignment valign;
	private HorizontalAlignment halign;
	
	public ImageDescriptor getMainImage() {
		return main;
	}
	
	public ImageDescriptor getDecorationImage() {
		return decoration;
	}
	
	public VerticalAlignment getDecorationVAlign() {
		return valign;
	}
	
	public HorizontalAlignment getDecorationHAlign() {
		return halign;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ImageDecorated)) return false;
		ImageDecorated i = (ImageDecorated)obj;
		if (!valign.equals(i.valign)) return false;
		if (!halign.equals(i.halign)) return false;
		if (!main.equals(i.main)) return false;
		if (!decoration.equals(i.decoration)) return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		return main.hashCode() + decoration.hashCode();
	}
	
}
