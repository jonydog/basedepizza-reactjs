package com.jpinto.basedepizza.configs;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EntityScan({"com.jpinto.basedepizza.model"})
@EnableJpaRepositories({"com.jpinto.basedepizza.daos"})	
@ComponentScan({ "com.jpinto.basedepizza", "com.jpinto.basedepizza.business", "com.jpinto.basedepizza.controllers", "com.jpinto.basedepizza.restcontrollers" })
public class TestsConfiguration {
	
}
