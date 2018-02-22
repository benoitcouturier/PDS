import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.sun.xml.internal.ws.developer.Serialization;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControllerView {
	private EventHandler<ActionEvent> SELECT;
	private EventHandler<ActionEvent> DELETE;
	private EventHandler<ActionEvent> INSERTE;
	private Socket socket;
	private BufferedReader in;
	private PrintStream out;
	private View v;
	
	public ControllerView(View view2,BufferedReader in,PrintStream out,Socket socket ) {
		this.in=in;
		this.v=view2;
		this.out=out;
		this.socket=socket;
	}
	
	public void Control() {
		SELECT = e ->{

			 if (v.getName().getText().equals("") && v.getName2().getText().equals("")) {
					try {
				    System.out.println("SELECT"); 
	                out.println("select");
	                out.flush();
	                String res;
	                Serialisation sr = new Serialisation();
	                res= in.readLine();
	                System.out.println(res);
	                v.getData().clear();
	                int i=0;
	                if(res.equals("Null")) {
	                	
	                }
	                else {
	                while(res != null){
	                	System.out.println("fed");
	                	JSONObject object =new JSONObject();
						object = sr.deserialisation(res);
						DTOShopt dto = new DTOShopt((String)object.get("ShopName"),(String)object.get("ShopID"),(String)object.get("Product"),(String)object.get("Location"),(String)object.get("Turnover"));
						v.getData().add(dto);
						System.out.println(object);
	               	 if(in.ready()){
	               	 res=in.readLine();
	               	 }else{
	                	break;
	               	 }
	               	 
	               	 }
	                }
	               	
	              
	                
	                }catch(Exception e6) {}
			 }
			 
			 else if (v.getName2().getText().equals("")) {
					try {
					    System.out.println("SELECT1"); 
		                out.println("select1");
		                out.flush();
		                out.println(v.getName().getText());
		                out.flush();
		                String res;
		                Serialisation sr = new Serialisation();
		                res= in.readLine();
		                System.out.println(res);
		                v.getData().clear();
		                if(res.equals("Null")) {
		                	
		                }
		                else {
		                while(res != null){
		                	System.out.println("fed");
		                	JSONObject object =new JSONObject();
							object = sr.deserialisation(res);
							DTOShopt dto = new DTOShopt((String)object.get("ShopName"),(String)object.get("ShopID"),(String)object.get("Product"),(String)object.get("Location"),(String)object.get("Turnover"));
							v.getData().add(dto);
							System.out.println(object);
		               	 if(in.ready()){
		               	 res=in.readLine();
		               	 }else{
		                	break;
		               	 }
		               	 
		               	 }
		                }
		               	
		              
		                
		                }catch(Exception e6) {}
			 }
			 else if (v.getName().getText().equals("")) {
					try {
					    System.out.println("SELECT2"); 
		                out.println("select2");
		                out.flush();
		                out.println(v.getName2().getText());
		                out.flush();
		                String res;
		                Serialisation sr = new Serialisation();
		                res= in.readLine();
		                System.out.println(res);
		                v.getData().clear(); 
		                if(res.equals("Null")) {
		                	
		                }
		                else {
		                while(res != null){
		                	System.out.println("fed");
		                	JSONObject object =new JSONObject();
							object = sr.deserialisation(res);
							DTOShopt dto = new DTOShopt((String)object.get("ShopName"),(String)object.get("ShopID"),(String)object.get("Product"),(String)object.get("Location"),(String)object.get("Turnover"));
							v.getData().add(dto);
							System.out.println(object);
		               	 if(in.ready()){
		               	 res=in.readLine();
		               	 }else{
		                	break;
		               	 }
		               	 
		               	 }
		                }
		               	
		              
		                
		                }catch(Exception e6) {}
			 }
			   
		 };v.getImport().setOnAction(SELECT);
		
		DELETE = e2 ->{
          if (v.getNameStoreD().getText().equals("")) {
					System.out.println("DELET2"); 
	                out.println("DELET2");
	                out.flush();
	                out.println(v.getLoginStoreD().getText());
	                out.flush();
					}
			else if (v.getLoginStoreD().getText().equals("")) {
				System.out.println("DELET"); 
                out.println("DELET");
                out.flush();
                out.println(v.getNameStoreD().getText());
                out.flush();
				}
				
			
				
		    };v.getDelete().setOnAction(DELETE);
		    
			INSERTE = e2 ->{
				Serialisation sr = new Serialisation();
		          if (v.getIdShop().getText()!="") {
							System.out.println("DELET2"); 
							DTOShopt shop = new DTOShopt(v.getNameShop().getText(),v.getIdShop().getText(),v.getTypeProduct().getText(),v.getLocation().getText(),v.getTornuver().getText()); 
			        		JSONObject json;
							try {
								json = sr.serialisationDTO(shop);
								System.out.println(json.toJSONString());
								out.println("INSERTE");
				                out.flush();
				                out.println(json.toJSONString());
				                out.flush();
							} catch (NoSuchMethodException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SecurityException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IllegalAccessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IllegalArgumentException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (InvocationTargetException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
			                
							}
					
						
					
						
				    };v.getInsert().setOnAction(INSERTE);
		
		
		
		
	}
	
	
	
	
}
