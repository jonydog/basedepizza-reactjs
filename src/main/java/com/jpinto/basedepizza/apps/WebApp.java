package com.jpinto.basedepizza.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
@EntityScan({"com.jpinto.basedepizza.model"})
@EnableJpaRepositories({"com.jpinto.basedepizza.daos"})	
@ComponentScan({ "com.jpinto.basedepizza", "com.jpinto.basedepizza.business", "com.jpinto.basedepizza.controllers", "com.jpinto.basedepizza.restcontrollers" })
@Component
public class WebApp{



	
	public static void main(String args[]){
		SpringApplication.run(WebApp.class, args);

	}
}
