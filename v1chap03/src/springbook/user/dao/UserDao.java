package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import springbook.user.domain.User;

public abstract class UserDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate();
		this.jdbcTemplate.setDataSource(dataSource);

		this.dataSource = dataSource;
	}

	public void add(final User user) throws SQLException {
		this.jdbcTemplate.update(
				"insert into users(id, name, password) values(?,?,?)",
				user.getId(), user.getName(), user.getPassword());
	}

	public User get(String id) {
		return this.jdbcTemplate.queryForObject(
				"select * from users where id = ?", new Object[] { id },
				new RowMapper<User>() {
					public User mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						User user = new User();
						user.setId(rs.getString("id"));
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));
						return user;
					}

				});
	}

	public void deleteAll() throws SQLException {
		this.jdbcTemplate.update("delete from users");
	}

	abstract protected PreparedStatement makeStatement(Connection c)
			throws SQLException;

	public int getCount() {
		return this.jdbcTemplate.queryForInt("select count(*) from users");
	}
}
