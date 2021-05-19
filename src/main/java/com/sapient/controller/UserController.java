package com.sapient.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.dao.UserDAO;
import com.sapient.entity.User;
import com.sapient.entity.UserProfile;
import com.sapient.interfaces.IUserDAO;
import com.sapient.params.ChangePasswordParams;
import com.sapient.params.DeleteUserParams;
import com.sapient.params.Loginparams;

/*
 * @Author  Shubham Chaudhari
 */



@RestController
@RequestMapping("/api")
public class UserController {

	private IUserDAO dao = new UserDAO(); 
	
	@GetMapping("/users")
	public List<UserProfile> getAllUsers() {
		return dao.getAllUsers(); 
	}
	
	@GetMapping("/users/{userId}")
	public UserProfile getUserById(@PathVariable String userId) {
		return dao.getUser(userId); 
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody Loginparams loginparams ) {
		return dao.loginUser(loginparams); 
	}
	
	@PostMapping("/register")
	public boolean register(@RequestBody User user ) {
		return dao.registerUser(user); 
	}
	
	
	@PutMapping("/users")
	public boolean deleteUser(@RequestBody  DeleteUserParams params) {
		return dao.deleteUser(params); 
	}
	
	
	
}

