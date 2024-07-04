package com.ascent.Spring.Security.config;

import com.ascent.Spring.Security.Services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .authorizeRequests()
                .antMatchers("/signin").permitAll()
                .antMatchers("/public/**").hasRole("NORMAL")
                .antMatchers("/users/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/signin")
                .loginProcessingUrl("/dologin")
                .defaultSuccessUrl("/users",true);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());

// Used when we manually add the data in the service class where the data no stored in the database
//        auth.inMemoryAuthentication()
//                .withUser("Rohit")
//                .password(this.passwordEncoder().encode("rohit"))
//                .roles("NORMAL");
//        auth.inMemoryAuthentication()
//                .withUser("Rohan")
//                .password(this.passwordEncoder().encode("rohan"))
//                .roles("NORMAL","ADMIN");
    }
           //ROLE - High Level Overview -> NORMAL:READ
           //Authority - permission-> READ
           //ADMIN- READ, WRITE, UPDATE
    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder(10);
    }
}
