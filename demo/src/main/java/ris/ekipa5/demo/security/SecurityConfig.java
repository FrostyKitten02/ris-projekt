package ris.ekipa5.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        /*http.csrf().disable().authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
         */

        //FILTERING /uprabnik/login no auth needed!
//        http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers(HttpMethod.POST,"/uporabnik/login")
//                .permitAll();
        //ANY OTHER REQUEST NEEDS AUTHENTICATION!!
//        http.csrf().disable().authorizeHttpRequests().anyRequest().denyAll().and().httpBasic();

        http.csrf().disable().authorizeHttpRequests().anyRequest().authenticated().and().httpBasic();

        return http.build();
    }

    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(encoder());
        provider.setUserDetailsService(this.userDetailsService);
        return provider;
    }


    @Bean
    public PasswordEncoder encoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                StringBuilder sb = new StringBuilder();
                sb.append(rawPassword);
                return sb.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.equals(encodedPassword);
            }
        };
    }

}
