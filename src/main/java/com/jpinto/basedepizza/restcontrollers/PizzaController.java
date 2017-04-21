package com.jpinto.basedepizza.restcontrollers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jpinto.basedepizza.business.interfaces.PizzaService;
import com.jpinto.basedepizza.daos.PizzaDAO;
import com.jpinto.basedepizza.model.Pizza;
import com.jpinto.basedepizza.utils.ServiceResult;
import com.jpinto.basedepizza.utils.ToErrorsAdapter;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
	
	private Logger logger = LoggerFactory.getLogger(PizzaController.class);

	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private PizzaDAO pizzaDao;
	
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Pizza> getAll(HttpServletResponse response){
		
		return this.pizzaDao.getAllPizzas();
	}
	
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ServiceResult<Pizza> create(@RequestBody Pizza pizza, HttpServletResponse response){
		
		logger.error("Creating pizza. Dao class: "+this.pizzaDao.getClass().toString());
		
		Errors errors = new BeanPropertyBindingResult(pizza, "pizza");
		this.pizzaService.createNewPizza(pizza, errors);
		
		ServiceResult<Pizza> result = new ServiceResult<>();
		result.setResult(pizza);
		result.setErrors( ToErrorsAdapter.toErrors(errors) );  

		System.out.println( "Result:  "  + result.toString());
		
		return result;	
	}
	
	
	
}