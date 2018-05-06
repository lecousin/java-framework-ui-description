package net.lecousin.framework.uidescription.resources;

/** Describes a font with a family name, a size, bold and italic attributes. */
public class FontDescriptor implements ResourceDescriptor {

	/** Constructor. */
	public FontDescriptor(String familyName, int size, boolean bold, boolean italic) {
		if (familyName == null) throw new IllegalArgumentException("familyName cannot be null");
		if (size < 0) throw new IllegalArgumentException("size cannot be negative: " + size);
		this.familyName = familyName;
		this.size = size;
		this.bold = bold;
		this.italic = italic;
	}
	
	String familyName;
	int size;
	boolean bold;
	boolean italic;
	
	public String getFamily() { return familyName; }
	
	public int getSize() { return size; }
	
	public boolean isBold() { return bold; }
	
	public boolean isItalic() { return italic; }
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof FontDescriptor)) return false;
		FontDescriptor f = (FontDescriptor)obj;
		return f.size == size && f.bold == bold && f.italic == italic && f.familyName.equals(familyName);
	}
	
	@Override
	public int hashCode() {
		return familyName.hashCode() + size;
	}
	
}
