package org.mattpayne.springboot.sql;

import java.util.List;
import java.util.stream.Collectors;

import org.mattpayne.springboot.sql.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

public class BooksDao {
	 private static final Logger log = LoggerFactory.getLogger(BooksDao.class);

	    JdbcTemplate jdbcTemplate;

		public BooksDao(JdbcTemplate jdbcTemplate2) {
			this.jdbcTemplate = jdbcTemplate2;
		}

		public List<Book> findBooks() {
			System.out.println(jdbcTemplate);
			// based on https://spring.io/guides/gs/relational-data-access/
			
			List<Book> lstBooks = jdbcTemplate.query(
	                "SELECT  bookid, title, author, published, stock FROM books ",
	                (rs, rowNum) -> new Book(rs.getInt("bookid"), rs.getString("title"), rs.getString("author"),
	                		rs.getString("published"),
	                		rs.getInt("stock")
	                		)
	        );
			//.forEach(customer -> log.info(customer.toString()));
			return lstBooks;
		}
}
