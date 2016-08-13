package org.mattpayne.springboot.sql.greeting;

public class Greeting {

    private long id;
    private String content;
	private String extra;

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

}
