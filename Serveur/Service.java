import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JTextArea;

import org.json.simple.JSONObject;

public class Service extends Thread{
private Socket socket;
Server msg;

int i;
ResultSet result ;
PoolConnexion pool;

public Service (Socket socket,Server msg,int i,PoolConnexion pool) {
	this.socket=socket;
	this.msg=msg;
	this.i=i;
	this.pool=pool;
}

public void run(){
	try{
	msg.msg.append("\nAUTHENTIFICATION  with "+" Client is " +socket.getInetAddress().getHostAddress());
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintStream out = new PrintStream(socket.getOutputStream());
    String compte;
	while(true) {
		compte = in.readLine();
		String pass = in.readLine();
		if(compte.equals("GAMMA") && pass.equals("GAMMA")) {
			msg.msg.append("\nConnexion successfully with "+i+" Client is " +socket.getInetAddress().getHostAddress());
			out.println("true");
			out.flush();
    	break;
    	}   
		else {
			out.println("false");
			out.flush();	
			msg.msg.append("\n error identification"+i+"Client"+socket.getInetAddress().getHostAddress());
		}
    }
    String operation;
    while(true) {
    	operation = in.readLine();
    	System.out.println(operation);
    	Serialisation serialisation = new Serialisation();
    	JSONObject json;
    	ConnectionBase base = new ConnectionBase();
    		if(operation.equals("select")) {
    			msg.msg.append("\nSelect from "+i+"Client"+socket.getInetAddress().getHostAddress());
    			result = base.Select(pool);
    			if (result.next()==(false)) {
    				out.println("Null");
    				out.flush();
    			}
    			result.previous();
    			while(result.next()){         
    				DTOShop shop = new DTOShop(); 
    				shop.setShopName(result.getString(1));
    				shop.setShopID(result.getString(2));
    				shop.setProduct(result.getString(3));
    				shop.setLocation(result.getString(4));
    				shop.setTurnover(result.getString(5));
    				json =serialisation.serialisationDTO(shop);
    				System.out.println(json.toJSONString());
    				out.println(json.toJSONString());
    				out.flush();
    			}
    	
    	}
    	else if(operation.equals("DELET")) {
    		
    		System.out.println("s");
    		String res=in.readLine();
    		System.out.println(res);
    		msg.msg.append("\nDElElT from SHOP "+i+"Client"+socket.getInetAddress().getHostAddress()+"itms : "+res);
    		int s = base.Delect(res,pool);
        	System.out.println(s);
        	
   }
    	else if(operation.equals("DELET2")) {
        	
    		System.out.println("s");
    		String res=in.readLine();
    		msg.msg.append("\nDElElT from SHOP "+i+"Client"+socket.getInetAddress().getHostAddress()+"itms : "+res);
    		System.out.println(res);
        	int s = base.Delect2(res,pool);
        	System.out.println(s);
        	
 }
    	else if(operation.equals("select1")) {
    		String res=in.readLine();
    		System.out.println(res);
    		msg.msg.append("\nSELECT from SHOP "+i+"Client"+socket.getInetAddress().getHostAddress()+"itms : "+res);
    		result = base.Select2(res,pool);
        	if (result.next()==(false)) {
        		out.println("Null");
        		out.flush();
        	}
        	result.previous();
        	while(result.next()){         
        		DTOShop shop = new DTOShop(); 
        		shop.setShopName(result.getString(1));
        		shop.setShopID(result.getString(2));
        		shop.setProduct(result.getString(3));
        		shop.setLocation(result.getString(4));
        		shop.setTurnover(result.getString(5));
        		json =serialisation.serialisationDTO(shop);
        		System.out.println(json.toJSONString());
        		out.println(json.toJSONString());
        		out.flush();
        		}
    	}
    	else if(operation.equals("select2")) {
    		String res=in.readLine();
    		System.out.println(res);
    		msg.msg.append("\nSELECT from "+i+"Client"+socket.getInetAddress().getHostAddress()+"itms : "+res);
    		result = base.Select3(res,pool);
        	if (result.next()==(false)) {
        		out.println("Null");
        		out.flush();
        	}
        	result.previous();
        	while(result.next()){         
        		DTOShop shop = new DTOShop(); 
        		shop.setShopName(result.getString(1));
        		shop.setShopID(result.getString(2));
        		shop.setProduct(result.getString(3));
        		shop.setLocation(result.getString(4));
        		shop.setTurnover(result.getString(5));
        		json =serialisation.serialisationDTO(shop);
        		System.out.println(json.toJSONString());
        		out.println(json.toJSONString());
        		out.flush();
        		}
    	}
    	else if(operation.equals("INSERTE")) {
    		
    		String res=in.readLine();
    		msg.msg.append("\nINSERT from "+i+"Client"+socket.getInetAddress().getHostAddress()+"itms : "+res);
    		System.out.println(res);
    		JSONObject object =new JSONObject();
			object = serialisation.deserialisation(res);
			DTOShop dto = new DTOShop((String)object.get("ShopName"),(String)object.get("ShopID"),(String)object.get("TypeProduct"),(String)object.get("Location"),(String)object.get("Turnover"));
			base.INSERT(dto,pool);
      
    	}
    
    }
 
    } catch (Exception e) {} 
}
}
