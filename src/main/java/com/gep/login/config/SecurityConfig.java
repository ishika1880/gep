
package com.gep.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public UserDetailsService getUserDetailsService() {
		return new UserDetailsServiceImpl();
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		    .requestMatchers("/admin/**")
		    .hasRole("ADMIN")
		    .requestMatchers("/user/**")
		    .hasRole("USER")
		    .requestMatchers("/**")
		    .permitAll().and()
		    .formLogin()
		    .loginPage("/signin")
		    .loginProcessingUrl("/dologin")
		    .defaultSuccessUrl("/user/index")
		    .and()
		    .csrf()
		    .disable();
		
//		http.csrf().disable()
//		            .cors()
//		            .disable()
//		            .authorizeRequests()
//		            .requestMatchers("/admin/**")
//		            .hasRole("ADMIN")
//		            .requestMatchers("/user/**")
//		            .hasRole("USER")
//		            .requestMatchers("/**")
//		            .permitAll()
//		            .and().formLogin()
//		            .and()
//		            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.authenticationProvider(authProvider());
		return http.build();
		
	}
	
	@Bean
	 public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
		 authProvider.setUserDetailsService(this.getUserDetailsService());
		 authProvider.setPasswordEncoder(passwordEncoder());
		 return authProvider;
	}
	
//	  @Bean
//	    public ProviderManager authManagerBean(HttpSecurity security) throws Exception {
//	        return (ProviderManager) security.getSharedObject(AuthenticationManagerBuilder.class)
//	                .authenticationProvider(authProvider()).
//	                build();
//	    }
	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	  
	  @Bean
	  public BCryptPasswordEncoder passwordEncoder() {
		  return new BCryptPasswordEncoder();
	  }

}
