package org.example.config;

import javax.sql.DataSource;



//import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * https://docs.spring.io/spring-boot/docs/current/reference/html/howto-security.html
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)  // Important to allow annotations of type @PreAuthorize
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private Environment environment;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/home").permitAll()
			// Application info endpoints (role cannot start with ROLE_)
			.antMatchers("/appinfo/**").hasRole("NOT_FUNCTIONAL_ADMIN") 
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login").permitAll()
			.and().logout().permitAll();
		if(!inProd()){ // Allow h2-console if not in prod
			http.authorizeRequests()
			.antMatchers("/h2-console", "/h2-console/**").hasRole("NOT_FUNCTIONAL_ADMIN")
			.and().csrf().disable().headers().frameOptions().disable();
		}
	}

	/**
	 * https://github.com/spring-projects/spring-security/blob/master/samples/jdbc-jc/src/main/java/org/springframework/security/samples/config/SecurityConfig.java
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}
	
	/**
	 * True if we are in production environment
	 * @return
	 */
	private boolean inProd(){
		for (String profile: this.environment.getActiveProfiles()) {
			if(Environments.PROD.toString().equalsIgnoreCase(profile)){
				return true;
			}
		}
		return false;
	}
}
