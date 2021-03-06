package com.techfabric.appdao;

import java.util.List;

import com.techfabric.model.User;

public interface UserDao {
	
	boolean insertUser(User user);
	User checkForUser(String username, String password);
	User getUserById(int id);
	List<User> getUsers();
	boolean deleteUser(int id);
	boolean changePassword(int id, String password);
	boolean updateUser(User user);

}
