package springbook.user.service;

import java.util.List;

import springbook.user.domain.User;

public interface UserService {

	public void add(User user);
	User get(String id);
	List<User> getAll();
	void deleteall();
	void update(User user);

	public void upgradeLevels();

}