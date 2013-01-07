package springbook.user.sqlservice;

import javax.sql.DataSource;

public class EmbeddedDbSqlRegistry implements SqlRegistry {
	DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public String findSql(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerSql(String key, String sql) {
		// TODO Auto-generated method stub

	}

}
