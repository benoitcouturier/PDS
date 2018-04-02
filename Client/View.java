package Client;
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
	private Button select;
	private Button delete;
	private Button insert;
	private TextField name;
	private TextField name2;
	private TextField nameStoreD ;
	private TextField loginStoreD;
	private TableView table;
	private ObservableList<DTOShopt> data ;
	private TextField nameShop;
	private TextField idShop;
	private TextField typeProduct ;
	private TextField location;
	private TextField turnover;
	private ImageView selectedImage;
	private Stage arg0 = new Stage();
	
	public Stage getStage1() throws Exception {
		GridPane grid3 = new GridPane();
		selectedImage = new ImageView();   
        //Image image1 = new Image(ViewA.class.getResourceAsStream("fd.jpg"));
        //selectedImage.setImage(image1);
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
		
		idShop = new TextField();
		idShop.setPromptText("ID");
		idShop.setPrefColumnCount(10);
		GridPane.setConstraints(idShop, 2, 2);
		gridField.getChildren().add(idShop);
		
		typeProduct = new TextField();
		typeProduct.setPromptText("TypeProduct");
		typeProduct.setPrefColumnCount(10);
		GridPane.setConstraints(typeProduct, 3, 2);
		gridField.getChildren().add(typeProduct);
		
		location = new TextField();
		location.setPromptText("Location");
		location.setPrefColumnCount(10);
		GridPane.setConstraints(location, 4, 2);
		gridField.getChildren().add(location);
		
		turnover = new TextField();
		turnover.setPromptText("Turnover");
		turnover.setPrefColumnCount(10);
		GridPane.setConstraints(turnover, 5, 2);
		gridField.getChildren().add(turnover);
		
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
		
		select = new Button("SELECT");
		GridPane.setConstraints(select, 0, 0);
		gridField.getChildren().add(select);
		
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
		
		delete = new Button("Delete");
		GridPane.setConstraints(delete, 0, 1);
		gridField.getChildren().add(delete);
		table = new TableView();
		TableColumn firstNameCol = new TableColumn("Shop Name");
        TableColumn lastNameCol = new TableColumn("Shop ID");
        TableColumn emailCol = new TableColumn("TypeProduct");
        TableColumn Lc = new TableColumn("Location");
        TableColumn T = new TableColumn("Turnover");
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,Lc,T);
        
        firstNameCol.setCellValueFactory( new PropertyValueFactory<DTOShopt,String>("ShopName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<DTOShopt,String>("ShopID"));
        emailCol.setCellValueFactory(new PropertyValueFactory<DTOShopt,String>("TypeProduct"));
        Lc.setCellValueFactory(new PropertyValueFactory<DTOShopt,String>("Location"));
        T.setCellValueFactory(new PropertyValueFactory<DTOShopt,String>("Turnover"));
        
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
	
	public Button getInsert() {
		return insert;
	}

	public void setInsert(Button insert) {
		this.insert = insert;
	}

	public ObservableList<DTOShopt> getData() {
		return data;
	}
	
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

	public Button getDelete() {
		return delete;
	}

	public void setDelete(Button delete) {
		delete = delete;
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

	public TextField getNameShop() {
		return nameShop;
	}

	public void setNameShop(TextField nameShop) {
		this.nameShop = nameShop;
	}

	public TextField getIdShop() {
		return idShop;
	}

	public void setIdShop(TextField idShop) {
		idShop = idShop;
	}

	public TextField getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(TextField typeProduct) {
		typeProduct = typeProduct;
	}

	public TextField getLocation() {
		return location;
	}

	public void setLocation(TextField location) {
		location = location;
	}
	
	public Button getSelect() {
		return select;
	}

	public TextField getTurnover() {
		return turnover;
	}
	
	public void setTurnover(TextField turnover) {
		turnover = turnover;
	}

	public void setData(ObservableList<DTOShopt> data) {
		this.data = data;
	}	
}
