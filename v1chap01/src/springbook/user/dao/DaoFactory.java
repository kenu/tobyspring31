package springbook.user.dao;

import org.springframework.context.annotation.Configuration;


@Configuration
public class DaoFactory {

	public UserDao userDao() {
		UserDao userDao = new UserDao();
		userDao.setConnectionMaker(connectionMaker());
		return userDao;
	}

	private DConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
}
