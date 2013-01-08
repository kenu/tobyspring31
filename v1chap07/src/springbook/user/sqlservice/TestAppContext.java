package springbook.user.sqlservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.mail.MailSender;

import springbook.user.dao.UserDao;
import springbook.user.service.DummyMailSender;
import springbook.user.service.UserService;
import springbook.user.service.UserServiceTest.TestUserService;

@Configuration
@ImportResource("/test-applicationContext.xml")
public class TestAppContext {

	/**
	 * @return
	 */
	@Bean
	public MailSender mailSender() {
		return new DummyMailSender();
	}
	
	@Autowired
	UserDao userDao;
	
	@Bean
	public UserService testUserService() {
		return new TestUserService();
	}
	
}
