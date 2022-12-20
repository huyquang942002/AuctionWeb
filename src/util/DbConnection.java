package util;
 
import java.sql.Connection;
import java.sql.DriverManager;
 
public class DbConnection {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/ecom?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "trung2002";
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