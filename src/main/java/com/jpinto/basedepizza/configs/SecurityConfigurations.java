package com.jpinto.basedepizza.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder()).and()
				.inMemoryAuthentication().withUser("email")
				.password("password").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	      .csrf().disable();
        http
        	.authorizeRequests()
        		.antMatchers("/").permitAll()
            	.antMatchers("/index", "/register/**" , "/ingredient/**", "/pizzas/**"  , "/registerSuccess", "/passwordRecovery", "/userEvents","/socialactions/*").permitAll()
            	.antMatchers("/css/**/*.css").permitAll() 
            	.antMatchers("/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/home", true)
                .permitAll()
                .and()
        	.logout()
        		.permitAll()
        		.logoutUrl("/logout")
        		.logoutSuccessUrl("/");
        
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);
    }
        
    @Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}