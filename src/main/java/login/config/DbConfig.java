//package login.config;
//
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.jdbc.datasource.init.ScriptUtils;
//
//@Configuration
//public class DbConfig {
//
//	@Bean
//	public void loadSql(){
//		java.sql.Connection con=null;
//		try {
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_example","springuser","ThePassword");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//        ScriptUtils.executeSqlScript(con, new ClassPathResource("db.sql"));
//        System.out.println("sql executed!");
//	}
//}
