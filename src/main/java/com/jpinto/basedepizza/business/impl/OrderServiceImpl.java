package com.jpinto.basedepizza.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.jpinto.basedepizza.business.interfaces.OrderService;
import com.jpinto.basedepizza.daos.IngredientDAO;
import com.jpinto.basedepizza.daos.OrderDAO;
import com.jpinto.basedepizza.daos.PizzaDAO;
import com.jpinto.basedepizza.daos.UserDAO;
import com.jpinto.basedepizza.model.Ingredient;
import com.jpinto.basedepizza.model.Order;
import com.jpinto.basedepizza.model.Pizza;
import com.jpinto.basedepizza.model.User;
import com.jpinto.basedepizza.utils.ToErrorsAdapter;

@Service
public class OrderServiceImpl  implements OrderService{

	@Autowired
	private Validator entityValidator;
	
	@Autowired
	private OrderDAO orderDao;
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private PizzaDAO pizzaDao;
	
	@Autowired
	private IngredientDAO ingredientDao;
	
	@Override
	public Order newOrder(Long userId, Errors errors) {
		Order order = new Order();
		User user1 = this.userDao.findOne(userId);
		order.setOrderOwner(user1);
		Date date = new Date();
		order.setOrderStartingDate(date);
		order.setPrice(0.0f);
		
		
		List<Pizza> pizzas = new ArrayList<>();
		order.setPizzas(pizzas);
		order.setFinished(false);
		
		Set<ConstraintViolation<Order>> violationsOrder= this.entityValidator.validate(order);
		ToErrorsAdapter.toErrors(violationsOrder, order, errors);		
		if(errors.hasErrors()){
			return null;
		}	
		this.orderDao.save(order);
	
		

		return order;
	}

	@Override
	public void addPizzaToOrder(Long orderId, Long pizzaId, List<Long> excludedIngredients, List<Long> extraIngredients,
			Errors errors) {
		
		Order order = this.orderDao.findOne(orderId);
		
		List<Pizza> pizzas = order.getPizzas();
		
		Pizza pizzaInitial = this.pizzaDao.findOne(pizzaId);

		List<Ingredient> ingredients = pizzaInitial.getIngredients();
		List<Ingredient> ingredientAux = new ArrayList<>();
		for(int j= 0; j < excludedIngredients.size(); j++ ){
			int excluded= excludedIngredients.get(j).intValue();
			ingredientAux.add(ingredients.get(excluded)) ;
		}
	
		for(int k = 0; k < ingredientAux.size(); k++){
			ingredients.remove(ingredientAux.get(k));
		}
		

		for(int j= 0; j < extraIngredients.size(); j++){
			Ingredient ingredientExtra = this.ingredientDao.findOne(extraIngredients.get(j));
			ingredients.add(ingredientExtra);
		}
	
		pizzaInitial.setIngredients(ingredients);
		pizzas.add(pizzaInitial);
		
		Set<ConstraintViolation<Order>> violationsPizza= this.entityValidator.validate(order);
		ToErrorsAdapter.toErrors(violationsPizza, order, errors);		
		if(errors.hasErrors()){
			return;
		}	
		
		this.pizzaDao.save(pizzaInitial);
				
		order.setPizzas(pizzas);
		order.setFinished(false);
		
		Set<ConstraintViolation<Order>> violations= this.entityValidator.validate(order);
		ToErrorsAdapter.toErrors(violations, order, errors);		
		if(errors.hasErrors()){
			return;
		}	
		orderDao.save(order);
	}


	@Override
	public Order getCurrentOrder(Long orderId) {
		return this.orderDao.findOne(orderId);
		

	}

	@Override
	public void finalizeOrder(Long orderId, Errors errors) {
		Order order = this.orderDao.findOne(orderId);
		
		order.setFinished(true);
		
		Set<ConstraintViolation<Order>> violations= this.entityValidator.validate(order);
		ToErrorsAdapter.toErrors(violations, order, errors);		
		if(errors.hasErrors()){
			return;
		}	
		
		this.orderDao.save(order);
		
		
		
	}

	
	
	
}
