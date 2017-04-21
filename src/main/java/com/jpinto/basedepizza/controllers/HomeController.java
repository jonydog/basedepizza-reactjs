package com.jpinto.basedepizza.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/home")
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView homeScreen(){
		return new ModelAndView("home");
	}
	
}
