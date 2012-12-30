package springbook.user.service;

import springbook.user.domain.User;

public interface UserService {

	public void add(User user);

	public void upgradeLevels() throws Exception;

}