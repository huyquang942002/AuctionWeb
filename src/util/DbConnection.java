package util;
 
import java.sql.Connection;
import java.sql.DriverManager;
 
public class DbConnection {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://us-cdbr-east-06.cleardb.net/heroku_2a4df7540abeb45?enabledTLSProtocols=TLSv1.2";
    private static final String USERNAME = "b157cde6369d2f";
    private static final String PASSWORD = "8bb7a353";

    public Connection connection = null;
    
    public DbConnection() {
		try {
			Class.forName(DRIVER).newInstance(); 
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}