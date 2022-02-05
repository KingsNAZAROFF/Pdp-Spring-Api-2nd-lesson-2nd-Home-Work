package uz.pdp.pdpspringapi2ndlesson2ndhomework.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("superAdmin").password(passwordEncoder().encode("superAdmin")).roles("SUPER_ADMIN").authorities("READ_ALL_PRODUCT","ADD_PRODUCT","EDITE_PRODUCT","DELETE_PRODUCT","READ_ONE_PRODUCT")
                .and()
                .withUser("moderator").password(passwordEncoder().encode("moderator")).roles("MODERATOR ").authorities("READ_ALL_PRODUCT","ADD_PRODUCT","EDITE_PRODUCT","READ_ONE_PRODUCT")
                .and()
                .withUser("operator").password(passwordEncoder().encode("operator")).roles("OPERATOR ").authorities("READ_ONE_PRODUCT","READ_ALL_PRODUCT");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE,"/api/accessory/*","/api/brand/*","/api/computer/*","api/gamingChair/*","api/monitor/*","api/monoBlock/*","api/notebook/*","api/peripheral/*","api/printer/*").hasAuthority("DELETE_PRODUCT")
                .antMatchers(HttpMethod.GET,"/api/accessory/**","/api/brand/**","/api/computer/**","api/gamingChair/**","api/monitor/**","api/monoBlock/**","api/notebook/**","api/peripheral/**","api/printer/**").hasAnyAuthority("READ_ALL_PRODUCT","READ_ONE_PRODUCT")
                .antMatchers(HttpMethod.POST,"/api/accessory/**","/api/brand/**","/api/computer/**","api/gamingChair/**","api/monitor/**","api/monoBlock/**","api/notebook/**","api/peripheral/**","api/printer/**").hasAnyAuthority("ADD_PRODUCT")
                .antMatchers(HttpMethod.PUT,"/api/accessory/**","/api/brand/**","/api/computer/**","api/gamingChair/**","api/monitor/**","api/monoBlock/**","api/notebook/**","api/peripheral/**","api/printer/**").hasAnyAuthority("EDITE_PRODUCT")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }



    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
