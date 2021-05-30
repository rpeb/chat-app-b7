package com.sapient.interfaces;

import java.time.LocalDate;

import com.sapient.entity.User;
import com.sapient.exceptions.AgeLessThan18Exception;
import com.sapient.exceptions.EmailNotValidException;
import com.sapient.exceptions.NameTooSmallException;
import com.sapient.exceptions.PasswordNotStrongException;

public interface IUpdateProfileDAO {
	//Update email
	public boolean updateEmail(String userId, String email) throws EmailNotValidException;
	
	//Update Name
	public boolean updateName(String userId, String name) throws NameTooSmallException;
	
	//Update password
	public boolean updatePassword(String userId, String password) throws PasswordNotStrongException;
	
	//Update d.o.b.
	public boolean updateDOB(String userId, String dob) throws AgeLessThan18Exception;
	
	//return user
	public User getUser(String userId);
}
