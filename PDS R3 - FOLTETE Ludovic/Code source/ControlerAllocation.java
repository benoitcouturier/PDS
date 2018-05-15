package allocate;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControlerAllocation {

	private Database db;
	private ArrayList<String[]> tableShop;
	private ArrayList<String[]> tablePlace;
	private ArrayList<Place> listPlace;
	private ArrayList<Shop> listShop;
	
	public ControlerAllocation(Database db) {
		this.db = db;
	}
	
	public void autoAllocate() {
		try {
			listShop = new ArrayList<Shop>();
			tableShop = db.request("shop WHERE place_id IS NULL");
			for(int i = 0; i < tableShop.size(); i++) {
				String[] ligne = tableShop.get(i); 
				listShop.add(new Shop(ligne[0], ligne[1], ligne[2], ligne[4], ligne[5]));
			}
			tableShop.clear();
			listShop.sort(null);
			
			listPlace = new ArrayList<Place>();
			tablePlace = db.request("place WHERE start_date IS NULL");
			for(int i = 0; i < tablePlace.size(); i++) {
				String[] ligne = tablePlace.get(i);
				listPlace.add(new Place(ligne[0], ligne[5], ligne[6], ligne[7]));
			}
			tablePlace.clear();
			listPlace.sort(null);
			
			ArrayList<Shop> shops = new ArrayList<Shop>();
			listShop.stream().filter(x -> x.getCompulsive()).forEach(x -> shops.add(x));
			
			ArrayList<Place> places = new ArrayList<Place>();
			listPlace.stream().filter(x -> x.getLocation().getQuality() == 1).forEach(x -> places.add(x));
			
			int n = min(shops.size(), places.size());
			for(int i = 0; i < n; i++) {
				shops.get(i).setPlace(places.get(i));
				listShop.remove(shops.get(i));
				listPlace.remove(places.get(i));
			}
			
			n = min(listPlace.size(), listShop.size());
			for(int i = 0; i < n; i++)
				listShop.get(i).setPlace(listPlace.get(i));
			
			listShop.addAll(shops);
			db.updateShop(listShop);
			System.out.println("done");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private int min(int i1, int i2) {
		if (i1 < i2)
			return i1;
		else
			return i2;
	}
}
