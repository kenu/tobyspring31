package springbook.user.sqlservice;

public class BaseSqlService implements SqlService {
	protected SqlReader sqlReader;
	public void setSqlReader(SqlReader sqlReader) {
		this.sqlReader = sqlReader;
	}

	protected SqlRegistry sqlRegistry;
	public void setSqlRegistry(SqlRegistry sqlRegistry) {
		this.sqlRegistry = sqlRegistry;
	}
	
	public void loadSql() {
		this.sqlReader.read(this.sqlRegistry);
	}

	public String getSql(String key) throws SqlRetrievalFailureException {
		try {
			return this.sqlRegistry.findSql(key);
		} catch (SqlNotFoundException e) {
			throw new SqlRetrievalFailureException(e);
		}
	}

}
