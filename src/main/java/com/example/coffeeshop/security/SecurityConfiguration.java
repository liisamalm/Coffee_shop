package com.example.coffeeshop.security;

import com.example.coffeeshop.Services.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration 
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
        http.csrf().disable();  // poistetaan csrf-tarkistus käytöstä h2-konsolin vuoksi
        http.headers().frameOptions().sameOrigin(); // sallitaan framejen käyttö

        http.authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/css/**","/images/**", "/js/**","/fonts/**","/**, /favicon.ico", "/about", "/kahvilaite/tuoteKuva/**", "/kulutustuote/tuoteKuva/**").permitAll()
                .antMatchers("/h2-console", "/h2-console/**").permitAll()
                
                .antMatchers("/kahvilaitteet", "/kahvilaitteet/**", "/search").permitAll()
                .antMatchers("/kulutustuotteet", "/kulutustuotteet/**", "/searchProducts").permitAll()
                .antMatchers("/registration", "/registration/**").permitAll()
                .antMatchers("/vip", "/vip/**").permitAll()
                .antMatchers("/tuotteenhallinta", "tuotteenhallinta/**").hasAnyAuthority("ADMIN")
                .antMatchers("/tuotteen-muokkaus", "tuotteen-muokkaus/**").hasAnyAuthority("ADMIN")
                .antMatchers("/valmistajan-muokkaus", "valmistajan-muokkaus/**").hasAnyAuthority("ADMIN")
                .antMatchers("/toimittajan-muokkaus", "toimittajan-muokkaus/**").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated();
                
        http.formLogin()
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");
        }
        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }
  
    }
        


