// package com.application.springapplication.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//                 .authorizeHttpRequests(authorizeRequests -> authorizeRequests
//                         .requestMatchers("/", "/login", "/public/**").permitAll()
//                         .anyRequest().authenticated())
//                 .oauth2Login(oauth2Login -> oauth2Login
//                         .loginPage("/login")
//                         .userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint.oidcUserService(new OidcUserService())))
//                 .logout(logout -> logout
//                         .logoutSuccessUrl("/")
//                         .permitAll());
//         return http.build();
//     }
// }

package com.application.springapplication.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        logger.info("Configuring security filter chain");
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/", "/login", "/public/**").permitAll()
                        .anyRequest().authenticated())
                .oauth2Login(oauth2Login -> oauth2Login
                        .loginPage("/login")
                        .userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint.oidcUserService(new OidcUserService())))
                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                        .permitAll());
        return http.build();
    }
}
