package Client;
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
	private TextField login;
	private PasswordField pass;
	private ImageView image;
	private Button sign;
	private Stage stage = new Stage();
	
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
		pass.setPromptText("Password");
		pass.setPrefColumnCount(10);
		GridPane.setConstraints(pass, 0, 4);
		grid.getChildren().add(pass);
		
		
		image = new ImageView();   
        //image.setImage(new Image(ViewA.class.getResourceAsStream("C:/Users/Ludov/eclipse-workspace/PDS/10.jpg")));
        image.setFitHeight(200);
        image.setFitWidth(200);
        GridPane.setConstraints(image, 0, 0);
        
        grid.getChildren().add(image);
        
        sign = new Button("Sign in");
        GridPane.setConstraints(sign, 0, 5);
		grid.getChildren().add(sign);
		grid.setStyle("-fx-background-color: black");
		Scene scene = new Scene(grid, 240, 350);
        stage.setTitle("Test de GridPane"); 
        stage.setScene(scene); 
        
		return stage;
	}
	
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
	
	public Button getSign() {
		return sign;
	}
	
	public void setSign(Button sign) {
		this.sign = sign;
	}
}