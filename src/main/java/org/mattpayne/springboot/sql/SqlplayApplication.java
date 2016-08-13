package org.mattpayne.springboot.sql;

import org.mattpayne.springboot.sql.servlets.FooServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class SqlplayApplication {

	// use technique from https://github.com/Spring-Squad/jsp-thymeleaf-config
	@Value("${spring.view.prefix}")
	private String prefix = "";

	@Value("${spring.view.suffix}")
	private String suffix = "";

	@Value("${spring.view.view-names}")
	private String viewNames = "";

	@Bean
	InternalResourceViewResolver jspViewResolver() {
		final InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix(prefix);
		vr.setSuffix(suffix);
		vr.setViewClass(JstlView.class);
		vr.setViewNames(viewNames);
		return vr;
	}

	public static void main(String[] args) {
		SpringApplication.run(SqlplayApplication.class, args);
	}

	// from
	// http://stackoverflow.com/questions/20915528/how-can-i-register-a-secondary-servlet-with-spring-boot
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new FooServlet(), "/someOtherUrl/*");
	}
}
