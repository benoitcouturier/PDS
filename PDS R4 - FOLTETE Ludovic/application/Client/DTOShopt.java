import javafx.beans.property.SimpleStringProperty;

public class DTOShopt {
	private SimpleStringProperty FirstName;
    private SimpleStringProperty Name;
	private SimpleStringProperty DateOfPurchase;
    private SimpleStringProperty ModeOfPurchase;
    private SimpleStringProperty Price;
    private SimpleStringProperty Profile;
    private SimpleStringProperty Product;
    private SimpleStringProperty Operation;
    public DTOShopt () {
    	this.FirstName=new SimpleStringProperty();
    	this.Name=new SimpleStringProperty();
    	this.DateOfPurchase=new SimpleStringProperty();
    	this.ModeOfPurchase=new SimpleStringProperty();
    	this.Price=new SimpleStringProperty();
    	this.Profile=new SimpleStringProperty();
    	this.Product=new SimpleStringProperty();
    	this.Operation=new SimpleStringProperty();
    }
    public DTOShopt (String  FirstName, String Name,String DateOfPurchase,String ModeOfPurchase,String Price,String Profile,String Product,String Operation) {
    	this.FirstName=new SimpleStringProperty(FirstName);
    	this.Name=new SimpleStringProperty(Name);
    	this.DateOfPurchase=new SimpleStringProperty(DateOfPurchase);
    	this.ModeOfPurchase=new SimpleStringProperty(ModeOfPurchase);
    	this.Price=new SimpleStringProperty(Price);
    	this.Profile=new SimpleStringProperty(Profile);
    	this.Product=new SimpleStringProperty(Product);
    	this.Operation=new SimpleStringProperty(Operation);
    }
    public String getOperation() {
  		return Operation.get();
  	}
  	public void setOperation(String Operation) {
  		this.Operation.set(Operation);
  	}
    public String getFirstName() {
  		return FirstName.get();
  	}
  	public void setFirstName(String FirstName2) {
  		FirstName.set(FirstName2);
  	}
  	public String getName() {
  		return Name.get();
  	}
  	public void setName(String x) {
  		Name.set(x);
  	}
  	public String getDateOfPurchase() {
  		return DateOfPurchase.get();
  	}
  	public void setDateOfPurchase(String x) {
  		DateOfPurchase.set(x);
  	}
  	public String getModeOfPurchase() {
  		return ModeOfPurchase.get();
  	}
  	public void setModeOfPurchase(String x) {
  		ModeOfPurchase.set(x);
  	}
  	public String getPrice() {
  		return Price.get();
  	}
  	public void setPrice(String x) {
  		this.Price.set(x);
  	}
 	public String getProfile() {
  		return Profile.get();
  	}
  	public void setProfile(String x) {
  		Profile.set(x);
  	}
	public String getProduct() {
  		return Product.get();
  	}
  	public void setProduct(String x) {
  		Product.set(x);
  	}
    
}
