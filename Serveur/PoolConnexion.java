package Serveur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class PoolConnexion extends Thread {
	
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@Localhost:1521:xe";
	private static final String USER = "SYSTEM";
	private static final String PASSWORD = "USER_142";
	private static  ArrayList<Connection> pool = new ArrayList<Connection>();
	private static int connectionused=0;
	 
	public void run(){
		while (true) {
			if (connectionused>20) {
				Connection conn;
				try {
					conn = DriverManager.getConnection(URL, USER, PASSWORD);
					pool.add(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				} 	 
			}
		}
	}
	
	 public PoolConnexion() throws SQLException, ClassNotFoundException {
		 Class.forName(DRIVER_NAME);
		 System.out.println("***Driver loaded.");
		 for( int j=0;j<20;j++) {
			 Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 pool.add(conn);
		 }
	}
	 
	public void ReturnConnectionTopool(Connection conn) {
		pool.add(conn);
		connectionused--;
	}
	
	public Connection getConnexion() {
		connectionused++;
		Connection conn = pool.get(0);
		pool.remove(0);
		return conn;	
	}	
}