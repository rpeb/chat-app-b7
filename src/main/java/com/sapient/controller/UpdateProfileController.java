package com.sapient.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
