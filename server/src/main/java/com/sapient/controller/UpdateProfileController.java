package com.sapient.controller;

import org.springframework.web.bind.annotation.*;

import com.sapient.dao.UpdateProfileDAO;
import com.sapient.entity.User;
import com.sapient.exceptions.AgeLessThan18Exception;
import com.sapient.exceptions.EmailNotValidException;
import com.sapient.exceptions.NameTooSmallException;
import com.sapient.exceptions.PasswordNotStrongException;
import com.sapient.interfaces.IUpdateProfileDAO;

@RestController
@RequestMapping("/api")
public class UpdateProfileController {

	private IUpdateProfileDAO dao = new UpdateProfileDAO();
	@CrossOrigin(origins = "*")
	@PutMapping("/user/{userId}/email")
	public User changeEmail(@PathVariable String userId, @RequestBody User updateProfile) {
		try {
			if(dao.updateEmail(userId, updateProfile.getEmail()))
				return dao.getUser(userId);
		} catch (EmailNotValidException e) {
			e.printStackTrace();
		}
		return dao.getUser(userId);
	}
	@CrossOrigin(origins = "*")
	@PutMapping("/user/{userId}/name")
	public User changeName(@PathVariable String userId, @RequestBody User updateProfile) {
		try {

			if(dao.updateName(userId, updateProfile.getName()))
				return dao.getUser(userId);
		} catch (NameTooSmallException e) {
			e.printStackTrace();
		}
		return dao.getUser(userId);
	}
	@CrossOrigin(origins = "*")
	@PutMapping("/user/{userId}/password")
	public User changePassword(@PathVariable String userId, @RequestBody User updateProfile) {
		try {
			if(dao.updatePassword(userId, updateProfile.getPassword()))
				return dao.getUser(userId);
		} catch (PasswordNotStrongException e) {
			e.printStackTrace();
		}
		return dao.getUser(userId);
	}
	@CrossOrigin(origins = "*")
	@PutMapping("/user/{userId}/dob")
	public User changeDOB(@PathVariable String userId, @RequestBody User updateProfile) {
		try {
			if(dao.updateDOB(userId, updateProfile.getDob()))
				return dao.getUser(userId);
		} catch (AgeLessThan18Exception e) {
			e.printStackTrace();
		}
		return dao.getUser(userId);
	}
}
