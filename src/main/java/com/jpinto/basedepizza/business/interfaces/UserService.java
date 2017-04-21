package com.jpinto.basedepizza.business.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.Errors;

import com.jpinto.basedepizza.model.User;

public interface UserService extends  UserDetailsService  {

	
	public void registerNewUser(User user, String confirmPassword, Errors errors);
	
}
