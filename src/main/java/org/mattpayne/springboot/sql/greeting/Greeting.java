package org.mattpayne.springboot.sql.greeting;

import java.util.List;

import org.mattpayne.springboot.sql.model.Book;

public class Greeting {

    private long id;
    private String content;
	private String extra;
	private List<Book> books;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	public void setExtra(String string) {
		this.extra = string;
	}

	public String getExtra() {
		return extra;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

}
