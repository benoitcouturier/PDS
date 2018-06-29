import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class PoolConnexion  {
	
	// Nom du pilote (driver)
	 private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	 private static final String URL = "jdbc:oracle:thin:@Localhost:1521:xe";
	 private static final String USER = "SYSTEM";
	 private static final String PASSWORD = "USER_142";
	 private static ArrayList<Connection> pool = new ArrayList<Connection>();
	
	 public PoolConnexion() throws SQLException, ClassNotFoundException {
		 Class.forName(DRIVER_NAME);
		 for(int j=0;j<20;j++) {
			 Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			 pool.add(connection);
		 }
	 }
	 
	public void ReturnConnectionTopool(Connection connection) {
		pool.add(connection);
	}
	
	public Connection getConnection() {
		return pool.remove(0);	
	}	
}