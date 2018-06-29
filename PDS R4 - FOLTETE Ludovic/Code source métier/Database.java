package allocate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Database {
	// Nom du pilote (driver)
	 private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	 private static final String URL = "jdbc:oracle:thin:@Localhost:1521:xe";
	 private static final String USER = "SYSTEM";
	 private static final String PASSWORD = "USER_142";

	 static {
	 // Chargement du pilote n'aura lieu qu'une seule fois
		 try {
		 Class.forName(DRIVER_NAME).newInstance();
		 System.out.println("*** Driver loaded.");
		 }
		 catch (ClassNotFoundException e) {
		 System.err.println("*** ERROR: Driver " + DRIVER_NAME + " not found");
		 }
		 catch (InstantiationException e) {
		 System.err.println("*** ERROR: Impossible to create an instance of " + DRIVER_NAME);
		 System.err.println(e.getMessage());
		 }
		 catch (IllegalAccessException e) {
		 System.err.println("*** ERROR: Impossible to create an instance of " + DRIVER_NAME);
		 System.err.println(e.getMessage());
		 }
	 }
	 
	 public static Connection getConnection() throws SQLException {
		 System.out.println("Connexion établie");
		 return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	 
	 public ArrayList<String[]> request(String sql) throws SQLException {
		 Connection connexion = Database.getConnection();
		 Statement ordre = connexion.createStatement();
		 ResultSet rs = ordre.executeQuery("SELECT * FROM " + sql);
		 ResultSetMetaData rsmd = rs.getMetaData();
		 ArrayList<String[]> table = new ArrayList<String[]>();
		
		 while (rs.next()) {
			String[] ligne = new String[rsmd.getColumnCount()] ;
			for(int i = 0; i < rsmd.getColumnCount(); i++) {
				ligne[i] = rs.getString(i+1);
			}
			table.add(ligne);
		}
		rs.close();
		ordre.close();
		connexion.close();
		return table;
	 }
	 
	 public void updateShop(ArrayList<Shop> listShop) throws SQLException {
		 Connection connexion = Database.getConnection();
		 for(int i = 0; i < listShop.size(); i++) {
			 Statement ordre = connexion.createStatement();
			 ordre.executeUpdate("UPDATE shop SET place_id = " + listShop.get(i).getPlace().getId() + " WHERE id = " + listShop.get(i).getId());
			 ordre.close();
			 
			 Statement ordre2 = connexion.createStatement();
			 ordre2.executeUpdate("UPDATE place SET start_date = to_date('28/06/18','dd/mm/yy') WHERE id = " + listShop.get(i).getPlace().getId());
			 ordre2.close();
		 }
		 connexion.close();
	 }
}