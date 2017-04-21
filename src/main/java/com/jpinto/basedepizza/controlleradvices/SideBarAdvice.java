package com.jpinto.basedepizza.controlleradvices;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice()
public class SideBarAdvice {

	
	@ModelAttribute
	public void leftBarFeed(Model model){
		model.addAttribute("AdviceTestString"	, new String("hahaha") );
		model.addAttribute("sidebarname" 		, "sidebar" );	
	}
}