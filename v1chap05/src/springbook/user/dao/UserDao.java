package springbook.user.dao;

import java.util.List;

import springbook.user.domain.User;

public interface UserDao {

	public abstract void add(User user);

	public abstract User get(String id);

	public abstract void deleteAll();

	public abstract int getCount();

	public abstract List<User> getAll();

}