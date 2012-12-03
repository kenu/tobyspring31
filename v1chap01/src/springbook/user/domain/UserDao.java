package springbook.user.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.dao.ConnectionMaker;
import springbook.user.dao.DConnectionMaker;

public class UserDao {
	private ConnectionMaker connectionMaker;
	
	public UserDao() {
		connectionMaker = new DConnectionMaker();
	}
	
    public void add(User user) throws ClassNotFoundException, SQLException {
    	Connection c = connectionMaker.makeConnection();
    	
    	PreparedStatement ps = c.prepareStatement(
    			"insert into users(id, name, password) values(?,?,?)");
    	ps.setString(1, user.getId());
    	ps.setString(2, user.getName());
    	ps.setString(3, user.getPassword());
    	
    	ps.executeUpdate();
    	
    	ps.close();
    	c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
    	Connection c = connectionMaker.makeConnection();
    	
    	PreparedStatement ps = c.prepareStatement(
    			"select * from users where id = ?");
    	ps.setString(1, id);
    	
    	ResultSet rs = ps.executeQuery();
    	rs.next();
    	User user = new User();
    	user.setId(rs.getString("id"));
    	user.setName(rs.getString("name"));
    	user.setPassword(rs.getString("password"));
    	
    	rs.close();
    	ps.close();
    	c.close();
    	
		return user;
    }
        
}

