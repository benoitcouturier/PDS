import org.grios.tableadapter.DefaultTableAdapter;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class View {
	private static ListView listview;
	private Button Import;
	private Button Delete;
	private Button insert;
	private TextField name;
	public Button getInsert() {
		return insert;
	}




	public void setInsert(Button insert) {
		this.insert = insert;
	}




	private TextField name2;
	private TextField nameStoreD ;
	private TextField loginStoreD;
	private TableView myTableView;
	 private TableView table;
	 ObservableList<DTOShopt> data ;
	 private TextField nameShop;
	 private TextField IdShop;
	 private TextField TypeProduct ;
	 private TextField Location;
	 private TextField Tornuver;
	 ImageView selectedImage;




	public ObservableList<DTOShopt> getData() {
		return data;
	}




	private Stage arg0 = new Stage();
	
	public Stage getStage() {
		return arg0;
	}




	public void setStage(Stage stage) {
		this.arg0 = stage;
	}
	
	public static ListView getListview() {
		return listview;
	}




	public static void setListview(ListView listview) {
		View.listview = listview;
	}




	public Button getImport() {
		return Import;
	}




	public void setImport(Button import1) {
		Import = import1;
	}




	public Button getDelete() {
		return Delete;
	}




	public void setDelete(Button delete) {
		Delete = delete;
	}




	public TextField getName() {
		return name;
	}




	public void setName(TextField name) {
		this.name = name;
	}




	public TextField getName2() {
		return name2;
	}




	public void setName2(TextField name2) {
		this.name2 = name2;
	}




	public TextField getNameStoreD() {
		return nameStoreD;
	}




	public void setNameStoreD(TextField nameStoreD) {
		this.nameStoreD = nameStoreD;
	}




	public TextField getLoginStoreD() {
		return loginStoreD;
	}




	public void setLoginStoreD(TextField loginStoreD) {
		this.loginStoreD = loginStoreD;
	}




	public Stage getStage1() throws Exception {
		GridPane grid3 = new GridPane();
		selectedImage = new ImageView();   
        Image image1 = new Image(ViewA.class.getResourceAsStream("fd.jpg"));
        selectedImage.setImage(image1);
        selectedImage.setFitHeight(500);
        selectedImage.setFitWidth(1160);
        grid3.getChildren().add(selectedImage);
        
		GridPane gridlist = new GridPane();
		gridlist.setPadding(new Insets(100, 100, 100, 100));
		gridlist.setVgap(1);
		gridlist.setHgap(6);
		GridPane gridField = new GridPane();
		gridField.setPadding(new Insets(10, 10, 10, 10));
		gridField.setVgap(4);
		gridField.setHgap(3);
		
		nameShop = new TextField();
		nameShop.setPromptText("Shop's Name.");
		nameShop.setPrefColumnCount(10);
		GridPane.setConstraints(nameShop, 1, 2);
		gridField.getChildren().add(nameShop);
		
		IdShop = new TextField();
		IdShop.setPromptText("IDShop.");
		IdShop.setPrefColumnCount(10);
		GridPane.setConstraints(IdShop, 2, 2);
		gridField.getChildren().add(IdShop);
		
		TypeProduct = new TextField();
		TypeProduct.setPromptText("TypeProduct.");
		TypeProduct.setPrefColumnCount(10);
		GridPane.setConstraints(TypeProduct, 3, 2);
		gridField.getChildren().add(TypeProduct);
		
		Location = new TextField();
		Location.setPromptText("Location.");
		Location.setPrefColumnCount(10);
		GridPane.setConstraints(Location, 4, 2);
		gridField.getChildren().add(Location);
		
		Tornuver = new TextField();
		Tornuver.setPromptText("Turnover.");
		Tornuver.setPrefColumnCount(10);
		GridPane.setConstraints(Tornuver, 5, 2);
		gridField.getChildren().add(Tornuver);
		
		insert = new Button("INSERT");
		GridPane.setConstraints(insert, 0, 2);
		gridField.getChildren().add(insert);
		
		name = new TextField();
		name.setPromptText("Shop's Name.");
		name.setPrefColumnCount(10);
		GridPane.setConstraints(name, 1, 0);
		gridField.getChildren().add(name);
		
		 name2 = new TextField();
		name2.setPromptText("Shop's Id.");
		name2.setPrefColumnCount(10);
		GridPane.setConstraints(name2, 2, 0);
		gridField.getChildren().add(name2);
		
		Import = new Button("Import");
		GridPane.setConstraints(Import, 0, 0);
		gridField.getChildren().add(Import);
		
		 nameStoreD = new TextField();
		nameStoreD.setPromptText("shop's Name.");
		nameStoreD.setPrefColumnCount(10);
		GridPane.setConstraints(nameStoreD, 1, 1);
		gridField.getChildren().add(nameStoreD);
		
		 loginStoreD = new TextField();
		loginStoreD.setPromptText("shop's Id .");
		loginStoreD.setPrefColumnCount(10);
		GridPane.setConstraints(loginStoreD, 2, 1);
		gridField.getChildren().add(loginStoreD);
		
		Delete = new Button("Delete");
		GridPane.setConstraints(Delete, 0, 1);
		gridField.getChildren().add(Delete);
		myTableView = new TableView();
		table = new TableView();
		TableColumn firstNameCol = new TableColumn("Shop Name");
        TableColumn lastNameCol = new TableColumn("Shop ID");
        TableColumn emailCol = new TableColumn("TypeProduct");
        TableColumn Lc = new TableColumn("Location");
        TableColumn T = new TableColumn("Turnover");
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,Lc,T);
        firstNameCol.setCellValueFactory(
        	    new PropertyValueFactory<DTOShopt,String>("ShopName")
        	);
        	lastNameCol.setCellValueFactory(
        	    new PropertyValueFactory<DTOShopt,String>("ShopID")
        	);
        	emailCol.setCellValueFactory(
        	    new PropertyValueFactory<DTOShopt,String>("TypeProduct")
        	);
        	Lc.setCellValueFactory(
            	    new PropertyValueFactory<DTOShopt,String>("Location")
            	);
        	T.setCellValueFactory(
            	    new PropertyValueFactory<DTOShopt,String>("Turnover")
            	);
        data = FXCollections.observableArrayList();
        table.setItems(data);
        GridPane.setConstraints(table, 6, 3);

		  
        gridField.getChildren().add(table);
	      
	      
	    
	    GridPane.setConstraints(gridlist, 0, 1);
	    GridPane.setConstraints(gridField, 0, 0);
	    grid3.getChildren().add(gridlist);
	    grid3.getChildren().add(gridField);

	    
	    grid3.setStyle("-fx-background-color: black");
	    arg0.setScene(new Scene(grid3, 1140, 500));
	    return arg0;
	    		
		
	}




	public TextField getNameShop() {
		return nameShop;
	}




	public void setNameShop(TextField nameShop) {
		this.nameShop = nameShop;
	}




	public TextField getIdShop() {
		return IdShop;
	}




	public void setIdShop(TextField idShop) {
		IdShop = idShop;
	}




	public TextField getTypeProduct() {
		return TypeProduct;
	}




	public void setTypeProduct(TextField typeProduct) {
		TypeProduct = typeProduct;
	}




	public TextField getLocation() {
		return Location;
	}




	public void setLocation(TextField location) {
		Location = location;
	}




	public TextField getTornuver() {
		return Tornuver;
	}




	public void setTornuver(TextField tornuver) {
		Tornuver = tornuver;
	}




	public void setData(ObservableList<DTOShopt> data) {
		this.data = data;
	}





	
	
	
}
