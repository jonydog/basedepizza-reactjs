package com.jpinto.basedepizza.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpEncodingProperties;
import org.springframework.boot.web.filter.OrderedCharacterEncodingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class WebConfigurations{
	
	// @Override
  //  public void addViewControllers(ViewControllerRegistry registry) {
       // registry.addViewController("/home").setViewName("home");
       // registry.addViewController("/").setViewName("home");
    //    registry.addViewController("/register").setViewName("register");
      //  registry.addViewController("/login").setViewName("login");
    //}
	

	@Autowired
	private HttpEncodingProperties httpEncodingProperties;

	@Bean
	public OrderedCharacterEncodingFilter characterEncodingFilter() {
	    OrderedCharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
	    filter.setEncoding( "UTF-8"  );
	    filter.setForceEncoding(true);
	    filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
	    return filter;
	}


}