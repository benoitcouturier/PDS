

public enum Location {
	
	Midway("Midway", 1),
	North("North wing", 3),
	East("East wing", 2),
	West("West wing", 2);
	
	private String name;
	private int quality;
	
	Location(String name, int quality) {
		this.name = name;
		this.quality = quality;
	}
	
	public String toString() {
		return name;
	}
	
	public int getQuality() {
		return quality;
	}
}
