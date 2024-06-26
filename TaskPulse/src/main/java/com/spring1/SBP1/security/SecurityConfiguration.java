package com.spring1.SBP1.security;

import static org.springframework.security.config.Customizer.withDefaults;
import java.util.function.Function;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
    	
    	//Function<String, String> encoder = input -> passwordEncoder().encode(input);
		
    	UserDetails user = User.builder()
            .username("Anil")
            .password(passwordEncoder().encode("Anil"))
            .roles("USER")
            .build();
    	UserDetails user1 = User.builder()
                .username("Praveen")
                .password(passwordEncoder().encode("Praveen"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user,user1);
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } 
    
    /*@Bean
    public SecurityFilterChain filterchain(HttpSecurity	http) throws Exception {
    	http.authorizeHttpRequests(
    			auth -> auth.anyRequest().authenticated());
    	http.formLogin(withDefaults());
    	
    	http.csrf().disable();
    	http.headers().frameOptions().disable();
    	return http.build();
    }*/
}
