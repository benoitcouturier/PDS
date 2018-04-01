
public class DTOShop {
	private String  ShopName;
	private String ShopID;
    private String Product;
    private String Location;
    private String Turnover;
	public DTOShop(String shopName, String shopID, String product, String location, String turnover) {
		ShopName = shopName;
		ShopID = shopID;
		Product = product;
		Location = location;
		Turnover = turnover;
	}


    public DTOShop() {
		// TODO Auto-generated constructor stub
	}


	public String getShopName() {
		return ShopName;
	}
	public void setShopName(String shopName) {
		ShopName = shopName;
	}
	public String getShopID() {
		return ShopID;
	}
	public void setShopID(String shopID) {
		ShopID = shopID;
	}
	public String getProduct() {
		return Product;
	}
	public void setProduct(String product) {
		Product = product;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getTurnover() {
		return Turnover;
	}
	public void setTurnover(String turnover) {
		Turnover = turnover;
	}
}
