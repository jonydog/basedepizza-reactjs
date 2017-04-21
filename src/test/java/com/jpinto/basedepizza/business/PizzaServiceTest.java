package com.jpinto.basedepizza.business;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jpinto.basedepizza.business.interfaces.PizzaService;
import com.jpinto.basedepizza.configs.TestsConfiguration;
import com.jpinto.basedepizza.model.Ingredient;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TestsConfiguration.class)
public class PizzaServiceTest {

	@Autowired
	private PizzaService pizzaService;
	
	
	@Test
	public void testGetPizzaIngredient(){
		
		List<Ingredient> ingredients = this.pizzaService.getPizzaIngredients(1L);		
		System.out.println(ingredients);
		Assert.assertTrue( ingredients.size() == 2 );	
	}
	
	
	
}
