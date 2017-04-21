package com.jpinto.basedepizza.business.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import com.jpinto.basedepizza.business.interfaces.UserService;
import com.jpinto.basedepizza.daos.UserDAO;
import com.jpinto.basedepizza.model.User;
import com.jpinto.basedepizza.utils.ToErrorsAdapter;

@Component("utilizadores")
@Scope
public class SimpleUserService implements UserService{

	private static final Logger logger = LoggerFactory.getLogger(SimpleUserService.class);
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private Validator entityValidator;

	@Override
	@Transactional
	public void registerNewUser(User user, String confirmPassword, Errors errors) { 
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		Set<ConstraintViolation<User>> violations= this.entityValidator.validate(user);
		ToErrorsAdapter.toErrors(violations, user, errors);		
		if(errors.hasErrors()){
			return;
		}	
		if(userDao.save(user)!=null ) {	
			logger.warn("[Success] New User registered. With Name: {} and Email: {}", user.getUsername(), user.getEmail());

		} else {
			logger.warn("[Failure] New User was not registered. With Name: {} and {} Email:", user.getUsername(), user.getEmail());
			errors.reject("DB_ERROR");
		}
		
	}
	
	
	
	public org.springframework.security.core.userdetails.User buildUserForAuthentication(User user) {

		List<SimpleGrantedAuthority> authority = new ArrayList<SimpleGrantedAuthority>();
		authority.add(new SimpleGrantedAuthority("USER"));

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authority);
	}

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User u = this.userDao.getUserByEmail(arg0);
		
		return this.buildUserForAuthentication(u);
	}
	
	

}