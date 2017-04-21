package com.jpinto.basedepizza.restcontrollers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jpinto.basedepizza.daos.OrderDAO;
import com.jpinto.basedepizza.model.Ingredient;
import com.jpinto.basedepizza.model.Order;



@RestController
@RequestMapping("/order")
public class OrderController {
	
	private Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderDAO orderDao;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Order> getAll(HttpServletResponse response){
		
		return this.orderDao.getAllOrders();
	}
	
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public Order create(@RequestBody Order order, HttpServletResponse response){
		
		logger.error("Creating order. Dao class: "+this.orderDao.getClass().toString());
		
		return this.orderDao.save(order);
	}
	
	
}