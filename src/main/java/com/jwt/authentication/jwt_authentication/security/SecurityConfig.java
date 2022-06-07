package com.jwt.authentication.jwt_authentication.security;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String[] AUTH_LIST = {
            // -- swagger ui URI
            "swagger-resources/**",
            "/swagger-ui.html/*","/swagger-ui.html/**",
            "/v2/api-docs",
            "/webjars/**",
            "/v3/api-docs/**",
            // for login the user will use the following URL
            "**/login/auth"
    };
    @Override
    protected void configure(HttpSecurity http) throws Exception {
// from http parameter we can take to the application some configuration
// we are using chain mechanism when putting our configuration using http parameter
// cros() and csrf() using with cookies, and we are building RestAPI, in our case we don't need to use cookies
// we need to use sessionManagement() to set policy of the user session. In our case we are using the session policy type of STATELESS because we are using JWT token in this application
// we need to use authorizeRequests() if we have any public URL to any user like a guest user authorizeRequests we need write antMatchers()
// antMatchers() we can write specific url inside antMatchers or pattern of URL
// .anyRequest().authenticated() that is mean any other request does not belong AUTH_LIST will need to username and password
// httpBasic that mean I will use httpBasic authentication

        http
                .csrf()
                .and()
                .cors()
                .disable()
                .httpBasic()
                .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(AUTH_LIST).permitAll()
                .anyRequest().authenticated();

    }
}
