package employee.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@ComponentScan(basePackages = "employee")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests().anyRequest().authenticated()
////                .and()
////                .x509()
////                .subjectPrincipalRegex("CN=(.*?)(?:,|$)")
////                .userDetailsService(userDetailsService());
//        http.requiresChannel()
//                .anyRequest().requiresSecure()
//        .and()
//        .authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
//                .antMatchers("/employees/**").access("hasRole('ADMIN')")
//                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
//                .and().csrf().disable();
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .antMatchers("/", "/home").permitAll()
//                .antMatchers("/employees/**").access("hasRole('testing')")
//                .and().httpBasic();
//
//
//        http.csrf().disable()
//                .logout()
//                .permitAll();

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/employees").authenticated()
                //.anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .jee().mappableRoles("ACTUATOR","SERVICE")
        ;

    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) {
//                    return new User(username, "",
//                                    AuthorityUtils
//                                            .commaSeparatedStringToAuthorityList("testing"));
//            }
//        };
//    }



}
