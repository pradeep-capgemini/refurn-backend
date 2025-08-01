package com.capgemini.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dto.AuthRequest;
import com.capgemini.entity.User;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.service.JwtService;
import com.capgemini.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/refurn")
public class ReFurnController {

	private final UserService userService;

	private final JwtService jwtService;

	private final AuthenticationManager authenticationManager;

	public ReFurnController(JwtService jwtService, AuthenticationManager authenticationManager,
			UserService userService) {
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
		this.userService = userService;
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> authenticateAndGetToken(@RequestBody AuthRequest request) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

			if (authentication.isAuthenticated()) {
				User user = userService.getUserDetails(request.getUsername());
				if (user == null) {
					throw new UserNotFoundException("User not found!");
				}

				Map<String, String> response = new HashMap<>();
				response.put("token", jwtService.generateToken(request.getUsername()));
				response.put("userType", user.getUserType());
				response.put("username", user.getUsername());
				response.put("role", user.getRole());

				return ResponseEntity.ok(response);
			} else {
				throw new UserNotFoundException("Invalid user credentials!");
			}
		} catch (AuthenticationException e) {
			throw new UserNotFoundException("Authentication failed: " + e.getMessage());
		}
	}

	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user) {
		try {
			User createdUser = userService.registerUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

}
