package com.mgp.management;

import java.util.List;

public interface UserService {
	List<User> getAllUsers();
	
	public void saveUser(User user);
	
	public User getUser(User user);

	public void deleteUser(String userId);
		
}
