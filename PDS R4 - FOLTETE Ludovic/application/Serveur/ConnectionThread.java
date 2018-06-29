import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionThread implements Runnable {
	private ServerSocket serversocket;
	private Socket socket;
	private Server server;
	private PoolConnexion pool;
 
	public ConnectionThread(ServerSocket serversocket, Server server, PoolConnexion pool) {
		this.serversocket = serversocket;
		this.server = server;
		this.pool=pool;
	}
	
	public void run(){
		try {
			while(true) {
				socket = serversocket.accept();
				System.out.println("client found");
				Service service = new Service(socket,server,pool);
				service.run();
			}
		} catch (IOException e) {
		e.printStackTrace();
		} 
	}
}
