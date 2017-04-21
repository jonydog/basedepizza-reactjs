package com.jpinto.basedepizza.controllers;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jpinto.basedepizza.business.interfaces.UserService;
import com.jpinto.basedepizza.model.User;

@Controller
@Scope("session")
@RequestMapping("/register")
public class RegisterController {
		 
	/** Session data **/
	private	final User		 	user 			= new User();
	private boolean 			hasTwitter 		= false;
	
	@Autowired
	private UserService userService;
	
	Logger	logger	= org.slf4j.LoggerFactory.getLogger(RegisterController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView registerForm() {
		ModelAndView mav = new ModelAndView("register");
		RegisterForm rf = new RegisterForm();
		mav.addObject("registerForm", rf);
		mav.addObject("hasTwitter", this.hasTwitter);
		return mav;
	}

	@RequestMapping(params="action-submit",method=RequestMethod.POST)
	public String registerSubmit(@ModelAttribute RegisterForm registerForm, Model m) {
		
		this.user.setEmail(registerForm.getEmail());
		this.user.setUsername(registerForm.getName());
		this.user.setPassword(registerForm.getPassword());
		this.user.setPhone(registerForm.getPhone());
		
		Errors errors = new BeanPropertyBindingResult(this.user, "user");
		userService.registerNewUser(user, registerForm.getConfirmPassword() , errors);

		if(errors.hasErrors() == false ) {
			this.logger.warn("Register success!");
			return "redirect:login";
		} else {
			this.logger.warn("Register failed..." );
			return "register";
		} 
	}
	
	static class RegisterForm {
		
		private String name;
		private String email;
		private String phone;
		private String password;
		private String confirmPassword;
		
		public RegisterForm(){}
		
		public RegisterForm(String name, String email, String phone, String password, String confirmPassword) {
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.password = password;
			this.confirmPassword = confirmPassword;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
	}
}