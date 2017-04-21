package com.jpinto.basedepizza.configs;

import javax.sql.DataSource;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ServiceConfigurator {
	
	

	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	@Primary
	public DataSource dataSource() {
	    return DataSourceBuilder
	        .create()
	        .build();
	}
	
	@Bean
	public Validator entityValidator(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		return factory.getValidator();
	}

	
/*	@Bean
	@Autowired
	public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
		logger.debug("Configuring EntityManager");
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setPersistenceProvider(new HibernatePersistenceProvider());
		lcemfb.setPersistenceUnitName("persistenceUnit");
		lcemfb.setDataSource(dataSource);
		lcemfb.setJpaDialect(new HibernateJpaDialect());
		lcemfb.setJpaVendorAdapter(jpaVendorAdapter());
		lcemfb.setSharedCacheMode(SharedCacheMode.NONE);
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.generate_statistics", false);
		lcemfb.setJpaProperties(jpaProperties);
		lcemfb.setPackagesToScan("pt.agap2.academy.horus.webportal.model","pt.agap2.academy.horus.persistence.common.model","pt.agap2.academy.socialactions.domain");
		lcemfb.afterPropertiesSet();
		return lcemfb.getObject();
	}*/

	/*
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		if (logger.isDebugEnabled()) {
			jpaVendorAdapter.setShowSql(true);
		}
		jpaVendorAdapter.setGenerateDdl(true);
		jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return jpaVendorAdapter;
	}
	*/
}
