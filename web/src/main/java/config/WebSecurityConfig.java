package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import service.UserEntityService;

import javax.sql.DataSource;

@ComponentScan(basePackages = "config")
@EnableJpaRepositories(basePackages = "repository")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomSuccessHandler customSuccessHandler;

    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("hoangpv6681").password("Hoangpv6681").roles("ADMIN")
                .and().withUser("hoangpv66").password("Hoangpv6681").roles("USER");
        auth.userDetailsService(userEntityService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/login", "/logout").permitAll()
                .antMatchers("/user/**").access("hasAnyRole('USER', 'ADMIN','DBA')")
                .antMatchers("/admin/**").access("hasAnyRole('ADMIN','DBA')")
                .antMatchers("/dba/**").access("hasRole('DBA')")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/user_login")
                .defaultSuccessUrl("/login", true)
                .successHandler(customSuccessHandler)
                .and().exceptionHandling().accessDeniedPage("/access_denied")
                .and().csrf()
                .and()
                .logout()
                .logoutUrl("/user_logout")
                .logoutSuccessUrl("/logout")
                .deleteCookies("JSESSIONID")
                .and().rememberMe().tokenValiditySeconds(24 * 60 * 60);
    }
}