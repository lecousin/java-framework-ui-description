package net.lecousin.framework.uidescription.resources;

/** Image from a resource path. */
public class ImageResourcePath implements ResourceDescriptor, ImageDescriptor {

	/** Constructor. */
	ImageResourcePath(String path) {
		this.path = path;
	}
	
	String path;
	
	public String getPath() { return path; }
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ImageResourcePath)) return false;
		return path.equals(((ImageResourcePath)obj).path);
	}
	
	@Override
	public int hashCode() {
		return path.hashCode();
	}
	
	@Override
	public String toString() {
		return "ImageDescriptor[" + path + "]";
	}

}
