package src.main.java.clas.database;

import java.sql.*;

public class DBController{
	
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost/CLAS_TESTDB";
	
	final String USER = "root";
	final String PASS = "";

	Connection conn;
	Statement stmt;
	

	public DBController(){
		conn = null;
		stmt = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		}
		catch(Exception se){
			se.printStackTrace();
		}
	}
	
	public void execute(String statement){
		try{
			//Open a connection
			
			stmt = conn.createStatement();
			stmt.executeUpdate(statement);
						
		}
		catch(SQLException se){
			se.printStackTrace();		
		}		
	}
	
	//selects are non generics
	public void selectRecords(String tableName){
			
		try{
			//Create a statement to query
			stmt = conn.createStatement();
			//ResultSet rs = stmt.executeQuery(sql);
			//while(rs.next()){}
			}
			catch(SQLException se){
					se.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();		
				}
				finally{
					try{
						if(stmt != null)
							conn.close();			
					}
					catch(SQLException se){
						se.printStackTrace();		
					}

				}			
			
	}
	
}
