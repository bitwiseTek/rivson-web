package com.bitwise.manageme.rssson.web.config;
/**
 *  
 * @author Sika Kay
 * @date 07/07/16
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

import com.bitwise.manageme.rssson.web.security.RSSSONAuthenticationProvider;
import com.bitwise.manageme.rssson.web.security.RSSSONUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private RSSSONAuthenticationProvider authenticationProvider;

	@Autowired
	private RSSSONUserDetailsService userDetailsService;

	/*
	 * @Autowired private Environment env;
	 */

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/favico.ico", "/resources/**/*");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http// .requiresChannel().anyRequest().requiresSecure()
			// .and()
				/*
				 * .portMapper().http(Integer.parseInt(env.getProperty(
				 * "http.port",
				 * "8080"))).mapsTo(Integer.parseInt(env.getProperty(
				 * "https.port", "8443"))) .and()
				 */
				.headers().addHeaderWriter(new StaticHeadersWriter("X-Content-Security-Policy", "script-src 'self'"))
				.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"))
				.addHeaderWriter(
						new StaticHeadersWriter("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE"))
				.addHeaderWriter(new StaticHeadersWriter("Access-Control-Max-Age", "3600"))
				.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Headers", "x-requested-with")).and()
				.sessionManagement().sessionFixation().newSession().and().authorizeRequests()
				.antMatchers("/", "/index", "/users/login",  "/defaulterror", "/resourceNotFound",
						"/dataAccessFailure")
				.permitAll()
				.antMatchers("/courses/**", "/projects/**", "/users/**", "/students/**")
				.authenticated().antMatchers("/admin/**", "/users/searchusers", "/users/searchusersdialog", 
						"/users/createuser", "/students/createstudent", "/students/searchstudents", 
						"/users/edituser", "/users/searchuserdialog", "/courses/searchcourses", 
						"/projects/searchprojects", "/staff/createstaff")
				.access("hasRole('ADMINISTRATOR') or hasRole('SUPER_ADMIN')").and().formLogin().loginPage("/users/login")
				.loginProcessingUrl("/j_spring_security_check").usernameParameter("username")
				.passwordParameter("password").defaultSuccessUrl("/index.htm").failureUrl("/users/login?error").and()
				.logout().logoutUrl("/users/logout").logoutSuccessUrl("/users/login?logout")
				.invalidateHttpSession(true).deleteCookies("JSESSIONID").and().httpBasic().realmName("RSSSON Web")
				.and().csrf().and().exceptionHandling().accessDeniedPage("/accessdenied");
	}

	/*protected void configureRestful(HttpSecurity http) throws Exception {
		http// .requiresChannel().anyRequest().requiresSecure()
				
				 * .and() .portMapper().http(Integer.parseInt(env.getProperty(
				 * "http.port",
				 * "8080"))).mapsTo(Integer.parseInt(env.getProperty(
				 * "https.port", "8443")))
				 
				.headers().addHeaderWriter(new StaticHeadersWriter("X-Content-Security-Policy", "script-src 'self'"))
				.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", ""))
				.addHeaderWriter(
						new StaticHeadersWriter("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE"))
				.addHeaderWriter(new StaticHeadersWriter("Access-Control-Max-Age", "3600"))
				.addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Headers", "x-requested-with")).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/v1/restful", "/v1/restful/index", "/v1/restful/signup", "/v1/restful/signin",
						"/v1/restful/success", "/v1/restful/accounts")
				.permitAll()
				.antMatchers("/v1/restful/home", "/v1/restful/locations**", "/v1/restful/feeds**",
						"/v1/restful/accounts**")
				.authenticated().antMatchers("/v1/restful/superadmin/**").access("hasRole('SUPER_ADMIN')")
				.antMatchers("/v1/restful/admin/**").access("hasRole('ADMIN')").and().formLogin()
				.loginPage("/v1/restful/signin.htm").loginProcessingUrl("/j_spring_security_check")
				.usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/v1/restful/home.htm")
				.failureUrl("/v1/restful/signin.htm?error").and().logout().logoutUrl("/v1/restful/signout.htm")
				.logoutSuccessUrl("/v1/restful/signin.htm?signout").invalidateHttpSession(true)
				.deleteCookies("JSESSIONID").and().httpBasic().realmName("Traffickon Mobile").and().csrf().disable()
				.exceptionHandling().accessDeniedPage("/v1/restful/accessdenied");
	}*/

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
