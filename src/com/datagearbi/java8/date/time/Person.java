package com.datagearbi.java8.date.time;

import java.time.LocalDate;
import java.time.LocalTime;

public class Person {

	private String name;
	private LocalDate dateOfBirth;

	public Person(String name, LocalDate dateOfBirth) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name: " + name + "], dateOfBirth: [" + dateOfBirth + "]";
	}

}
