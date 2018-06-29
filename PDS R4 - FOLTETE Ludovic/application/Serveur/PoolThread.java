import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class PoolThread {
	private static  ArrayList<Socket> pool = new ArrayList<Socket>();
	 
	public PoolThread(int port) throws IOException {
		ServerSocket serversocket = new ServerSocket(port);
		for(int j=0; j<10; j++) {
			pool.add(serversocket.accept());
		}
		serversocket.close();
	}
	
	public void ReturnConnectionTopool(Socket socket) {
		pool.add(socket);
	}
	
	public Socket getConnexion() {
		return pool.remove(0);
	}
}
