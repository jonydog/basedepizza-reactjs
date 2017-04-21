package com.jpinto.basedepizza.business.interfaces;

import java.util.List;

import org.springframework.validation.Errors;

import com.jpinto.basedepizza.model.Ingredient;
import com.jpinto.basedepizza.model.Pizza;

public interface PizzaService {

	public void createNewPizza(Pizza pizza, Errors errors);
	
	public List<Ingredient> getPizzaIngredients(Long pizzaId);
}
