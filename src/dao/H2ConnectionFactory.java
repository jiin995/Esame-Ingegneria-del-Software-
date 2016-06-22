package dao;


import java.sql.DriverManager;

public class H2ConnectionFactory implements IConnectionFactory {
	
	protected final static String DB_PATH = "./astro";
	protected final static String CONNECTION_STRING = "jdbc:h2:" + DB_PATH;
	
	@Override
	public java.sql.Connection createConnection() throws Exception {
		Class.forName("org.h2.Driver");
        return DriverManager.getConnection(CONNECTION_STRING, "sa", "");
	}
}
