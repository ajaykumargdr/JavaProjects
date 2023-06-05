package com.mgp.management.service;

import java.util.List;

import com.mgp.management.model.User;

public interface UserService {
	List<User> getAllUsers();
	
	public void saveUser(User user);
	
	public User getUser(User user);

	public void deleteUser(String userId);
		
}
