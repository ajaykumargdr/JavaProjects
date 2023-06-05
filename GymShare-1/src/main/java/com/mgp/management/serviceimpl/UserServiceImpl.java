package com.mgp.management.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mgp.management.model.User;
import com.mgp.management.repository.UserRepository;
import com.mgp.management.service.UserService;

// User Service Implementation
@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository){
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> getAllUsers(){
		
		return userRepository.findAll();
	}
	
	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	@Override
	public User getUser(User user) {
		return userRepository.findById(user.getUserId()).orElse(null);
	}
	
	@Override
	public void deleteUser(String userId) {
		userRepository.deleteById(userId);
	}
	
	
}
