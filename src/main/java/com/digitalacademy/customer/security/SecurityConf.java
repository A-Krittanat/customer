package com.digitalacademy.customer.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {

//    @Value("${spring.security.user.name}")
//    private String userName;
//    @Value("${spring.security.user.password}")
//    private String passWord;
//    @Value("${spring.security.user.roles}")
//    private String role;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and().csrf()
                .disable()
                .httpBasic();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("ton")
        .password("password")
        .roles("ADMIN").build());

        manager.createUser(users.username("Noon")
        .password("password")
        .roles("USERS").build());

        System.out.println(manager.loadUserByUsername("ton"));
        System.out.println(manager.loadUserByUsername("Noon"));

        return manager;

    }
}
