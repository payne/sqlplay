package org.mattpayne.springboot.sql;

import java.util.List;

import org.mattpayne.springboot.sql.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
@EnableAutoConfiguration
public class BooksDao {

	// Try from https://spring.io/guides/gs/relational-data-access/
		@Autowired
	    JdbcTemplate jdbcTemplate;

		public List<Book> findBooks() {
			System.out.println(jdbcTemplate);
			return null;
			// based on https://spring.io/guides/gs/relational-data-access/
//			jdbcTemplate.query(
//	                "SELECT id, bookid, title, author, publisher, stock FROM customers WHERE first_name = ?", new Object[] { "Josh" },
//	                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
//	        ).forEach(customer -> log.info(customer.toString()));
		}
}
