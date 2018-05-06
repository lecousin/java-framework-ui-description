package net.lecousin.framework.uidescription.resources;

/** Color description with RGBA components. */
public class ColorDescriptor implements ResourceDescriptor {

	ColorDescriptor(short red, short green, short blue, short alpha) {
		if (red < 0 || red > 255) throw new IllegalArgumentException("Invalid value for red: " + red);
		if (green < 0 || green > 255) throw new IllegalArgumentException("Invalid value for green: " + green);
		if (blue < 0 || blue > 255) throw new IllegalArgumentException("Invalid value for blue: " + blue);
		if (alpha < 0 || alpha > 255) throw new IllegalArgumentException("Invalid value for alpha: " + alpha);
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}

	short red;
	short green;
	short blue;
	short alpha;
	
	public short getRed() { return red; }
	
	public short getGreen() { return green; }
	
	public short getBlue() { return blue; }
	
	public short getAlpha() { return alpha; }
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ColorDescriptor)) return false;
		ColorDescriptor c = (ColorDescriptor)obj;
		return c.red == red && c.green == green && c.blue == blue && c.alpha == alpha;
	}
	
	@Override
	public int hashCode() {
		return red + green + blue + alpha;
	}
	
	/**
	 * Create a color = from + to / rmainingSteps. 
	 */
	public static ColorDescriptor goTo(ColorDescriptor from, ColorDescriptor to, int remainingSteps) {
		return ResourcesManager.getColor(
			from.red + (to.red - from.red) / remainingSteps,
			from.green + (to.green - from.green) / remainingSteps,
			from.blue + (to.blue - from.blue) / remainingSteps
		);
	}
	
	/**
	 * Create an intermediate color, from one color to another, with given number of steps.
	 */
	public static ColorDescriptor goTo(ColorDescriptor from, ColorDescriptor to, int steps, int step) {
		if (step > steps) step = steps;
		if (step < 0) step = 0;
		return ResourcesManager.getColor(
			from.red + (to.red - from.red) * step / steps,
			from.green + (to.green - from.green) * step / steps,
			from.blue + (to.blue - from.blue) * step / steps
		);
	}

	/**
	 * Create an intermediate color, from one color to another, with given number of steps.
	 */
	public static ColorDescriptor goTo(ColorDescriptor from, ColorDescriptor to, long steps, long step) {
		if (step > steps) step = steps;
		if (step < 0) step = 0;
		if (steps <= 0) steps = 1;
		return ResourcesManager.getColor(
			(int)(from.red + (to.red - from.red) * step / steps),
			(int)(from.green + (to.green - from.green) * step / steps),
			(int)(from.blue + (to.blue - from.blue) * step / steps)
		);
	}
	
	/**
	 * Create a color between from and to.
	 */
	public static ColorDescriptor goTo(ColorDescriptor from, ColorDescriptor to, double pc) {
		if (pc < 0) pc = 0;
		else if (pc > 1) pc = 1;
		return ResourcesManager.getColor(
			(int)(from.red + (to.red - from.red) * pc),
			(int)(from.green + (to.green - from.green) * pc),
			(int)(from.blue + (to.blue - from.blue) * pc)
		);
	}
	
	/** Create a color based on the given one, darker or clearer. */
	public static ColorDescriptor darkerOrClearer(ColorDescriptor c, int amount) {
		if (c.red > amount || c.green > amount || c.blue > amount)
			return darker(c, amount);
		return clearer(c, amount);
	}
	
	/** Create a color darker than the given one. */
	public static ColorDescriptor darker(ColorDescriptor c, int amount) {
		int r = c.red - amount;
		int g = c.green - amount;
		int b = c.blue - amount;
		return ResourcesManager.getColor(r >= 0 ? r : 0, g >= 0 ? g : 0, b >= 0 ? b : 0);
	}
	
	/** Create a color clearer than the given one. */
	public static ColorDescriptor clearer(ColorDescriptor c, int amount) {
		int r = c.red + amount;
		int g = c.green + amount;
		int b = c.blue + amount;
		return ResourcesManager.getColor(r <= 255 ? r : 255, g <= 255 ? g : 255, b <= 255 ? b : 255);
	}
	
	/** Create a color clearer than the given one. */
	public static ColorDescriptor clearer(int r, int g, int b, int amount) {
		r += amount;
		g += amount;
		b += amount;
		return ResourcesManager.getColor(r <= 255 ? r : 255, g <= 255 ? g : 255, b <= 255 ? b : 255);
	}
	
	/** Return true if the given color is dark (all components are less than 80). */
	public static boolean isDark(ColorDescriptor c) {
		return c.blue < 80 && c.green < 80 && c.red < 80; 
	}
	
	/** Return true if the given color is dark (all components are more than 160). */
	public static boolean isClear(ColorDescriptor c) {
		return c.blue > 160 && c.green > 160 && c.red > 160; 
	}

}
