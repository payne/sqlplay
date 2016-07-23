package org.mattpayne.springboot.sql.dao;

public class Member {
	private final int id;
	private final String firstName, lastName;

	public Member(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
