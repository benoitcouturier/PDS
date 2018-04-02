package Client;
import javafx.beans.property.SimpleStringProperty;

public class DTOShopt {
	private SimpleStringProperty  ShopName;
    private SimpleStringProperty ShopID;
	private SimpleStringProperty TypeProduct;
    private SimpleStringProperty Location;
    private SimpleStringProperty Turnover;
   
    public DTOShopt (String  ShopName, String ShopID,String TypeProduct,String Location,String Turnover) {
    	this.ShopName=new SimpleStringProperty(ShopName);
    	this.ShopID=new SimpleStringProperty(ShopID);
    	this.TypeProduct=new SimpleStringProperty(TypeProduct);
    	this.Location=new SimpleStringProperty(Location);
    	this.Turnover=new SimpleStringProperty(Turnover);
    }
    
    public String getShopName() {
  		return ShopName.get();
  	}
    
  	public void setShopName(String shopName) {
  		ShopName.set(shopName);
  	}
  	
  	public String getShopID() {
  		return ShopID.get();
  	}
  	
  	public void setShopID(String shopID) {
  		ShopID.set(shopID);
  	}
  	
  	public String getTypeProduct() {
  		return TypeProduct.get();
  	}
  	
  	public void setTypeProduct(String product) {
  		TypeProduct.set(product);
  	}
  	
  	public String getLocation() {
  		return Location.get();
  	}
  	
  	public void setLocation(String location) {
  		Location.set(location);
  	}
  	
  	public String getTurnover() {
  		return Turnover.get();
  	}
  	
  	public void setTurnover(String turnover) {
  		Turnover.set(turnover);
  	}
}