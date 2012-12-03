package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {

	/* (non-Javadoc)
	 * @see springbook.user.dao.ConnectionMaker#makeNewConnection()
	 */
	@Override
	public Connection makeConnection() throws ClassNotFoundException,
			SQLException {
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection c = DriverManager.getConnection(
    			"jdbc:mysql://localhost/springbook?useUnicode=true&characterEncoding=UTF8&jdbcCompliantTruncation=false&useOldUTF8Behavior=true", "spring", "book");
    	return c;
	}

}
