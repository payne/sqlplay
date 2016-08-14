package org.mattpayne.springboot.sql.greeting;

import java.util.List;

import org.mattpayne.springboot.sql.BooksDao;
import org.mattpayne.springboot.sql.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GreetingController {
	// Try from https://spring.io/guides/gs/relational-data-access/
		@Autowired
	    JdbcTemplate jdbcTemplate;
		
    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        
        System.out.println("\n\n\njdbcTemplate="+jdbcTemplate);
        
        return "greeting";
    }

    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
    	BooksDao dao = new BooksDao(jdbcTemplate);
    	List<Book> books = dao.findBooks();
    	System.out.println("\n\n\n"+books+"\n\n");
    	greeting.setBooks(books);
    	greeting.setExtra("this is extra!");
        model.addAttribute("greeting", greeting);
        return "result";
    }

}
