package com.jpinto.basedepizza.business.interfaces;

import java.util.List;

import org.springframework.validation.Errors;

import com.jpinto.basedepizza.model.Order;
import com.jpinto.basedepizza.model.User;

public interface OrderService {
	
	public Order newOrder(Long userId, Errors errors);
	
	public void addPizzaToOrder(Long orderId, Long pizzaId, List<Long> excludedIngredients, List<Long> extraIngredients, Errors errors); 
	
	public Order getCurrentOrder(Long orderId);
	
	public void finalizeOrder(Long orderId, Errors errors);
	
}
