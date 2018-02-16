import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


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
		 System.err.println("*** ERROR: Driver " + DRIVER_NAME + "not found");
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
	 
	 public Table request(String sql) throws SQLException {
		 Connection connexion = Database.getConnection();
		 Statement ordre = connexion.createStatement();
		 if (sql.toUpperCase().indexOf("SELECT") == 0) {
			ResultSet rs = ordre.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int[] size = new int[rsmd.getColumnCount()];
			Table table = new Table();
			String[] entete = new String[rsmd.getColumnCount()];
			for(int i = 0; i < rsmd.getColumnCount(); i++) {
				entete[i] = rsmd.getColumnLabel(i+1);
				size[i] = entete[i].length();
			}
			table.add(entete);
			while (rs.next()) {
				String[] ligne = new String[rsmd.getColumnCount()] ;
				for(int i = 0; i < rsmd.getColumnCount(); i++) {
					if(rsmd.getColumnType(i+1) == 93) {
						ligne[i] = rs.getDate(i+1).toString();
						if(ligne[i].length() > size[i])
							size[i] = ligne[i].length();
					}
					else {
						ligne[i] = rs.getString(i+1);
						if(ligne[i].length() > size[i])
							size[i] = ligne[i].length();
					}
				}
				table.add(ligne);
			}
			table.setSize(size);
			rs.close();
			ordre.close();
			connexion.close();
			return table;
		 }
		 ordre.executeUpdate(sql);
		 ordre.close();
		 connexion.close();
		 return null;
	 }
}