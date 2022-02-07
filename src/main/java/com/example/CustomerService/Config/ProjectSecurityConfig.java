package com.example.CustomerService.Config;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * /myAccount - Secured /myBalance - Secured /myLoans - Secured /myCards -
	 * Secured /notices - Not Secured /contact - Not Secured
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
		
		//parameterized list
		http.authorizeRequests()
		//.antMatchers("/createCustomer").authenticated()
		.antMatchers("/getCustomer/{customerId}").hasAnyRole("USER")
		//.antMatchers("/getCustomer").hasAnyRole("USER", "ADMIN")
		.and().csrf().disable()
		.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter);
		
		/**
		 * This configuration is needed to view the /h2-console with out any issues.
		 * Since H2 Console uses frames to display the UI, we need to allow the frames.
		 * Otherwise since by default Spring Security consider X-Frame-Options: DENY
		 * to avoid Clickjacking attacks, the /h2-console will not work properly.
		 * More details can be found at 
		 * https://docs.spring.io/spring-security/site/docs/5.0.x/reference/html/headers.html#headers-frame-options
		 */
		http.headers().frameOptions().sameOrigin();

	}

}