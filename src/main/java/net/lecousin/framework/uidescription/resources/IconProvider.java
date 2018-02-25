package net.lecousin.framework.uidescription.resources;

/** Provides path to the icon for a given size. */
public interface IconProvider {

	/** Provides path to the icon for a given size. */
	public String getIcon(int size);
	
	/** Provides path to the icon for a given size, from a predefined path. */
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
		public String getIcon(int size) {
			int s = 0;
			for (int i = 0; i < available.length; ++i)
				if (available[i] <= size) s = available[i];
				else break;
			if (s == 0) return null;
			return prefix + s + suffix;
		}

	}
	
}
