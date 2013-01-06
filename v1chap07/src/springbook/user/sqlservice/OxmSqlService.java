package springbook.user.sqlservice;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Unmarshaller;

import springbook.user.dao.UserDao;
import springbook.user.sqlservice.jaxb.SqlType;
import springbook.user.sqlservice.jaxb.Sqlmap;

public class OxmSqlService implements SqlService {
	private final OxmSqlReader oxmSqlReader = new OxmSqlReader();

	private SqlRegistry sqlRegistry = new HashMapSqlRegistry();

	public void setSqlRegistry(SqlRegistry sqlRegistry) {
		this.sqlRegistry = sqlRegistry;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.oxmSqlReader.unmarshaller = unmarshaller;
	}

	public void setSqlmapFile(String sqlmapFile) {
		this.oxmSqlReader.sqlmapFile = sqlmapFile;
	}

	@PostConstruct
	public void loadSql() {
		this.oxmSqlReader.read(this.sqlRegistry);
	}

	@Override
	public String getSql(String key) throws SqlRetrievalFailureException {
		try {
			return this.sqlRegistry.findSql(key);
		} catch (SqlNotFoundException e) {
			throw new SqlRetrievalFailureException(e);
		}
	}

	private class OxmSqlReader implements SqlReader {
		private Unmarshaller unmarshaller;

		private final static String DEFAULT_SQLMAP_FILE = "sqlmap.xml";
		private String sqlmapFile = DEFAULT_SQLMAP_FILE;

		@SuppressWarnings("unused")
		public void setUnmarshaller(Unmarshaller unmarshaller) {
			this.unmarshaller = unmarshaller;
		}

		@SuppressWarnings("unused")
		public void setSqlmapFile(String sqlmapFile) {
			this.sqlmapFile = sqlmapFile;
		}

		public void read(SqlRegistry sqlRegistry) {
			try {
				Source source = new StreamSource(
						UserDao.class.getResourceAsStream(this.sqlmapFile));
				Sqlmap sqlmap = (Sqlmap) this.unmarshaller.unmarshal(source);
				for (SqlType sql : sqlmap.getSql()) {
					sqlRegistry.registerSql(sql.getKey(), sql.getValue());
				}
			} catch (IOException e) {
				throw new IllegalArgumentException(this.sqlmapFile
						+ "을 가져올 수 없습니다.", e);
			}

		}

	}

}
