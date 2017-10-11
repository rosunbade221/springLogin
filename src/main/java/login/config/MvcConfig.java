package login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{

	@Bean(name = "dataSource")
	 public DriverManagerDataSource dataSource() {
	     DriverManagerDataSource dataSource = new DriverManagerDataSource();
	     dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	     dataSource.setUrl("jdbc:mysql://localhost:3306/db_example");
	     dataSource.setUsername("springuser");
	     dataSource.setPassword("ThePassword");
	     return dataSource;
	 }
}
