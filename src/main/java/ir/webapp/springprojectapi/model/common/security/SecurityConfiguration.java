package ir.webapp.springprojectapi.model.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Autowired
    public SecurityConfiguration(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
//                .antMatchers("/home").permitAll()
                .antMatchers("/**").authenticated()
                .and().formLogin()
                .successHandler((request, response, authentication)
                        ->  {request.getSession(false).setAttribute("currentUser",
                        authentication.getPrincipal());
                    response.sendRedirect("/");})
                .loginPage("/login").permitAll()
                .and().logout().permitAll()
//                .and().exceptionHandling().accessDeniedHandler()
        ;
    }
}
