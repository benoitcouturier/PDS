package allocate;

public class Shop implements Comparable<Shop> {

	private int id;
	private String name;
	private float turnover;
	private Place place;
	private String type;
	private boolean compulsive;
	
	
	public Shop(String id, String name, String turnover, String type, String compulsive) {
		this.id = Integer.parseInt(id);
		this.name = name;
		this.turnover = Float.parseFloat(turnover);
		this.type = type;
		this.place = null;
		if(compulsive.equals("0"))
			this.compulsive = false;
		else
			this.compulsive = true;
	}

	
	public int compareTo(Shop o) {
		if(this.turnover > o.getTurnover())
			return -1;
		else if(this.turnover == o.getTurnover())
			return 0;
		else
			return 1;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Place getPlace() {
		return this.place;
	}
	
	public float getTurnover() {
		return this.turnover;
	}
	
	public boolean getCompulsive() {
		return this.compulsive;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setPlace(Place place) {
		this.place = place;
	}
	
	public String toString() {
		return name+" | "+turnover+" | "+place;
	}
}
