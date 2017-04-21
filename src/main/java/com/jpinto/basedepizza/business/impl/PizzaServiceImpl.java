package com.jpinto.basedepizza.business.impl;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.jpinto.basedepizza.business.interfaces.PizzaService;
import com.jpinto.basedepizza.daos.PizzaDAO;
import com.jpinto.basedepizza.model.Ingredient;
import com.jpinto.basedepizza.model.Pizza;
import com.jpinto.basedepizza.utils.ToErrorsAdapter;

@Service
public class PizzaServiceImpl implements PizzaService{

	@Autowired
	private PizzaDAO pizzaDao;

	@Autowired
	private Validator entityValidator;
	
	@Override
	public void createNewPizza(Pizza pizza, Errors errors) {
		

		ToErrorsAdapter.toErrors(this.entityValidator.validate(pizza), pizza, errors);	
		if(errors.hasErrors()){
			return;
		}
		this.pizzaDao.save(pizza);
		
	}

	@Override
	public List<Ingredient> getPizzaIngredients(Long pizzaId) {
	
		return this.pizzaDao.getPizzaIngredients(pizzaId).getIngredients();
	}
	
	
	

}
