package com.testrbc.petshop.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import static com.stormpath.spring.config.StormpathWebSecurityConfigurer.stormpath;

@Configuration
@EnableWebSecurity
public class SpringSecurityWebAppConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        .csrf().csrfTokenRepository(csrfTokenRepository()).and()
//                .anyRequest().authenticated();
//                .and().addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
        http.apply(stormpath()).and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/pet").permitAll()
                .antMatchers("/swagger").permitAll();
    }

//    private CsrfTokenRepository csrfTokenRepository() {
//        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//        repository.setHeaderName("X-XSRF-TOKEN");
//        return repository;
//    }

}
