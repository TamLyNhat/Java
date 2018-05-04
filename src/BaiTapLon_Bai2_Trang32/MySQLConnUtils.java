package BaiTapLon_Bai2_Trang32;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
	 
	 
	 public static Connection getMySQLConnection() throws SQLException,
	         ClassNotFoundException {
	     String hostName = "localhost";
	 
	     String connectionURL = "thisinh123";
	     String userName = "WebNet";
	     String password = "webnetwebnet";
	 
	     return getMySQLConnection(hostName, connectionURL, userName, password);
	 }
	 
	 public static Connection getMySQLConnection(String hostName, String dbName,
	         String userName, String password) throws SQLException,
	         ClassNotFoundException {

	     //Class.forName("com.mysql.jdbc.Driver");
	 
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	     //String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;
	 
	     //Connection conn = DriverManager.getConnection(connectionURL, userName,password);
	     
	     Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;Database="+ dbName+ ";UserName="+userName+";Password="+password+"");
	     return conn;
	 }
	}