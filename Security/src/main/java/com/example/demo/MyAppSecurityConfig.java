package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity				//looks up the configuration written inside the class other wise it will create its own user
public class MyAppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource datasource;		//Connecting the DataBase
	
	//whether user can login or not
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();	//we should use password encoder to encrypt and save in the DB otherwise it will show error
		
		auth.jdbcAuthentication()
		    .dataSource(datasource)	//Connects to datasource DB
		    .withDefaultSchema()	//creates tables in DB
		    .withUser("Dinesh")		//with the user "Dinesh" and its password "dinesh" which has role as User
		    .password(encoder.encode("dinesh"))
		    .roles("USER")
		    .and()
		    .withUser("Admin")		//with the user "Admin" and its password "admin" which has role as User
		    .password(encoder.encode("admin"))
		    .roles("ADMIN");
	}

	//To login as User http://localhost:8080/user
	//To login as Admin http://localhost:8080/admin
	//To login for all http://localhost:8080/
	//To logout use http://localhost:8080/logout
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
			.antMatchers("/admin").hasRole("ADMIN")		//Indicates that admin can only login to admin page
			.antMatchers("/user").hasAnyAuthority("ADMIN","USER")	//Indicates that admin and user can login to user page
			.antMatchers("/").permitAll()	//Indicates that all can login to the / page
			.antMatchers("/h2-console/**").permitAll()	//For permitting the user in H2 console
			.and().formLogin();		//For using the Form login
	
		//only for h2 Console
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
	}

	
	
	
}
