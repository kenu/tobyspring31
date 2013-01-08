package springbook.user.sqlservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SqlServiceContext {

	@Bean
	public SqlService sqlService() {
		OxmSqlService sqlService = new OxmSqlService();
		sqlService.setUnmarshaller(unmarshaller());
		Resource resource = new ClassPathResource("springbook/user/dao/sqlmap.xml");
		sqlService.setSqlmap(resource);
		return sqlService;
	}
	
	@Bean
	public Unmarshaller unmarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("springbook.user.sqlservice.jaxb");
		return marshaller;
	}
	
}
