import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Json extends Application {
	File file = new File("./text.txt");
    FileWriter fw;
    FileReader fr;
public static void main(String[] args) {
	launch(args);
}
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(3);
		grid.setHgap(3);
		
		//Defining the Name text field
		final TextField name = new TextField();
		name.setPromptText("Enter your first name.");
		name.setPrefColumnCount(10);
		GridPane.setConstraints(name, 0, 0);
		grid.getChildren().add(name);
		final TextField name1 = new TextField();
		name1.setPromptText("Enter your second name.");
		name1.setPrefColumnCount(10);
		GridPane.setConstraints(name1,0,1);
		grid.getChildren().add(name1);
		//Defining the Name text field 
		final TextArea Area = new TextArea();
		Area.setPromptText("Enter your last name.");
		GridPane.setConstraints(Area, 0, 2);
		grid.getChildren().add(Area);
		Serialisation sr = new Serialisation();
		
		Button submit = new Button("Submit");
		submit.setOnAction(new EventHandler<ActionEvent>() {
			int i=1;
			personne p = new personne();
			JSONObject text;
			@Override public void handle(ActionEvent e) {
				try {
					p.setNom(name.getText());
					p.setPrenom(name1.getText());
					i=i+1;
					text = sr.serialisationDTO(1, p);
			         				
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
		    	if(i%2==0) {
		    		try {
						fw = new FileWriter(file);
						fw.write(text.toJSONString());
						Area.setText(text.toJSONString());
					    fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		
		    		Area.setText(text.toJSONString());
		    		
		    	}
		    	else {
		    		 try {
						fr = new FileReader(file);
						String str = "";
					      int i = 0;
					      while((i = fr.read()) != -1) {
					        str += (char)i;
					        }
					      System.out.println(str);
		    	     	JSONObject object = null;
					
						object = sr.deserialisation(Area.getText());
						Area.setText("Prenom = " +object.get("Prenom")+"\n" +" Nom ="+object.get("Nom"));	
					
		    	
		    		 } catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		
		    		
		    	}
		    	
		    }
		});
		
		GridPane.setConstraints(submit, 1, 1);
		grid.getChildren().add(submit);
		final Scene scene = new Scene(grid, 800, 800);
        arg0.setTitle("Test de GridPane"); 
        arg0.setScene(scene); 
        arg0.show();
    
	
	}
}
