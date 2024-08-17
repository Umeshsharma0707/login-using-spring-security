package com.userlogin.confg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.userlogin.repos.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private MyUserDetailsService detailsService;
	
	@Bean
	BCryptPasswordEncoder cryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider  authenticationProvider= new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(cryptPasswordEncoder());
		authenticationProvider.setUserDetailsService(detailsService);
		return authenticationProvider;
	}
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  
            .authorizeHttpRequests(auth ->
                auth
                    .requestMatchers("/index","/home/**", "/login").permitAll() 
                    .anyRequest().authenticated()                
            )
            .formLogin(formLogin ->
            formLogin
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/dashboard", true)
        )
        .logout(logout ->
            logout.permitAll()
        );
            
       
        return http.build();
    }
	 
}
