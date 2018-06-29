import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import javafx.application.Application;
import javafx.stage.Stage;

public class Client extends Application {
	private static String localhost;
	private static int port;
	private ViewA viewA;
	private View A;
	private Socket client; 
	private InputStream in;
	public Client()  {       
        localhost = "localhost";
        port = 20013;
    }

	public void start(Stage arg0) throws Exception {
		try {
			viewA = new ViewA();
			A = new View();
			arg0=viewA.StageAuth();
			arg0.show();
		    Client client1 = new Client();
		    if(client1.connectToServer()){
		         ControllerAuthentification cA = new ControllerAuthentification(viewA,client1.getClient(),A);
		         cA.control();                 
		    } else {
		    	System.out.println("Unable to connect to the server");
	        }
		} catch (IOException e) { 
			e.printStackTrace();
	    }
	} 
	
	public boolean connectToServer() throws IOException {
		client = new Socket(localhost, port);
	    return  client.isConnected();
	}
	
	public void closeStream(){
		try {
			in.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	public void closeSocket(){
		try {
			client.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	public Socket getClient() {
		return client;
	}
	
	public static void main(String[] args) {
	launch(args);
	}
}
