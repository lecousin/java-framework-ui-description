package net.lecousin.framework.uidescription.resources;

import java.util.List;

import net.lecousin.framework.memory.IMemoryManageable;
import net.lecousin.framework.memory.MemoryManager;

/**
 * Class to obtain resources.
 * This class creates caches such as only one instance exists for the same resource.
 */
public class ResourcesManager implements IMemoryManageable {

	/** Get a color. */
	public static ColorDescriptor getColor(int red, int green, int blue) {
		return getColor(red, green, blue, 255);
	}

	/** Get a color. */
	public static ColorDescriptor getColor(short red, short green, short blue) {
		return getColor(red, green, blue, (short)255);
	}

	/** Get a color. */
	public static ColorDescriptor getColor(int red, int green, int blue, int alpha) {
		return getColor((short)red, (short)green, (short)blue, (short)alpha);
	}

	/** Get a color. */
	public static ColorDescriptor getColor(byte red, byte green, byte blue, byte alpha) {
		return getColor((short)(red & 0xFF), (short)(green & 0xFF), (short)(blue & 0xFF), (short)(alpha & 0xFF));
	}

	/** Get a color. */
	public static ColorDescriptor getColor(byte red, byte green, byte blue) {
		return getColor((short)(red & 0xFF), (short)(green & 0xFF), (short)(blue & 0xFF), (short)(0xFF));
	}
	
	/** Get a color. */
	@SuppressWarnings("boxing")
	public static synchronized ColorDescriptor getColor(short red, short green, short blue, short alpha) {
		ColorDescriptor descr = (ColorDescriptor)colors.get(red, green, blue, alpha);
		if (descr == null) {
			descr = new ColorDescriptor(red, green, blue, alpha);
			colors.put(descr, red, green, blue, alpha);
		}
		return descr;
	}
	
	/** Get a font. */
	@SuppressWarnings("boxing")
	public static synchronized FontDescriptor getFont(String familyName, int size, boolean bold, boolean italic) {
		FontDescriptor descr = (FontDescriptor)fonts.get(familyName, size, bold, italic);
		if (descr == null) {
			descr = new FontDescriptor(familyName, size, bold, italic);
			fonts.put(descr, familyName, size, bold, italic);
		}
		return descr;
	}

	/** Get an image from a resource path. */
	public static synchronized ImageResourcePath getImage(String path) {
		ImageResourcePath descr = (ImageResourcePath)images.get(path);
		if (descr == null) {
			descr = new ImageResourcePath(path);
			images.put(descr, path);
		}
		return descr;
	}
	
	/** Get a cursor. */
	public static synchronized CursorDescriptor getCursor(CursorDescriptor.System style) {
		CursorDescriptor descr = (CursorDescriptor)defaultCursors.get(style);
		if (descr == null) {
			descr = new CursorDescriptor(style);
			defaultCursors.put(descr, style);
		}
		return descr;
	}

	/** Get a cursor. */
	@SuppressWarnings("boxing")
	public static synchronized CursorDescriptor getCursor(ImageDescriptor img, int hotSpotX, int hotSpotY) {
		CursorDescriptor descr = (CursorDescriptor)imageCursors.get(img, hotSpotX, hotSpotY);
		if (descr == null) {
			descr = new CursorDescriptor(img, hotSpotX, hotSpotY);
			imageCursors.put(descr, img, hotSpotX, hotSpotY);
		}
		return descr;
	}
	
	private static ResourceDescriptorManager colors = new ResourceDescriptorManager();
	private static ResourceDescriptorManager fonts = new ResourceDescriptorManager();
	private static ResourceDescriptorManager images = new ResourceDescriptorManager();
	private static ResourceDescriptorManager defaultCursors = new ResourceDescriptorManager();
	private static ResourceDescriptorManager imageCursors = new ResourceDescriptorManager();
	
	static ResourcesManager instance = new ResourcesManager();
	
	private ResourcesManager() {
		MemoryManager.register(this);
	}
	
	@Override
	public String getDescription() {
		return "UI Resources descriptors";
	}
	
	@Override
	public List<String> getItemsDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void freeMemory(FreeMemoryLevel level) {
		// TODO Auto-generated method stub
	}
}
