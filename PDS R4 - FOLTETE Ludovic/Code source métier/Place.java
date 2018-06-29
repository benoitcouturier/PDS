package allocate;

public class Place implements Comparable<Place> {
	
	private int id;
	private int area;
	private int level;
	private Location location;
	
	public Place(String id, String area, String level, String loca) {
		this.id = Integer.parseInt(id);
		this.area = Integer.parseInt(area);
		this.level = Integer.parseInt(level);
		
		if(loca.equals("Midway")) {
			this.location = Location.Midway;
		} else if (loca.equals("East wing")) {
			this.location = Location.East;
		} else if (loca.equals("West wing")) {
			this.location = Location.West;
		} else if (loca.equals("North wing")) {
			this.location = Location.North;
		} else {
			System.out.println("Location without allocation !!");
		}
	}

	public int compareTo(Place o) {
		if(this.area - o.getArea() > 50)
			return -1;
		else if (o.getArea() - this.area > 50)
			return 1;
		else if (this.level < o.level)
			return -1;
		else if (this.level > o.level)
			return 1;
		else if (this.location.getQuality() > o.getLocation().getQuality())
			return -1;
		else if (this.location.getQuality() < o.getLocation().getQuality())
			return 1;
		else if (this.area > o.getArea())
			return -1;
		else if (this.area < o.getArea())
			return 1;
		else 
			return 0;
	}
	
	public int getArea() {
		return this.area;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getId() {
		return id;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public String toString() {
		return id+" | "+area+" | "+level+" | "+location.toString();
	}
}
