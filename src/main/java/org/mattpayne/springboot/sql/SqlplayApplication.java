package org.mattpayne.springboot.sql;

import org.mattpayne.springboot.sql.servlets.FooServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication
public class SqlplayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqlplayApplication.class, args);
	}
	
	// from http://stackoverflow.com/questions/20915528/how-can-i-register-a-secondary-servlet-with-spring-boot
	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		System.out.println("\n\n\n\njdbcTemplate="+jdbcTemplate); // this shows not-null!  :-)
	    return new ServletRegistrationBean(new FooServlet(),"/someOtherUrl/*");
	}
	
	// Try from https://spring.io/guides/gs/relational-data-access/
	@Autowired
    JdbcTemplate jdbcTemplate;

	
}
