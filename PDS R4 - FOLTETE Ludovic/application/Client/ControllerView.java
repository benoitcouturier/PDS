import java.io.BufferedReader;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.sun.xml.internal.ws.developer.Serialization;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControllerView {
	private EventHandler<ActionEvent> SELECT;
	private EventHandler<ActionEvent> DELETE;
	private EventHandler<ActionEvent> INSERT;
	private EventHandler<ActionEvent> Update;
	private Socket Socket;
	private BufferedReader In;
	private PrintStream Out;
	private View ViewClient;
	private static ArrayList<String> Names = new ArrayList<String>() ;
	private static ArrayList<String> FirstName = new ArrayList<String>();
	private ArrayList<String> Profiles = new ArrayList<String>();
	
	public ControllerView(View view2,BufferedReader in,PrintStream out,Socket socket ) {
		this.In=in;
		this.ViewClient=view2;
		this.Out=out;
		this.Socket=socket;
	}

	
	public void Control() {
		DTOShopt DTO = new DTOShopt();
		Serialisation sr = new Serialisation();
		Operation operation = new Operation();
		
		SELECT = s ->{
			try {
				operation.setOperation("SELECT-SHOP");
				JSONObject object = new JSONObject();
				JSONArray array = new JSONArray();
				object = sr.serialisationDTO(operation);
				System.out.println(object.toJSONString());
				Out.println(object.toJSONString());
				Out.flush();
				String res;
				res= In.readLine();
				System.out.println(res);
				
				while(res != null) {
					array = sr.deserialisationarray(res);
					for (int p=0;p<array.size();p++) {
						JSONObject object1 = (JSONObject) array.get(p);
						DTOShopt dto = new DTOShopt((String)object1.get("FirstName"),(String)object1.get("Name"),(String)object1.get("DateOfPurchase"),(String)object1.get("ModeOfPurchase"),(String)object1.get("Price"),(String)object1.get("Profile"),(String)object1.get("Product"),(String)object1.get("Operation"));
						System.out.println(object1.toString());
						ViewClient.getData().add(dto);
						FirstName.add((String)object1.get("FirstName"));
						Names.add((String)object1.get("Name"));
					}
					if(In.ready()) {
						res=In.readLine();
					} else {
						break;
					}
				}		
				DTO.setOperation("SELECT-PLACE");
				JSONObject object2 =new JSONObject();
				JSONArray array2 = new JSONArray();
				object =sr.serialisationDTO(DTO);
				Out.println(object.toJSONString());
	            Out.flush();
	            Out.println(ViewClient.getName().getText());
	            Out.flush();
	            Out.println(ViewClient.getFirstName().getText());
	            Out.flush();
	            String res2;
	            res2 = In.readLine();
	            ViewClient.getData().clear();
	            
	            while(res2 != null){
	                		
	            	array = sr.deserialisationarray(res2);
	                for (int p=0;p<array.size();p++) {
	                	JSONObject object1 = (JSONObject) array.get(p);
	                	DTOShopt dto = new DTOShopt((String)object1.get("FirstName"),(String)object1.get("Name"),(String)object1.get("DateOfPurchase"),(String)object1.get("ModeOfPurchase"),(String)object1.get("Price"),(String)object1.get("Profile"),(String)object1.get("Product"),(String)object1.get("Operation"));		
	                	ViewClient.getData().add(dto);
						if(In.ready()){
			               	 res=In.readLine();
			            } else {
			            	break;
			            }
	                }
			   
	            }
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		};
		ViewClient.getImport().setOnAction(SELECT);
	}
}	