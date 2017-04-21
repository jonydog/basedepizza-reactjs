package com.jpinto.basedepizza.business;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.jpinto.basedepizza.business.interfaces.OrderService;
import com.jpinto.basedepizza.configs.PizzaPersistenceTest;
import com.jpinto.basedepizza.configs.TestsConfiguration;
import com.jpinto.basedepizza.daos.IngredientDAO;
import com.jpinto.basedepizza.daos.OrderDAO;
import com.jpinto.basedepizza.daos.PizzaDAO;
import com.jpinto.basedepizza.model.Ingredient;
import com.jpinto.basedepizza.model.Order;
import com.jpinto.basedepizza.model.Pizza;
import com.jpinto.basedepizza.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TestsConfiguration.class)
public class OrderServiceTest extends PizzaPersistenceTest{

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDAO orderDao;

	@Autowired
	private IngredientDAO ingredientDao;
	
	@Autowired
	private PizzaDAO pizzaDao;
	
	@Test
	@Transactional
	public void testNewOrder(){
		Long userId = 1l;
		
		
		Order order = new Order();
		Errors errors = new BeanPropertyBindingResult(order, "order");
		order = this.orderService.newOrder(userId, errors);
		Assert.assertTrue(this.orderDao.findOne(order.getId()).getOrderOwner().getId() == userId );
			
	}
	
	
	@Test
	@Transactional
	public void testAddPizzaToOrder(){
		
		Long userId = 1l;
		
		Order order = new Order();
		Errors errors = new BeanPropertyBindingResult(order, "order");
		order = this.orderService.newOrder(userId, errors);
	
		
		List<Ingredient> ingredientList = new ArrayList<Ingredient>();
		Ingredient ingredient1= new Ingredient("ananas", false);
		Ingredient ingredient2= new Ingredient("bacon", true);
		Ingredient ingredient3= new Ingredient("fiambre", false);
		Ingredient ingredient4= new Ingredient("azeitonas", true);
		ingredientList.add(ingredient1);
		ingredientList.add(ingredient2);
		ingredientList.add(ingredient3);
		ingredientList.add(ingredient4);
		this.ingredientDao.save(ingredient1);
		this.ingredientDao.save(ingredient2);
		this.ingredientDao.save(ingredient3);
		this.ingredientDao.save(ingredient4);
		
		Pizza pizza= new Pizza();
		pizza.setDescription("Pizza porreira");
		pizza.setName("PizzaAdd");
		pizza.setIsVegetarian(false);
		pizza.setPriceInEuros(9.80f);
		pizza.setIngredients(ingredientList);
		
		this.pizzaDao.save(pizza);
	
		List<Long> excludedIngredients = new ArrayList<>();
		excludedIngredients.add(1l);
		excludedIngredients.add(3l);
		List<Long> extraIngredients = new ArrayList<>();
		extraIngredients.add(1L);
		
		
		this.orderService.addPizzaToOrder(order.getId(), pizza.getId(), excludedIngredients, extraIngredients, errors);
		
	
		Assert.assertTrue(this.orderDao.findOne(order.getId()).getPizzas().get(0).getIngredients().get(2).getName().equals("pepperoni"));
			
	}

	@Test
	@Transactional
	public void testGetCurrentOrder(){
		Long userId = 1l;
		
		Order order = new Order();
		Errors errors = new BeanPropertyBindingResult(order, "order");
		order = this.orderService.newOrder(userId, errors);
		
		Order orderResult= this.orderService.getCurrentOrder(order.getId());
		
		Assert.assertTrue(order.getId() == orderResult.getId());
		
	}

	@Test
	@Transactional
	public void testFinalizeOrder(){
		Long userId = 1l;
		
		Order order = new Order();
		Errors errors = new BeanPropertyBindingResult(order, "order");
		order = this.orderService.newOrder(userId, errors);
		

		this.orderService.finalizeOrder(order.getId(), errors);
		
		Assert.assertTrue(order.getFinished());
	}
	


}
