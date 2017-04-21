package com.jpinto.basedepizza.daos;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jpinto.basedepizza.configs.PizzaPersistenceTest;
import com.jpinto.basedepizza.configs.TestsConfiguration;
import com.jpinto.basedepizza.model.Ingredient;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TestsConfiguration.class)
public class IngredientDAOTest extends PizzaPersistenceTest {
	
	@Autowired
	private IngredientDAO ingredientDao;
	
	public static Ingredient getDemoIngredient(){
		Ingredient ingredient = new Ingredient();
		ingredient.setName("Ananas");
		ingredient.setVegetarian(false);
		

		return ingredient;
	}
	
	@Test
	public void insertIngredient(){
		Ingredient ingredient = getDemoIngredient();
		this.ingredientDao.save(ingredient);
		Assert.assertTrue(this.ingredientDao.findOne(ingredient.getId()).getName().equals("Ananas") );
	}
}
