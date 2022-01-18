
package com.example.authservice.configuration;

import com.example.authservice.jwt.JwtConfigurer;
import com.example.authservice.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import static com.example.authservice.constants.MicroServiceConstants.LOGIN_MICROSERVICE;

@Configuration
@EnableWebSecurity
//below annotation is requierd when we are implementing role based authorization
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		System.out.println("I am inside sec...");
		httpSecurity.httpBasic().disable().csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers(LOGIN_MICROSERVICE).permitAll()
				// .antMatchers("/login").permitAll() 
				.antMatchers("/admin-service/api/hello").hasRole("ADMIN").and()
				//.anyRequest().authenticated().and()
				.apply(new JwtConfigurer(jwtTokenProvider));
	}
}
