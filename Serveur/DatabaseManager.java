package Serveur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
	
	public ResultSet Select(PoolConnexion pool2) throws ClassNotFoundException, SQLException {   
		Connection  conn = pool2.getConnexion();
		Statement state = conn.createStatement();
	    ResultSet result = state.executeQuery("SELECT * FROM SHOP");
	    pool2.ReturnConnectionTopool(conn);
		return result ;
	}
	
	public int Delect(String string,PoolConnexion pool2) throws ClassNotFoundException, SQLException {   
		Connection  conn = pool2.getConnexion();
		Statement state = conn.createStatement();
	    int result = state.executeUpdate("DELETE FROM SHOP where SHOPNAME = '"+string+"'");
	    pool2.ReturnConnectionTopool(conn);
		return result ;
	}
	
	public int Delect2(String string,PoolConnexion pool2) throws ClassNotFoundException, SQLException {   
		Connection  conn = pool2.getConnexion();
		Statement state = conn.createStatement();
	    int result = state.executeUpdate("DELETE FROM SHOP where IDSHOP = '"+string+"'");
	    pool2.ReturnConnectionTopool(conn);
		return result ;
	}
	
	public ResultSet Select2(String string,PoolConnexion pool2) throws ClassNotFoundException, SQLException {   
		Connection  conn = pool2.getConnexion();
		Statement state = conn.createStatement();
	    ResultSet result = state.executeQuery("SELECT * FROM SHOP where SHOPNAME = '"+string+"'");
	    pool2.ReturnConnectionTopool(conn);
		return result ;
	}
	
	public ResultSet Select3(String string,PoolConnexion pool2) throws ClassNotFoundException, SQLException {   
		Connection  conn = pool2.getConnexion();
		Statement state = conn.createStatement();
	    ResultSet result = state.executeQuery("SELECT * FROM SHOP where IDSHOP = '"+string+"'");
	    pool2.ReturnConnectionTopool(conn);
		return result ;
	}
	
	public int INSERT(DTOShop dto,PoolConnexion pool2) throws ClassNotFoundException, SQLException {   
		Connection  conn = pool2.getConnexion();
		Statement state = conn.createStatement();
	    int result = state.executeUpdate("INSERT INTO SHOP VALUES('"+dto.getShopName()+"',"+"'"+dto.getShopID()+"',"+"'"+dto.getProduct()+"',"+"'"+dto.getLocation()+"',"+"'"+dto.getTurnover()+"')");
	    pool2.ReturnConnectionTopool(conn);
		return result ;
	}
}
