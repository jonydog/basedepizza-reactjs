package com.jpinto.basedepizza.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView loginForm(){
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("loginForm", new LoginForm());
		return mav;
	}
	
	static class LoginForm {
		
		private String email;
		private String password;
		
		public LoginForm(){}
		
		public LoginForm(String email, String password) {
			this.email = email;
			this.password = password;
		}

		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
	}
}	