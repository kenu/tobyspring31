package springbook.user.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class DaoFactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DaoFactory factory = new DaoFactory();
		UserDao dao1 = factory.userDao();
		UserDao dao2 = factory.userDao();

		System.out.println(dao1);
		System.out.println(dao2);

		ApplicationContext context = new GenericXmlApplicationContext(
				"applicationContext.xml");
		
		UserDao dao3 = context.getBean("userDao", UserDao.class);
		UserDao dao4 = context.getBean("userDao", UserDao.class);
		System.out.println(dao3);
		System.out.println(dao4);
	}

}
