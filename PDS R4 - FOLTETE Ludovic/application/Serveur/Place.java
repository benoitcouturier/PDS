

public class Place implements Comparable<Place> {
	
	private int id;
	private double price;
	private float frequency;
	private String start_date;
	private String end_date;
	private int area;
	private int level;
	private Location location;
	
	public Place(String id, String price, String frequency, String start_date, String end_date, String area, String level, String loca) {
		this.id = Integer.parseInt(id);
		this.price = Double.parseDouble(price);
		this.frequency = Float.parseFloat(frequency);
		this.start_date = start_date;
		this.end_date = end_date;
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

	public double getPrice() {
		return price;
	}

	public float getFrequency() {
		return frequency;
	}

	public String getStart_date() {
		return start_date;
	}

	public String getEnd_date() {
		return end_date;
	}
}
