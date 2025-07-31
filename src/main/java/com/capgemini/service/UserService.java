package com.capgemini.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.entity.User;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public User registerUser(User user) {
		if (user.getUsername() == null || user.getEmail() == null || user.getPassword() == null) {
			throw new IllegalArgumentException("Missing required fields");
		}
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new IllegalArgumentException("Email already in use");
		}
		if (userRepository.existsByUsername(user.getUsername())) {
			throw new IllegalArgumentException("Username already taken");
		}
		if (user.getUsername().equalsIgnoreCase("ganesh") || user.getUsername().equalsIgnoreCase("pradeep")) {
			user.setRole("ADMIN");
		} else {
			user.setRole("NORMAL_USER");
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	
	public User getUserDetails(String username) {
	    return userRepository.findByUsername(username)
	        .orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));
	}
	
	

}
