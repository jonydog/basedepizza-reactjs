package com.jpinto.basedepizza.daos;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jpinto.basedepizza.configs.TestsConfiguration;
import com.jpinto.basedepizza.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TestsConfiguration.class)
public class UserDAOTest {
	
	@Autowired
	private UserDAO userDao;
	
	public static User getDemoUser(){
		User user= new User();
		user.setEmail("fernando@agap2.pt");
		user.setUsername("Fernando");
		user.setPassword("123123");
		user.setPhone("912345678");
		return user;
	}
	
	@Test
	public void insertUser(){
		User user = getDemoUser();
		this.userDao.save(user);
		Assert.assertTrue(this.userDao.findOne(user.getId()).getUsername().equals("Fernando") );
	}
}
