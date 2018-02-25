package net.lecousin.framework.ui_description.resources;

public interface IconProvider {

	public String getIcon(int size);
	
	public static class FromPath implements IconProvider {
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
