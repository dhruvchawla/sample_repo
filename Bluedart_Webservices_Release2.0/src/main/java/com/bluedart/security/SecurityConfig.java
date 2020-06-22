package com.bluedart.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan("com.wipro.bluedart.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	 @Autowired
	    private CustomAuthenticationProvider authProvider;
	 
	    @Override
	    protected void configure(
	      AuthenticationManagerBuilder auth) throws Exception {
	    	auth.authenticationProvider(authProvider);
	    }
	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	//System.out.println("Test");
	    	
	    	http.httpBasic().and()
			.authorizeRequests()                                                        
				//.antMatchers("/resources/**", "/signup", "/about").permitAll()                  
				.antMatchers("/ratetransitfinder/**").hasRole("GUEST")
				.antMatchers("/safireintegration/**").hasRole("GUEST")				
				.antMatchers("/findlocation/**").hasRole("GUEST")
				.antMatchers("/trackapi/**").hasRole("CORPORATE")
				.antMatchers("/windowssupport/**").hasRole("CORPORATE")
				.antMatchers("/viewprofile/**").hasRole("CORPORATE")
				.antMatchers("/clientadmin/**").hasRole("CORPORATE")
				.antMatchers("/contactus/**").hasRole("GUEST")
				.antMatchers("/ebusinesssolutions/**").hasRole("CORPORATE")
				.antMatchers("/trackdart/**").hasRole("GUEST")
				.antMatchers("/customerregistration/**").hasRole("GUEST")
				.antMatchers("/forgotpassword/**").hasRole("GUEST")
				.antMatchers("/changepassword/**").hasRole("CORPORATE")
				/*.antMatchers("/bdmanagecorporateusers/**").hasRole("ADMIN")
				.antMatchers("/bdmanageadminusers/**").hasRole("ADMIN")*/
				/*.antMatchers("/addressbook/**").hasRole("CORPORATE")*/
				.antMatchers("/internetdart/**").hasAnyRole("ADMIN","CORPORATE")
				.antMatchers("/savesessiondetails/**").hasAnyRole("ADMIN","CORPORATE","POD")
				.antMatchers("/isvaliduser/**").hasAnyRole("GUEST")
				.antMatchers("/shipdart/**").hasRole("CORPORATE")
				.antMatchers("/mobiledart/**").hasRole("CORPORATE")

				.antMatchers("/podinout/**").hasAnyRole("POD")
				.antMatchers("/inbound/**").hasAnyRole("POD")
				.antMatchers("/outbound/**").hasAnyRole("POD")
				.antMatchers("/manageParcelShopPODUsers/**").hasRole("ADMIN")
				
				
				//.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")    ROLE_GUEST    findlocation    trackdart
				//.anyRequest().authenticated().and().csrf().disable().headers().disable();
				.and().csrf().disable();
				//.headers().disable();
	    	
	    	
	    	
	    /*	http.csrf().disable().authorizeRequests()
	    		.antMatchers("/guest/**").hasRole("GUEST")
	    		.antMatchers("/admin/**").hasRole("ADMIN")
	    		.antMatchers("/corporate/**").hasRole("CORPORATE")
	    		.antMatchers("/pod/**").hasRole("POD"); */
	      /* http.csrf().disable().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
	        .anyRequest().authenticated()
	            .and()
	            .httpBasic();*/
	    }
	
	/*
	@Autowired
	private CustomAuthenticationProvider authProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}
	
/*	@Autowired
	  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth
	      .inMemoryAuthentication()
	        .withUser("user")  // #1
	          .password("password")
	          .roles("USER")
	          .and()
	        .withUser("admin") // #2
	          .password("password")
	          .roles("ADMIN","USER");
	  } 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.print("Test");
		http
		.csrf().disable()
		.antMatcher("/Test/**")
		.authorizeRequests().anyRequest().permitAll();
		/*.anyRequest()
		.authenticated().and()  .csrf().disable()
		.headers().disable()
		.httpBasic();		  
	}*/
}
