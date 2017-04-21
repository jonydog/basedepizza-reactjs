package com.jpinto.basedepizza.daos;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jpinto.basedepizza.configs.TestsConfiguration;
import com.jpinto.basedepizza.model.Ingredient;
import com.jpinto.basedepizza.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TestsConfiguration.class)
public class PizzaDAOTest {
	
	@Autowired
	private PizzaDAO pizzaDao;
	
	@Autowired
	private IngredientDAO ingredientDao;
	
	
	public static Pizza getDemoPizza(){
		Pizza pizza= new Pizza();
		List<Ingredient> ingredientList = new ArrayList<Ingredient>();
		Ingredient ingredient1= new Ingredient("Pepperoni", false);
		Ingredient ingredient2= new Ingredient("mushrooms", true);
		ingredientList.add(ingredient1);
		ingredientList.add(ingredient2);
		pizza.setDescription("Pizza mesmo fixe ");
		pizza.setName("TestPizza");
		pizza.setIsVegetarian(false);
		pizza.setPriceInEuros(9.80f);
		pizza.setIngredients(ingredientList);
		
		return pizza;
	}
	
	@Test
	public void insertPizza(){
		Pizza pizza = getDemoPizza();
		for(int i= 0; i < pizza.getIngredients().size(); i++)
				this.ingredientDao.save(pizza.getIngredients().get(i));
		this.pizzaDao.save(pizza);
		Assert.assertTrue(this.pizzaDao.findOne(pizza.getId()).getName().equals("TestPizza") );
	}
}
