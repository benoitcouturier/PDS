import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ViewA {
	private  TextField login;
	private  PasswordField pass;
	private  ImageView selectedImage;
	private  Image image1;
	private  Button valide;
	private Stage stage = new Stage();
	
	public TextField getLogin() {
		return login;
	}

	public void setLogin(TextField login) {
		this.login = login;
	}

	public PasswordField getPass() {
		return pass;
	}

	public void setPass(PasswordField pass) {
		this.pass = pass;
	}

	public ImageView getSelectedImage() {
		return selectedImage;
	}

	public void setSelectedImage(ImageView selectedImage) {
		this.selectedImage = selectedImage;
	}

	public Image getImage1() {
		return image1;
	}

	public void setImage1(Image image1) {
		this.image1 = image1;
	}

	public Button getValide() {
		return valide;
	}

	public void setValide(Button valide) {
		this.valide = valide;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Stage StageAuth() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(6);
		grid.setHgap(1);
		
		login = new TextField();
		login.setPromptText("Login");
		login.setPrefColumnCount(10);
		GridPane.setConstraints(login, 0, 2);
		grid.getChildren().add(login);
		
		pass = new PasswordField();
		pass.setPromptText("password");
		pass.setPrefColumnCount(10);
		GridPane.setConstraints(pass, 0, 4);
		grid.getChildren().add(pass);
		
		
		selectedImage = new ImageView();   
        Image image1 = new Image(ViewA.class.getResourceAsStream("10.jpg"));
        selectedImage.setImage(image1);
        selectedImage.setFitHeight(200);
        selectedImage.setFitWidth(200);
        GridPane.setConstraints(selectedImage, 0, 0);
        
        grid.getChildren().add(selectedImage);
        
        valide = new Button("Valider");
        GridPane.setConstraints(valide, 0, 5);
		grid.getChildren().add(valide);
		grid.setStyle("-fx-background-color: black");
		Scene scene = new Scene(grid, 240, 350);
        stage.setTitle("Test de GridPane"); 
        stage.setScene(scene); 
        
		return stage;	
	}
}
