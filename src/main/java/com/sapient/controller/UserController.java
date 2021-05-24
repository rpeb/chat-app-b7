package com.sapient.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

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
	
	@CrossOrigin(origins = "*")
	@GetMapping("/users/all")
	public List<UserProfile> getAllUsers() {
		return dao.getAllUsers(); 
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/users")
	public List<UserProfile> getActiveUsers() {
		return dao.getActiveUsers(); 
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/users/{userId}")
	public UserProfile getUserById(@PathVariable String userId) {
		return dao.getUser(userId); 
	}
	@CrossOrigin(origins = "*")
	@PostMapping("/login")
	public boolean login(@RequestBody Loginparams loginparams ) {
		return dao.loginUser(loginparams); 
	}
	@CrossOrigin(origins = "*")
	@PostMapping("/register")
	public boolean register(@RequestBody User user) {
		return dao.registerUser(user); 
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/users")
	public boolean deleteUser(@RequestBody  DeleteUserParams params) {
		return dao.deleteUser(params); 
	}
	
}

