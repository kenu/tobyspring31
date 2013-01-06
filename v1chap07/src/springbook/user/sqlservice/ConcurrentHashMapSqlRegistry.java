package springbook.user.sqlservice;

import java.util.HashMap;
import java.util.Map;

public class ConcurrentHashMapSqlRegistry implements UpdatableSqlRegistry {

	private Map<String, String> sqlMap = new HashMap<String, String>();

	@Override
	public String findSql(String key) {
		String sql = sqlMap.get(key);
		if (sql == null) {
			throw new SqlNotFoundException(key + "를 이용해서 SQL을 찾을 수 없습니다");
		} else {
			return sql;
		}
	}

	@Override
	public void registerSql(String key, String sql) {
		sqlMap.put(key, sql);
	}

	@Override
	public void updateSql(String key, String sql) {
		if(sqlMap.containsKey(key)) {
			sqlMap.put(key, sql);
		} else {
			throw new SqlUpdateFailureException(key + "를 이용해서 SQL을 찾을 수 없습니다");
		}
	}

	@Override
	public void updateSql(Map<String, String> sqlmap) {
		sqlMap.putAll(sqlmap);
	}

}
