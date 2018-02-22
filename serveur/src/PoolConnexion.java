import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class PoolConnexion extends Thread {
	 static String url = "jdbc:mysql://localhost:3306/shop";
	 static String user = "root";
	 static String passwd = "root";
	 static  ArrayList<Connection> pool = new ArrayList<Connection>();
	 static int Connectionused=0;
	 
	 public void run(){
		 while(true) {
			 if(Connectionused>20) {
				 Connection conn;
				try {
					conn = DriverManager.getConnection(url, user, passwd);
					pool.add(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 	 
			 }
		 }
	 }
	
	 public PoolConnexion() throws SQLException, ClassNotFoundException {
		 Class.forName("com.mysql.jdbc.Driver");
		 System.out.println("Driver O.K.");
     for( int j=0;j<20;j++) {
			 Connection conn = DriverManager.getConnection(url, user, passwd);
			 pool.add(conn);
		}
 
	 }
	public void ReturnConnectionTopool(Connection conn) {
		this.pool.add(conn);
		this.Connectionused=this.Connectionused-1;
	}
	 public Connection getConnexion() {
		 Connectionused++;
		 Connection conn = pool.get(0);
		 pool.remove(0);
		 
		 return conn;
			
		}
	
	
	
	
	
	
	
	
}