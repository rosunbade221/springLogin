package login;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	@Autowired 
	DataSource dataSource;
    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
       
    }
}
