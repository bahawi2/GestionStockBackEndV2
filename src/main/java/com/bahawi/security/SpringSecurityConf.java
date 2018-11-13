package com.bahawi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
public class SpringSecurityConf extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
  }

	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
 
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
 
    }
	
	protected void configure(HttpSecurity http) throws Exception{
		  // The pages does not require login
        http.authorizeRequests().antMatchers("/login/**", "/logout/**").permitAll();
 
		http
		.httpBasic()
			.and()
				.authorizeRequests()
					.antMatchers("/api/**").hasRole("NORMAL")
					.antMatchers("/usercrud","/**").hasRole("ADMIN").
					and().csrf().disable().headers().frameOptions().disable();
		/*http.httpBasic();
		 http.csrf().disable();
		 
	      
	        // For ADMIN only.
	        http.authorizeRequests().antMatchers("/api/produit/**").access("hasRole('ADMIN')");*/
	}
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService).
		passwordEncoder(NoOpPasswordEncoder.getInstance());
		
		/*auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())  
        .withUser("user") .password("1234").roles("NORMAL")
         .and()
         .withUser("root").password("root").roles("NORMAL","ADMIN");*/
		
	}
	 
}
