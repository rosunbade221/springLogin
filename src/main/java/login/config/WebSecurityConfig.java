package login.config;

import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import login.domain.Users;
import login.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DataSource dataSource;
	
	@Override
    protected void configure(HttpSecurity security) throws Exception {
		
//		security.csrf().disable();
//		security.authorizeRequests()
//				// ignores security on urls specified in andMatchers
//				.antMatchers("/", "/login", "/signup", "/resources/**")
//				.permitAll().anyRequest().authenticated().and().formLogin()
//				.loginPage("/login").defaultSuccessUrl("/home", true)
//				.permitAll() 
//
//				.and().logout()
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				.logoutSuccessUrl("/login").invalidateHttpSession(true);
		security.csrf().disable();
		 security
         .authorizeRequests()
             .antMatchers("/login","/signup","/createUser").permitAll()
             .anyRequest().authenticated()
             .and()
         .formLogin()
             .loginPage("/login")
             .permitAll()
             .and()
         .logout()
             .permitAll();
    }

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		System.out.println("dododododo");
		 java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_example","springuser","ThePassword");
	        ScriptUtils.executeSqlScript(con, new ClassPathResource("db.sql"));
	        System.out.println("sql executed!");
		for (Users user : userRepository.findAll()) {
			auth.inMemoryAuthentication().withUser(user.getUsername())
					.password(user.getPassword()).roles(user.getRole());
//					.roles(user.getRole());
			//auth.jdbcAuthentication().dataSource(this.dataSource);
				//.withUser(user.getUsername()).password(user.getPassword()).roles(user.getRole());
		}

	}
	
	 

}
