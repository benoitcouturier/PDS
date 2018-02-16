import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class Pds {
		public Pds() {
		Class.forName("com.mysql.jdbc.Driver"); 	// loading of driver JDBC (ici MySQL)
		BoneCPConfig config = new BoneCPConfig();	// creation an object BoneCPConfig
		config.setJdbcUrl( url );			// the URL of  JDBC
		config.setUsername( nomUtilisateur );		//  Name of User
		config.setPassword( motDePasse );		// Password
			
		config.setMinConnectionsPerPartition( 5 );	// setting the minimum number of connections per partition
		config.setMaxConnectionsPerPartition( 10 );	// setting the maximum number of connections per partition
		config.setPartitionCount( 2 );			// setting the number of partitions
			
		BoneCP connectionPool = new BoneCP( config ); 	// create the pool from the BoneCPConfig object
			
		
}
}
