package springbook.user.sqlservice;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springbook.user.dao.UserDao;

import com.mysql.jdbc.Driver;

@Configuration
@EnableTransactionManagement
@ImportResource("/test-applicationContext.xml")
@ComponentScan(basePackages="springbook.user")
@Import(SqlServiceContext.class)
public class AppContext {

	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass(Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost/testdb?useUnicode=true&characterEncoding=UTF8&jdbcCompliantTruncation=false&useOldUTF8Behavior=true");
		dataSource.setUsername("spring");
		dataSource.setPassword("book");
		
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}
		
	@Autowired
	UserDao userDao;
	
}
