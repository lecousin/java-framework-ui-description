package net.lecousin.framework.uidescription.resources;

/**
 * Describe a mouse pointer cursor.
 */
public class CursorDescriptor implements ResourceDescriptor {

	/** System predefined cursors. */
	public static enum System {
		ARROW,
		WAIT,
		CROSS,
		HELP,
		SIZEALL,
		SIZENESW,
		SIZENS,
		SIZENWSE,
		SIZEWE,
		SIZEN,
		SIZES,
		SIZEE,
		SIZEW,
		SIZENE,
		SIZESE,
		SIZESW,
		SIZENW,
		UPARROW,
		IBEAM,
		NO,
		HAND
	}
	
	/** Constructor for a system cursor. */
	public CursorDescriptor(System style) {
		this.style = style;
	}
	
	/** Constructor for a custom cursor. */
	public CursorDescriptor(ImageDescriptor img, int hotSpotX, int hotSpotY) {
		this.img = img;
		this.hotSpotX = hotSpotX;
		this.hotSpotY = hotSpotY;
	}
	
	System style;
	ImageDescriptor img;
	int hotSpotX;
	int hotSpotY;
	
	public System getStyle() { return style; }
	
	public ImageDescriptor getImage() { return img; }
	
	public int getHotSpotX() { return hotSpotX; }
	
	public int getHotSpotY() { return hotSpotY; }
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof CursorDescriptor)) return false;
		CursorDescriptor c = (CursorDescriptor)obj;
		if (img == null) return c.img == null && c.style == style;
		return img.equals(c.img) && hotSpotX == c.hotSpotX && hotSpotY == c.hotSpotY;
	}
	
	@Override
	public int hashCode() {
		if (img == null) return style.ordinal();
		return img.hashCode();
	}
	
}
