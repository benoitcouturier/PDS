package Client;
import java.io.BufferedReader;
import java.io.PrintStream;

import org.json.simple.JSONObject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControllerView {
	private EventHandler<ActionEvent> SELECT;
	private EventHandler<ActionEvent> DELETE;
	private EventHandler<ActionEvent> INSERT;
	private BufferedReader in;
	private PrintStream out;
	private View v;
	
	public ControllerView(View view2, BufferedReader in, PrintStream out) {
		this.in=in;
		this.v=view2;
		this.out=out;
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
	                if(res.equals("Null")) {
	                	
	                }
	                else {
		                while (res != null) {
		                	System.out.println("fed");
		                	JSONObject object =new JSONObject();
							object = sr.deserialisation(res);
							DTOShopt dto = new DTOShopt((String)object.get("ShopName"),(String)object.get("ShopID"),(String)object.get("Product"),(String)object.get("Location"),(String)object.get("Turnover"));
							v.getData().add(dto);
							System.out.println(object);
		               	 	if (in.ready()) {
		               	 		res=in.readLine();
		               	 	} else {
		               	 		break;
		               	 	} 
	               	 	}
	                }
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} else if (v.getName2().getText().equals("")) {
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
	                	
	                } else {
		                while (res != null) {
		                	System.out.println("fed");
		                	JSONObject object =new JSONObject();
							object = sr.deserialisation(res);
							DTOShopt dto = new DTOShopt((String)object.get("ShopName"),(String)object.get("ShopID"),(String)object.get("Product"),(String)object.get("Location"),(String)object.get("Turnover"));
							v.getData().add(dto);
							System.out.println(object);
		               	 	if (in.ready()) {
		               	 		res=in.readLine();
		               	 	} else {
		               	 		break;
		               	 	}
		                }
	                }
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} else if (v.getName().getText().equals("")) {
				try {
				    System.out.println("SELECT2"); 
	                out.println("select2");
	                out.flush();
	                out.println(v.getName2().getText());
	                out.flush();
	                Serialisation sr = new Serialisation();
	                String res = in.readLine();
	                System.out.println(res);
	                v.getData().clear(); 
	                if(res.equals("Null")) {
	                	
	                } else {
	                	while (res != null) {
		                	System.out.println("fed");
		                	JSONObject object =new JSONObject();
							object = sr.deserialisation(res);
							DTOShopt dto = new DTOShopt((String)object.get("ShopName"),(String)object.get("ShopID"),(String)object.get("Product"),(String)object.get("Location"),(String)object.get("Turnover"));
							v.getData().add(dto);
							System.out.println(object);
		               	 	if (in.ready()) {
		               	 		res=in.readLine();
		               	 	} else {
		               	 		break;
		               	 	}
	               	 	}
	                }
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		};
		v.getSelect().setOnAction(SELECT);
		
		DELETE = e2 ->{
			if (v.getNameStoreD().getText().equals("")) {
				System.out.println("DELETE2"); 
	            out.println("DELETE2");
	            out.flush();
	            out.println(v.getLoginStoreD().getText());
	            out.flush();
			} else if (v.getLoginStoreD().getText().equals("")) {
				System.out.println("DELETE"); 
                out.println("DELETE");
                out.flush();
                out.println(v.getNameStoreD().getText());
                out.flush();
			}	
		}
		;v.getDelete().setOnAction(DELETE);
		    
		INSERT = e2 -> {
			Serialisation sr = new Serialisation();
          	if (v.getIdShop().getText()!="") {
          		System.out.println("DELETE2"); 
				DTOShopt shop = new DTOShopt(v.getNameShop().getText(),v.getIdShop().getText(),v.getTypeProduct().getText(),v.getLocation().getText(),v.getTurnover().getText()); 
	        	JSONObject json;
				try {
					json = sr.serialisationDTO(shop);
					System.out.println(json.toJSONString());
					out.println("INSERT");
	                out.flush();
	                out.println(json.toJSONString());
	                out.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}
          	}
          	v.getInsert().setOnAction(INSERT);
		};
	}
}