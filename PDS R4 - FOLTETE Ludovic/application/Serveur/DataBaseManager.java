import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DataBaseManager {
	
	private PoolConnexion pool;
	private static final LocalDateTime currentTime = LocalDateTime.now();
	
	public DataBaseManager(PoolConnexion pool) {
		this.pool = pool;
	}
	
	public ResultSet request(String sql) throws SQLException {
		 Connection connection = pool.getConnection();
		 Statement ordre = connection.createStatement();
		 ResultSet table = ordre.executeQuery(sql);
		 table.close();
		 ordre.close();
		 pool.ReturnConnectionTopool(connection);
		 return table;
	 }
	
	public ArrayList<String[]> select(String sql) throws SQLException {
		 Connection connection = pool.getConnection();
		 Statement ordre = connection.createStatement();
		 ResultSet rs = ordre.executeQuery(sql);
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
		pool.ReturnConnectionTopool(connection);
		return table;
	 }
	 
	 public void updateShop(ArrayList<Shop> listShop) throws SQLException {
		 Connection connection = pool.getConnection();
		 for(int i = 0; i < listShop.size(); i++) {
			 Statement ordre = connection.createStatement();
			 ordre.executeUpdate("UPDATE shop SET place_id = " + listShop.get(i).getPlace().getId() + " WHERE id = " + listShop.get(i).getId());
			 ordre.close();
			 
			 Statement ordre2 = connection.createStatement();
			 ordre2.executeUpdate("UPDATE place SET start_date = to_date('"+currentTime.getDayOfMonth()+"/"+currentTime.getMonthValue()+"/"+currentTime.getYear()+"','dd/mm/yyyy') WHERE id = " + listShop.get(i).getPlace().getId());
			 ordre2.close();
		 }
		 pool.ReturnConnectionTopool(connection);
	 }
}