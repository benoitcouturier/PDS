package Serveur;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.ResultSet;

import org.json.simple.JSONObject;

public class Service extends Thread {
	private Socket socket;
	private Server server;
	private int i;
	private ResultSet result;
	private PoolConnexion pool;

	public Service (Socket socket,Server server,int i,PoolConnexion pool) {
		this.socket=socket;
		this.server=server;
		this.i=i;
		this.pool=pool;
	}

	public void run(){
		try{
			server.getTextField().append("\nAUTHENTIFICATION  with Client is " +socket.getInetAddress().getHostAddress());
		    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    PrintStream out = new PrintStream(socket.getOutputStream());
			while(true) {
				String compte = in.readLine();
				String pass = in.readLine();
				if(compte.equals("GAMMA") && pass.equals("GAMMA")) {
					server.getTextField().append("\nConnexion successfully with "+(i+1)+" Client is " +socket.getInetAddress().getHostAddress());
					out.println("true");
					out.flush();
					break;
		    	} else {
		    		out.println("false");
					out.flush();	
					server.getTextField().append("\n error identification"+i+"Client"+socket.getInetAddress().getHostAddress());
				}
		    }
		    while(true) {
		    	String operation = in.readLine();
		    	System.out.println(operation);
		    	Serialisation serialisation = new Serialisation();
		    	JSONObject json;
		    	DatabaseManager base = new DatabaseManager();
	    		if(operation.equals("select")) {
	    			server.getTextField().append("\nSelect from "+i+"Client"+socket.getInetAddress().getHostAddress());
	    			result = base.Select(pool);
	    			if (result.next()==(false)) {
	    				out.println("Null");
	    				out.flush();
	    			}
	    			result.previous();
	    			while(result.next()){         
	    				DTOShop shop = new DTOShop(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)); 
	    				json =serialisation.serialisationDTO(shop);
	    				System.out.println(json.toJSONString());
	    				out.println(json.toJSONString());
	    				out.flush();
	    			}
	    		}
		    	else if(operation.equals("DELETE")) {
		    		System.out.println("s");
		    		String res=in.readLine();
		    		System.out.println(res);
		    		server.getTextField().append("\nDELETE from SHOP "+i+"Client"+socket.getInetAddress().getHostAddress()+"itms : "+res);
		    		int s = base.Delect(res,pool);
		        	System.out.println(s);
		        	
		    	} else if(operation.equals("DELETE2")) {
		    		String res=in.readLine();
		    		server.getTextField().append("\nDELETE from SHOP "+i+"Client"+socket.getInetAddress().getHostAddress()+"itms : "+res);
		    		System.out.println(res);
		        	int s = base.Delect2(res,pool);
		        	System.out.println(s);

		    	} else if(operation.equals("select1")) {
		    		String res=in.readLine();
		    		System.out.println(res);
		    		server.getTextField().append("\nSELECT from SHOP "+i+"Client"+socket.getInetAddress().getHostAddress()+"itms : "+res);
		    		result = base.Select2(res,pool);
		        	if (result.next()==(false)) {
		        		out.println("Null");
		        		out.flush();
		        	}
		        	result.previous();
		        	while(result.next()){         
		        		DTOShop shop = new DTOShop(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)); 
		        		json =serialisation.serialisationDTO(shop);
		        		System.out.println(json.toJSONString());
		        		out.println(json.toJSONString());
		        		out.flush();
		        	}
		    	} else if(operation.equals("select2")) {
		    		String res=in.readLine();
		    		System.out.println(res);
		    		server.getTextField().append("\nSELECT from "+i+"Client"+socket.getInetAddress().getHostAddress()+"itms : "+res);
		    		result = base.Select3(res,pool);
		        	if (result.next()==(false)) {
		        		out.println("Null");
		        		out.flush();
		        	}
		        	result.previous();
		        	while(result.next()){         
		        		DTOShop shop = new DTOShop(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)); 
		        		json =serialisation.serialisationDTO(shop);
		        		System.out.println(json.toJSONString());
		        		out.println(json.toJSONString());
		        		out.flush();
		        	}
		    	} else if(operation.equals("INSERT")) {
		    		String res=in.readLine();
		    		server.getTextField().append("\nINSERT from "+i+"Client"+socket.getInetAddress().getHostAddress()+"itms : "+res);
		    		System.out.println(res);
		    		JSONObject object =new JSONObject();
					object = serialisation.deserialisation(res);
					DTOShop dto = new DTOShop((String)object.get("ShopName"),(String)object.get("ShopID"),(String)object.get("TypeProduct"),(String)object.get("Location"),(String)object.get("Turnover"));
					base.INSERT(dto,pool);
		    	}
		    }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } 
	}
}
