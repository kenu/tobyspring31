package springbook.user.sqlservice;

import java.util.Map;

public interface UpdatableSqlRegistry extends SqlRegistry {

	void updateSql(String key, String sql);

	void updateSql(Map<String, String> sqlmap);

}
