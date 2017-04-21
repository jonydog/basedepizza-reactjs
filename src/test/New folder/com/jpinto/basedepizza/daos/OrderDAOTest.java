package com.jpinto.basedepizza.daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jpinto.basedepizza.configs.TestsConfiguration;
import com.jpinto.basedepizza.model.Ingredient;
import com.jpinto.basedepizza.model.Order;
import com.jpinto.basedepizza.model.Pizza;
import com.jpinto.basedepizza.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TestsConfiguration.class)
public class OrderDAOTest {
	
	@Autowired
	private OrderDAO orderDao;
	
	@Autowired
	private UserDAO userDao;

	
	public static Order getDemoOrder(){
		Order order = new Order();
		User user = new User("Pedro", "pedro@email", "912345678", "passpedro");
		Date date = new Date();
		
		Ingredient ingredient1= new Ingredient("Pepperoni", false);

		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredients.add(ingredient1);

		Pizza pizza1 = new Pizza("Americana", "Pizza fixe", 9.80F, false, ingredients);
		
		
		List<Pizza> pizzaList = new ArrayList<Pizza>();
		pizzaList.add(pizza1);

		
		order.setPrice(9.80F);

		order.setOrderStartingDate(date);
		
		order.setOrderOwner(user);
		
		order.setPizzas(pizzaList);
		return order;
	}
	
	@Test
	public void insertOrder(){
		Order order = getDemoOrder();
		
		this.userDao.save(order.getOrderOwner());
		
		this.orderDao.save(order);
		Assert.assertTrue(this.orderDao.findOne(order.getId()).getPrice()==9.80F );
	}
}
