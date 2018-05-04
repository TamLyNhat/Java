package BaiTapLon_Bai2_Trang32;

import java.sql.Connection;
import java.sql.SQLException;


//	private static final String URL = "jdbc:mysql://localhost/thisinh";
//	private static final String USERNAME = "root";
//	private static final String PASSWORD = "12345";
//	
//	 manages connection
//	public PreparedStatement selectAllPeople = null;
//	public PreparedStatement insertNewPerson = null;
//	public Connection connect;

	//public ConnectionUtils() throws ClassNotFoundException, SQLException
	//{
//		try
//		{
//			connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//			
//			// create query that selects all entries in the AddressBook
//			selectAllPeople = connect.prepareStatement("SELECT * FROM thisinh");
//			
//			// create insert that adds a new entry into the database
//			// create insert that adds a new entry into the database
//			insertNewPerson = connect.prepareStatement("INSERT INTO thisinh " + "( soBaoDanh, hoTen, dienThoai, diemLyThuyet, diemThucHanh ) " + "VALUES ( ?, ?, ?, ? )");
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//			System.exit(1);
//		}
		
		
		
	//}
	
//	public Connection getConnection() 
//	{
//		connect = null;
//		
//		try
//		{
//			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			//String url = "jdbc:odbc:driver=(SQL Server);Server=ALEXANDER\\SQLSERVER;Database=ThiSinh123;UserName=WebNet;Password=webnetwebnet";
//			this.connect = DriverManager.getConnection(URL,USERNAME,PASSWORD);
//			
//			if(connect != null)
//			{
//				System.out.print("Ket noi thanh cong!!");
//			}
//		}
//		catch(SQLException e)
//		{
//			System.out.print(e.toString() + " FAILED\n");
//			System.exit(1);
//		} 
//		return connect;
//	}
//	
//	public void close()
//	{
//		try
//		{
//			connect.close();
//		}catch(SQLException sql)
//		{
//			sql.printStackTrace();	
//		}
//	}
//}
	
public class ConnectionUtils {

	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {

		return MySQLConnUtils.getMySQLConnection();
	}


	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		System.out.println("Get connection ... ");

		Connection conn = ConnectionUtils.getMyConnection();

		System.out.println("Get connection " + conn);

		System.out.println("Done!");
	}

}
