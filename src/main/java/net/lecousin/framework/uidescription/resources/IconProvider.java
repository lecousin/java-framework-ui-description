package net.lecousin.framework.uidescription.resources;

import java.util.Arrays;

import net.lecousin.framework.geometry.HorizontalAlignment;
import net.lecousin.framework.geometry.VerticalAlignment;

/** Provides path to the icon for a given size. */
public interface IconProvider {

	/** Provides the icon for a given size. */
	public ImageDescriptor getIcon(int size);
	
	/** Provides all available icons. */
	public ImageDescriptor[] getIcons();
	
	/** Provides all available sizes. */
	public int[] getSizes();
	
	/** Provides icons from a predefined path. */
	public static class FromPath implements IconProvider {
		/** Constructor. */
		public FromPath(String prefix, String suffix, int... available) {
			this.prefix = prefix;
			this.suffix = suffix;
			this.available = available;
		}
		
		private String prefix;
		private String suffix;
		private int[] available;
		
		@Override
		public ImageDescriptor getIcon(int size) {
			int s = 0;
			for (int i = 0; i < available.length; ++i)
				if (available[i] <= size) s = available[i];
				else break;
			if (s == 0) return null;
			return ResourcesManager.getImage(prefix + s + suffix);
		}

		@Override
		public ImageDescriptor[] getIcons() {
			ImageDescriptor[] icons = new ImageDescriptor[available.length];
			for (int i = 0; i < available.length; ++i)
				icons[i] = ResourcesManager.getImage(prefix + available[i] + suffix);
			return icons;
		}
		
		@Override
		public int[] getSizes() {
			return Arrays.copyOf(available, available.length);
		}
	}
	
	/** Provides decorated icons. */
	public static class Decorated implements IconProvider {
		
		/** Constructor. */
		public Decorated(IconProvider main, IconProvider decoration, VerticalAlignment valign, HorizontalAlignment halign) {
			this.main = main;
			this.decoration = decoration;
			this.valign = valign;
			this.halign = halign;
		}
		
		private IconProvider main;
		private IconProvider decoration;
		private VerticalAlignment valign;
		private HorizontalAlignment halign;
		
		@Override
		public ImageDescriptor getIcon(int size) {
			ImageDescriptor m = main.getIcon(size);
			ImageDescriptor d = decoration.getIcon(size / 2);
			return new ImageDecorated(m, d, valign, halign);
		}
		
		@Override
		public ImageDescriptor[] getIcons() {
			int[] sizes = main.getSizes();
			ImageDescriptor[] icons = new ImageDescriptor[sizes.length];
			for (int i = 0; i < icons.length; ++i)
				icons[i] = new ImageDecorated(main.getIcon(sizes[i]), decoration.getIcon(sizes[i] / 2), valign, halign);
			return icons;
		}
		
		@Override
		public int[] getSizes() {
			return main.getSizes();
		}
	}
	
}
