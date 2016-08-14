package org.mattpayne.springboot.sql.greeting;

import java.util.List;

import org.mattpayne.springboot.sql.BooksDao;
import org.mattpayne.springboot.sql.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GreetingController {
	private static final Logger log = LoggerFactory.getLogger(GreetingController.class);
	// Try from https://spring.io/guides/gs/relational-data-access/
	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String greetingForm(Model model) {
		model.addAttribute("greeting", new Greeting());
		log.debug("\n\n\njdbcTemplate=" + jdbcTemplate);
		return "greeting";
	}

	@RequestMapping(value = "/greeting", method = RequestMethod.POST)
	public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
		BooksDao dao = new BooksDao(jdbcTemplate);
		List<Book> books = dao.findBooks();
		log.debug("\n\n\n" + books + "\n\n");
		greeting.setBooks(books);
		greeting.setExtra("this is extra!");
		model.addAttribute("greeting", greeting);
		return "result";
	}

}
