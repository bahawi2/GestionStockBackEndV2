package com.bahawi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SpringSecurityConf extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsService;

	protected void configure(HttpSecurity http) throws Exception{
		http
		.httpBasic()
			.and()
				.authorizeRequests()
					.antMatchers("/api/").hasRole("NORMAL")
					.antMatchers("/").hasRole("ADMIN").
					and().csrf().disable().headers().frameOptions().disable();
	}
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
	//	auth.userDetailsService(userDetailsService).
	//	passwordEncoder(NoOpPasswordEncoder.getInstance());
		
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())  
        .withUser("user") .password("1234").roles("NORMAL")
         .and()
         .withUser("root").password("root").roles("NORMAL","ADMIN");
		
	}
}
