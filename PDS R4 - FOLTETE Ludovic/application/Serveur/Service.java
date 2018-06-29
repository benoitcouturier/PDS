import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Service {
	private Socket socket;
	private Server server;
	private PoolConnexion pool;
	
	public Service (Socket socket ,Server server, PoolConnexion pool) {
		this.socket=socket;
		this.server=server;
		this.pool=pool;
	}
	
	public void run(){
		try {
			System.out.println("AUTHENTIFICATION");
			server.getMsg().append("\nAUTHENTIFICATION  with "+" Client is " +socket.getInetAddress().getHostAddress());
		    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    PrintStream out = new PrintStream(socket.getOutputStream());
		    String compte;
		    
			while(true) {
				compte = in.readLine();
				String password = in.readLine();
				if(compte.equals("GAMMA") && password.equals("GAMMA")) {
					server.getMsg().append("\nConnexion achieved with " +socket.getInetAddress().getHostAddress());
					out.println("true");
					out.flush();
					break;
		    	} else {
		    		out.println("false");
					out.flush();	
					server.getMsg().append("\nError in authentification of "+socket.getInetAddress().getHostAddress());
				}
		    }
		    
		    while(true) {
		    	String Operation = in.readLine();
		    	Serialisation serialisation = new Serialisation();
		    	ArrayList<Object> list = new ArrayList<Object>();
		    	DataBaseManager base = new DataBaseManager(pool);
		    	ControlerAllocation ca = new ControlerAllocation(base);
		    	ca.autoAllocate();
		    	
		    	JSONObject json = serialisation.deserialisation(Operation);
		    	System.out.println(json);
		    	if(json.get("Operation").equals("SELECT-SHOP")) {
		    		ArrayList<String[]> tableShop = base.select("SELECT * FROM shop");
					for(int i = 0; i < tableShop.size(); i++) {
						String[] ligne = tableShop.get(i); 
						list.add(new Shop(ligne[0], ligne[1], ligne[2], ligne[3], ligne[4], ligne[5]));
					}
					tableShop.clear();
					JSONArray jsonarray =serialisation.serialisationDTOArray(list);
					System.out.println(jsonarray.toJSONString());
					out.println(jsonarray.toJSONString());
					out.flush();
		    			
		    	} else if (json.get("Operation").equals("SELECT-PLACE")) {
					ArrayList<String[]> tablePlace = base.select("SELECT * FROM place");
					for(int i = 0; i < tablePlace.size(); i++) {
						String[] ligne = tablePlace.get(i);
						list.add(new Place(ligne[0], ligne[1], ligne[2], ligne[3], ligne[4], ligne[5], ligne[6], ligne[7]));
					}
					tablePlace.clear();
					JSONArray jsonarray = serialisation.serialisationDTOArray(list);
					System.out.println(jsonarray.toJSONString());
					out.println(jsonarray.toJSONString());
					out.flush();
		    	}
		    }
	 
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } 
	}
}