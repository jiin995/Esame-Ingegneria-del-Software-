package dao;

public interface IConnectionFactory {
	java.sql.Connection createConnection() throws Exception;
}
