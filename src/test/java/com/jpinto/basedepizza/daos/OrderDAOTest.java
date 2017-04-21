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
	
	@Autowired
	private IngredientDAO ingredientDao;
	
	@Autowired
	private PizzaDAO pizzaDao;
	
	public static Order getDemoOrder(){
		Order order = new Order();
		User user = new User("Manela", "manela@gmail.com", "912345678", "passManela");
		Date date = new Date();
		
		order.setPrice(9.80F);

		order.setOrderStartingDate(date);
		
		order.setOrderOwner(user);
		
		order.setFinished(false);
		
		return order;
	}
	
	@Test
	public void insertOrder(){
		
		// ingredients
		Ingredient ingredient1= new Ingredient("Presunto", false);	
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredients.add(ingredient1);	
		for(Ingredient ingredient : ingredients)
			ingredientDao.save(ingredient);

		// pizza
		Pizza pizza1 = new Pizza("PizzaTeste", "Pizza fixe", 9.80F, false, ingredients);
		List<Pizza> pizzaList = new ArrayList<Pizza>();
		pizzaList.add(pizza1);
		for(Pizza pizza : pizzaList){
			pizzaDao.save(pizza);
		}
		
		
		Order order = getDemoOrder();
		order.setPizzas(pizzaList);
			
		this.userDao.save(order.getOrderOwner());
		this.orderDao.save(order);	
		Assert.assertTrue(this.orderDao.findOne(order.getId()).getPizzas().get(0).getName().equals("PizzaTeste") );
	}
}
