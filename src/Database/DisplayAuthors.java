package Database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

//trang 1189 file J22P


public class DisplayAuthors {

	/**
	 * @param args
	 */
	static final String DATABASE_URL = "jdbc:mysql://localhost/books";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connect = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try
		{
			// establish connection to database
			connect = (Connection) DriverManager.getConnection(DATABASE_URL,"root","12345");
			
			// create Statement for querying database
			statement = (Statement) connect.createStatement();
			
			// query database
			resultSet = statement.executeQuery("SELECT AuthorID, FirstName, LastName FROM Authors");
			
			// process query results
			ResultSetMetaData metaData  = (ResultSetMetaData) resultSet.getMetaData();
			int number = metaData.getColumnCount();
			System.out.println("Authors table of Books Database\n");
			
			for(int i = 1; i <= number; i++)
				System.out.print(metaData.getColumnName(i) + "\t");
			
			System.out.println();
			
			while(resultSet.next())
			{
				for(int i = 1; i <= number; i++)
					System.out.print(resultSet.getObject(i)+ "\t\t");
				System.out.println();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				resultSet.close();
				statement.close();
				connect.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
	}

}
