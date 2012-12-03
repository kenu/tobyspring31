package springbook.user.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {

	public Connection makeNewConnection() throws ClassNotFoundException,
			SQLException {
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection c = DriverManager.getConnection(
    			"jdbc:mysql://localhost/springbook?useUnicode=true&characterEncoding=UTF8&jdbcCompliantTruncation=false&useOldUTF8Behavior=true", "spring", "book");
    	return c;
	}

}
