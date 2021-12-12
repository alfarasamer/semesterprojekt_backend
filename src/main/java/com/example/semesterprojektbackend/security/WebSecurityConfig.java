// https://www.marcobehler.com/guides/spring-security

package com.example.semesterprojektbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    public WebSecurityConfig(CustomUserDetailService customUserDetailService) {
        this.customUserDetailService = customUserDetailService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http // "/home" accessible by everybody
                .authorizeRequests()
                .antMatchers("/")
                .permitAll();
        http
         // "/admin" accessible by user with ROLE_ADMIN
                .authorizeRequests()
                .antMatchers("/admin")
                .access("hasRole('ROLE_ADMIN')");
        // http
                // lock every route
              //  .authorizeRequests()
                //.anyRequest()
               // .authenticated();
         http
                .formLogin()
                .loginProcessingUrl("/login")
                .permitAll();
        http
                .logout()
                .logoutUrl("/logout")
                .permitAll();
        http
                .addFilterAt(
                        usernamePasswordAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class
                );
        http
                .exceptionHandling()
                .accessDeniedHandler(
                        (httpServletRequest, httpServletResponse, e) ->
                                httpServletResponse.sendError(
                                        HttpServletResponse.SC_FORBIDDEN
                                )
                )
                .authenticationEntryPoint(
                        new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)
                );
        http

        // turn csrf on
                .csrf()
                .disable();



    }

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http // lock every route
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

    }*/

    private final CustomUserDetailService customUserDetailService;

    @Bean
    public UserDetailsService userDetailsService() {
        return this.customUserDetailService;
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        //authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        return authenticationProvider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    public UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter()
            throws Exception {
        JsonUsernamePasswordAuthenticationFilter authenticationFilter
                = new JsonUsernamePasswordAuthenticationFilter();
        authenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
        authenticationFilter.setAuthenticationManager(authenticationManagerBean());
        return authenticationFilter;
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }


}




