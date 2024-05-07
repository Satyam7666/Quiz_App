package com.quiz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.quiz.service.impl.UserDetailServiceImpl;




@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MysecurityConfiguration {
	
	@Autowired
    private  JwtAuthenticationFilter jwtAuthenticationFilter;
	
    @Autowired
    private JwtAuthenticationEntryPoint unauthorizeHandler;
	
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	  
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {

	           return new BCryptPasswordEncoder();
	   }
	   
	   @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
	        return builder.getAuthenticationManager();
	    }
	   
	   
	   @Bean
	   public UserDetailsService userDetailsService() {
		   return userDetailServiceImpl;
	   }
	   
	 
	   
//	   @Autowired
//	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.userDetailsService(userDetailServiceImpl).passwordEncoder(passwordEncoder());
//	    }
	   
	  
	   
	
	   
	   @Bean
		public DaoAuthenticationProvider getAuthenticationProvider() {
			DaoAuthenticationProvider  daoAuthenticationProvider=new DaoAuthenticationProvider();
			daoAuthenticationProvider.setUserDetailsService(userDetailServiceImpl);
			daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
			return daoAuthenticationProvider;
		}
	  

	   
	   
	   @Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	
			http
			.csrf((cs)->cs.disable())
			.cors((co)->co.disable())
			.authorizeHttpRequests((auth)->
			auth.requestMatchers("/generate-token","/user/").permitAll()
			.requestMatchers(HttpMethod.OPTIONS).permitAll()
			.anyRequest().authenticated())
			.exceptionHandling((ex)->ex.authenticationEntryPoint(unauthorizeHandler))
			.sessionManagement((session)->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
			
			 return http.build();
		}
	
	

}
