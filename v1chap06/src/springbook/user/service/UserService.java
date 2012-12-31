package springbook.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import springbook.user.domain.User;

public interface UserService {

	public void add(User user);
	@Transactional(readOnly=true)
	User get(String id);
	@Transactional(readOnly=true)
	List<User> getAll();
	void deleteAll();
	void update(User user);

	public void upgradeLevels();

}