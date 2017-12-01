package webApplication;


import java.sql.Connection;

import java.sql.DriverManager;


public class Database {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String Database_Url = "jdbc:mysql://localhost/udemy";
	private static final String user = "root";
	private static  final String password = "root";
	
	
	public static Connection getConnection() {
		try {
			//Class.forName(JDBC_DRIVER);
			Class.forName(JDBC_DRIVER);
			Connection connection = (Connection) DriverManager.getConnection(Database_Url, user, password);

		return connection;
		
	}catch  (Exception e){
		e.printStackTrace();}
		return null;

}
	


}
