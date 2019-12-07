package com.example.sportsbetting.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.sportsbetting.SportsBettingService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = { "com.example.sportsbetting"})
@Import(SportsBettingService.class)
public class WebSecurityConfig
   extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private SportsBettingService service;
	
	 @Bean("authenticationManager")
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	            return super.authenticationManagerBean();
	    }
	 
	    @Bean
	    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	        return new MyAuthenticationSuccessHandler();
	    }
	
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) {
    try {
    	 for(com.example.sportsbetting.domain.User user : service.findAllPlayers())	 {
	    	  auth.inMemoryAuthentication().withUser(user.getEmail()).password("{noop}"+user.getPassword()).roles("USER");
	      }

		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   
	}
  }
  
  protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	      .antMatchers("/", "/login","/welcome","/add").access("hasRole('USER')")
	      .antMatchers("/admin/**").hasRole("ADMIN")
	      .and()
	      .csrf().disable()
	      .formLogin()
	      .loginPage("/login")
	      .permitAll()
	      .successHandler(myAuthenticationSuccessHandler())
	      .and()
	      .logout()
          .logoutUrl("/logout")
          .logoutSuccessUrl("/login");
	}
  

  
  
}
