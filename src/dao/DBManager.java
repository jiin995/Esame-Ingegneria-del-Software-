package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {
	
protected static Connection connection;
	
	final protected static IConnectionFactory CONNECTION_FACTORY = new H2ConnectionFactory(); 
	
/**
 * Metodo invocato per connettersi al DB
 * @return
 */
	public static Connection getConnection() 
		{
			if (connection == null) 
			{
				try 
				{
					connection = CONNECTION_FACTORY.createConnection();
				}
				catch(Exception e) 
				{
		        		e.printStackTrace();
				}
			}
			return connection;
		}
	
/**
 * Metodo invocato per chiudere la connessione presente nella classe DBManager	
 * @throws SQLException possibile eccezzione lanciata dal metodo close
 */
	public static void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}

}
