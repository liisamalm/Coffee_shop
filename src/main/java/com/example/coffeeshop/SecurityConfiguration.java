package com.example.coffeeshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
 
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

//määritellään sovelluksen osoitteet, joihin on pääsy kielletty tai pääsy sallittu.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
        http.csrf().disable();  // poistetaan csrf-tarkistus käytöstä h2-konsolin vuoksi
        http.headers().frameOptions().sameOrigin(); // sallitaan framejen käyttö

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/css/**","/images/**", "/js/**","/fonts/**","/**, /favicon.ico", "/about", "/kahvilaite/tuoteKuva/**", "/kulutustuote/tuoteKuva/**").permitAll()
                .antMatchers("/h2-console", "/h2-console/**").permitAll()
                .antMatchers(HttpMethod.GET, "/").permitAll() //pääsy sivulle ilman salasanaa
                .antMatchers(HttpMethod.GET, "/kahvilaitteet", "/kahvilaitteet/*").permitAll() 
                .antMatchers(HttpMethod.GET, "/kulutustuotteet", "/kulutustuotteet/*").permitAll() 
                .antMatchers(HttpMethod.GET, "/vip").permitAll() 
                .antMatchers(HttpMethod.POST, "/vip").permitAll() 
                .antMatchers(HttpMethod.GET, "/registrations").permitAll() 
                .antMatchers(HttpMethod.POST, "/registrations").permitAll() 
                /* .antMatchers(HttpMethod.GET, "/tuotteenhallinta/**").hasAnyAuthority("ADMIN") 
                .antMatchers(HttpMethod.POST, "/tuotteenhallinta/**").hasAnyAuthority("ADMIN") */
                .anyRequest().authenticated();
                /* .formLogin().permitAll().and() //kaikilla pääsy kirjautumiseen
                .logout().permitAll().and()
  */
        http.formLogin()
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");
        }

        @Bean
        @Override
        public UserDetailsService userDetailsService() {
            UserDetails noora = User.withDefaultPasswordEncoder()
                    .username("noora")
                    .password("salasana")
                    .authorities("ADMIN")
                    .build();
    
            UserDetails vip = User.withDefaultPasswordEncoder()
                    .username("asiakas")
                    .password("vip")
                    .authorities("USER")
                    .build();
            
            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
            manager.createUser(noora);
            manager.createUser(vip);
            return manager;
        } 
    }
    

        /*  @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
        }
    
        /* @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        } 
 */ 
        


