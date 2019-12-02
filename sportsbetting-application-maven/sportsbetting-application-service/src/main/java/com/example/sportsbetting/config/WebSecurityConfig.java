package com.example.sportsbetting.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig
   extends WebSecurityConfigurerAdapter {

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
		auth
		  .inMemoryAuthentication()
		    .withUser("user").password("{noop}password").roles("USER");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
//  @Bean
//  public UserDetailsService userDetailsService() {
//
//      User.UserBuilder users = User.withDefaultPasswordEncoder();
//      InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//      manager.createUser(users.username("user").password("password").roles("USER").build());
//      manager.createUser(users.username("admin").password("password").roles("USER", "ADMIN").build());
//      return manager;
//
//  }
	
	/*@Autowired
	private DataSource dataSource;d
	 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
	  throws Exception {
	    auth.jdbcAuthentication().dataSource(dataSource)
	      .withDefaultSchema()
	      .withUser("user").password("password").roles("USER")
	      .and()
	      .withUser("admin").password("password").roles("USER", "ADMIN");
	}
	*/
  /*
   protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	      .anyRequest().authenticated()
	      .and().httpBasic();
	}
   */
 
//  protected void configure(HttpSecurity http) throws Exception {
//	    http.authorizeRequests()
//	      .anyRequest().authenticated()
//	      .and().formLogin()
//	      .loginPage("/login").permitAll();
//	}
	 
  
  protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	      .antMatchers("/", "/home","/welcome","/add").access("hasRole('USER')")
	      .antMatchers("/admin/**").hasRole("ADMIN")
	      .and()
	      .csrf().disable()
	      // some more method calls
	      .formLogin()
	      .loginPage("/home")
	      .permitAll()
	      .successHandler(myAuthenticationSuccessHandler());
	}
  

  
  
}
