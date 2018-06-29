import org.grios.tableadapter.DefaultTableAdapter;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class View {
	private static ListView<String> listview = new ListView<String>();
	private static ListView<String> listviewfn = new ListView<String>();
	private Button Import;
   	private TableView myTableView;
	private TableView Table;
	ObservableList<DTOShopt> Data ;
	private TextField Name;
	private TextField FirstName;
	ImageView SelectedImage;
	private Label label1P,label2P,label3P,label4P,label5P,label6P,label7P,label8P;
	private Label label1PP,label2PP,label3PP,label4PP,label5PP,label6PP,label7PP,label8PP;
	private Label resultat;
	
	public Label getResultat() {
		return resultat;
	}

	public void setR0esultat(Label resultat) {
		label1PP = resultat;
	}

	public Label getLabel1PP() {
		return label1PP;
	}

	public void setLabel1PP(Label label1pp) {
		label1PP = label1pp;
	}

	public Label getLabel2PP() {
		return label2PP;
	}

	public void setLabel2PP(Label label2pp) {
		label2PP = label2pp;
	}

	public Label getLabel3PP() {
		return label3PP;
	}

	public void setLabel3PP(Label label3pp) {
		label3PP = label3pp;
	}

	public Label getLabel4PP() {
		return label4PP;
	}

	public void setLabel4PP(Label label4pp) {
		label4PP = label4pp;
	}

	public Label getLabel5PP() {
		return label5PP;
	}

	public void setLabel5PP(Label label5pp) {
		label5PP = label5pp;
	}

	public Label getLabel6PP() {
		return label6PP;
	}

	public void setLabel6PP(Label label6pp) {
		label6PP = label6pp;
	}

	public Label getLabel7PP() {
		return label7PP;
	}

	public void setLabel7PP(Label label7pp) {
		label7PP = label7pp;
	}

	public Label getLabel8PP() {
		return label8PP;
	}

	public void setLabel8PP(Label label8pp) {
		label8PP = label8pp;
	}

	public Label getLabel1P() {
		return label1P;
	}

	public void setLabel1P(Label label1p) {
		label1P = label1p;
	}

	public Label getLabel2P() {
		return label2P;
	}

	public void setLabel2P(Label label2p) {
		label2P = label2p;
	}

	public Label getLabel3P() {
		return label3P;
	}

	public void setLabel3P(Label label3p) {
		label3P = label3p;
	}

	public Label getLabel4P() {
		return label4P;
	}

	public void setLabel4P(Label label4p) {
		label4P = label4p;
	}

	public Label getLabel5P() {
		return label5P;
	}

	public void setLabel5P(Label label5p) {
		label5P = label5p;
	}

	public Label getLabel6P() {
		return label6P;
	}

	public void setLabel6P(Label label6p) {
		label6P = label6p;
	}

	public Label getLabel7P() {
		return label7P;
	}

	public void setLabel7P(Label label7p) {
		label7P = label7p;
	}

	public Label getLabel8P() {
		return label8P;
	}

	public void setLabel8P(Label label8p) {
		label8P = label8p;
	}
	private ObservableList<String> Items =FXCollections.observableArrayList ();
	private ObservableList<String> Items2 =FXCollections.observableArrayList ();
	
	public ObservableList<String> getItems2() {
		return Items2;
	}

	public void setItems2(ObservableList<String> items2) {
		this.Items2 = items2;
	}

	public ObservableList<String> getItems() {
		return Items;
	}
	
	public static ListView<String> getListviewfn() {
		return listviewfn;
	}

	public static void setListviewfn(ListView<String> listviewfn) {
		View.listviewfn = listviewfn;
	}
	
	public void setItems(ObservableList<String> items) {
		this.Items = items;
	}
	public ObservableList<DTOShopt> getData() {
		return Data;
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
	
	public Stage getStage1() throws Exception {
		GridPane grid3 = new GridPane();
		SelectedImage = new ImageView();   
        Image image1 = new Image(ViewA.class.getResourceAsStream("bk.jpg"));
        SelectedImage.setImage(image1);
        SelectedImage.setFitHeight(500);
        SelectedImage.setFitWidth(1160);
        grid3.getChildren().add(SelectedImage);
		GridPane gridField = new GridPane();
		gridField.setPadding(new Insets(10, 10, 10, 10));
		gridField.setVgap(5);
		gridField.setHgap(5);
		GridPane labels = new GridPane();
		labels.setPadding(new Insets(10, 10, 10, 10));
		labels.setVgap(8);
		labels.setHgap(4);
		GridPane.setConstraints(labels, 1, 4);
		gridField.getChildren().add(labels);
		
		Label resultat = new Label("");
		resultat.setFont(Font.font ("Verdana", 20));
		resultat.setTextFill(Color.DARKORANGE);
		GridPane.setConstraints(resultat, 3, 3);
		gridField.getChildren().add(resultat);
		
		Label label1 = new Label("Informatique");
		label1.setTextFill(Color.GREENYELLOW);
		GridPane.setConstraints(label1, 1, 1);
		labels.getChildren().add(label1);
		
		label1P = new Label("0%");
		label1P.setTextFill(Color.RED);
		GridPane.setConstraints(label1P, 2, 1);
		labels.getChildren().add(label1P);
		 
		label1PP = new Label("0%");
		label1PP.setTextFill(Color.MAROON);
		GridPane.setConstraints(label1PP, 3, 1);
		labels.getChildren().add(label1PP);
			
		Label label2 = new Label("Sport");
		label2.setTextFill(Color.GREENYELLOW);
		GridPane.setConstraints(label2, 1, 2);
		labels.getChildren().add(label2);
		
		 label2P = new Label("0%");
		label2P.setTextFill(Color.RED);
		GridPane.setConstraints(label2P, 2, 2);
		labels.getChildren().add(label2P);
		label2PP = new Label("0%");
		label2PP.setTextFill(Color.MAROON);
		GridPane.setConstraints(label2PP, 3, 2);
		labels.getChildren().add(label2PP);
		
		
		Label label3 = new Label("Decoration");
		label3.setTextFill(Color.GREENYELLOW);
		GridPane.setConstraints(label3, 1, 3);
		labels.getChildren().add(label3);
		
		label3P = new Label("0%");
		label3P.setTextFill(Color.RED);
		GridPane.setConstraints(label3P, 2, 3);
		labels.getChildren().add(label3P);
	
		label3PP = new Label("0%");
		label3PP.setTextFill(Color.MAROON);
		GridPane.setConstraints(label3PP, 3, 3);
		labels.getChildren().add(label3PP);
		
		Label label4 = new Label("Video-Games");
		label4.setTextFill(Color.GREENYELLOW);
		GridPane.setConstraints(label4, 1, 4);
		labels.getChildren().add(label4);
		
		label4P = new Label("0%");
		label4P.setTextFill(Color.RED);
		GridPane.setConstraints(label4P, 2, 4);
		labels.getChildren().add(label4P);
		
		label4PP = new Label("0%");
		label4PP.setTextFill(Color.MAROON);
		GridPane.setConstraints(label4PP, 3, 4);
		labels.getChildren().add(label4PP);
		
		Label label5 = new Label("TV/Sound/Photo");
		label5.setTextFill(Color.GREENYELLOW);
		GridPane.setConstraints(label5, 1, 5);
		labels.getChildren().add(label5);
		
		label5P = new Label("0%");
		label5P.setTextFill(Color.RED);
		GridPane.setConstraints(label5P, 2, 5);
		labels.getChildren().add(label5P);
		
		label5PP = new Label("0%");
		label5PP.setTextFill(Color.MAROON);
		GridPane.setConstraints(label5PP, 3, 5);
		labels.getChildren().add(label5PP);

		
		
		Label label6 = new Label("Telephony");
		label6.setTextFill(Color.GREENYELLOW);
		GridPane.setConstraints(label6, 1, 6);
		labels.getChildren().add(label6);
		
		label6P = new Label("0%");
		label6P.setTextFill(Color.RED);
		GridPane.setConstraints(label6P, 2, 6);
		labels.getChildren().add(label6P);
		
		label6PP = new Label("0%");
		label6PP.setTextFill(Color.MAROON);
		GridPane.setConstraints(label6PP, 3, 6);
		labels.getChildren().add(label6PP);

		
		Label label7 = new Label("Cars");
		label7.setTextFill(Color.GREENYELLOW);
		GridPane.setConstraints(label7, 1, 7);
		labels.getChildren().add(label7);
		
		label7PP = new Label("0%");
		label7PP.setTextFill(Color.MAROON);
		GridPane.setConstraints(label7PP, 3, 7);
		labels.getChildren().add(label7PP);

		
		label7P = new Label("0%");
		label7P.setTextFill(Color.RED);
		GridPane.setConstraints(label7P, 2, 7);
		labels.getChildren().add(label7P);
		
		Label label8 = new Label("Games");
		label8.setTextFill(Color.GREENYELLOW);
		GridPane.setConstraints(label8, 1, 8);
		labels.getChildren().add(label8);
		
		label8P = new Label("0%");
		label8P.setTextFill(Color.RED);
		GridPane.setConstraints(label8P, 2, 8);
		labels.getChildren().add(label8P);
		
		label8PP = new Label("0%");
		label8PP.setTextFill(Color.MAROON);
		GridPane.setConstraints(label8PP, 3, 8);
		labels.getChildren().add(label8PP);

		
		
		
		Name = new TextField();
		Name.setPromptText("Name");
		Name.setPrefColumnCount(10);
		GridPane.setConstraints(Name, 1, 2);
		gridField.getChildren().add(Name);
		
		listview =new ListView();
		listview.setMaxWidth(90);
		listview.setMaxHeight(60);
		GridPane.setConstraints(listview, 1, 3);
		gridField.getChildren().add(listview);
		
		listviewfn = new ListView();
		listviewfn.setMaxWidth(90);
		listviewfn.setMaxHeight(60);
		GridPane.setConstraints(listviewfn, 2, 3);
		gridField.getChildren().add(listviewfn);
		
		FirstName = new TextField();
		FirstName.setPromptText("FirstName");
		FirstName.setPrefColumnCount(10);
		GridPane.setConstraints(FirstName, 2, 2);
		gridField.getChildren().add(FirstName);
		Import = new Button("SELECT");
		GridPane.setConstraints(Import, 0, 2);
		gridField.getChildren().add(Import);
		myTableView = new TableView();
		
		Table = new TableView();
		TableColumn firstNameCol = new TableColumn("FirstName");
        TableColumn lastNameCol = new TableColumn("Name");
        TableColumn emailCol = new TableColumn("Product");
        TableColumn Lc = new TableColumn("DateOfPurchase");
        Lc.setPrefWidth(100);
        TableColumn T = new TableColumn("ModeOfPurchase");
        T.setPrefWidth(100);
        TableColumn Py = new TableColumn("Profile");
        Py.setPrefWidth(100);
        TableColumn X = new TableColumn("Price");
        
        Table.getColumns().addAll(firstNameCol, lastNameCol,emailCol,Lc,T,Py,X);
        firstNameCol.setCellValueFactory(
        	    new PropertyValueFactory<DTOShopt,String>("FirstName")
        	);
        	lastNameCol.setCellValueFactory(
        	    new PropertyValueFactory<DTOShopt,String>("Name")
        	);
        	emailCol.setCellValueFactory(
        	    new PropertyValueFactory<DTOShopt,String>("Product")
        	);
        	X.setCellValueFactory(
            	    new PropertyValueFactory<DTOShopt,String>("Price")
            	);
        	Lc.setCellValueFactory(
            	    new PropertyValueFactory<DTOShopt,String>("DateOfPurchase")
            	);
        	T.setCellValueFactory(
            	    new PropertyValueFactory<DTOShopt,String>("ModeOfPurchase")
            	);
        	Py.setCellValueFactory(
            	    new PropertyValueFactory<DTOShopt,String>("Profile")
            	);
        	
        	listview.setItems(Items);
        	
        	listviewfn.setItems(Items2);
        Data = FXCollections.observableArrayList();
        Table.setItems(Data);
        GridPane.setConstraints(Table, 3, 4);
        Table.setMinHeight(130);
        gridField.getChildren().add(Table);
	    GridPane.setConstraints(gridField, 0, 0);
	    grid3.getChildren().add(gridField);
	    grid3.setStyle("-fx-background-color: black");
	    arg0.setScene(new Scene(grid3, 1140, 500));
	    return arg0;	
	}
	
	public TextField getName() {
		return Name;
	}
	public void setName(TextField name) {
		this.Name = name;
	}
	public TextField getFirstName() {
		return FirstName;
	}
	public void setFirstName(TextField idShop) {
		FirstName = idShop;
	}

	public void setData(ObservableList<DTOShopt> data) {
		this.Data = data;
	}





	
	
	
}
