package springbook.user.sqlservice;

public interface SqlRegistry {

	String findSql(String key);
	
	public void registerSql(String key, String sql);

}
