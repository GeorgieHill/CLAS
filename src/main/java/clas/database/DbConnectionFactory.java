package src.main.java.clas.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Singleton database connection factory
 * Class is singleton so we can make many db connections from just one factory
 */
public class DbConnectionFactory {
	//static reference to itself
	private static DbConnectionFactory instance = new DbConnectionFactory();
	public static final String URL = "jdbc:mysql://localhost/CLAS_TESTDB";
	public static final String USER = "root";
	public static final String PASSWORD = "";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
	
	Connection conn;
	Statement stmt;
	//private constructor
	private DbConnectionFactory() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("ERROR: Unable to Connect to Database.");
		}
		return connection;
	}	
	
	public static Connection getConnection() {
		return instance.createConnection();
	}
}