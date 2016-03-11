package ua.org.oa.khmelevskayas.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import ua.org.oa.khmelevskayas.util.PropertyUtils;

public class MySqlConnectionProvider implements ConnectionProvider{

    private static Connection connection = null;
    
    @Override
    public Connection getConnection() throws SQLException {
	
	if (connection != null && !connection.isClosed()) {
	    return connection;
	}
	
	Properties properties = PropertyUtils.getProperties();
	MysqlDataSource dataSource = new MysqlDataSource();
	
	String user = properties.getProperty("JDBC_USER");
	String password = properties.getProperty("JDBC_PASSWORD");
	
	dataSource.setURL(properties.getProperty("JDBC_URL"));
	dataSource.setUser(user);
	dataSource.setPassword(password);
	Connection connection = null;
	connection = dataSource.getConnection();
	return connection;
    }
    
}
