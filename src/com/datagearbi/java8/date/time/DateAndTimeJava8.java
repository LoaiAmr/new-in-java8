package com.datagearbi.java8.date.time;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DateAndTimeJava8 {

	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>();

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(DateAndTimeJava8.class.getResourceAsStream("people.txt")));

		Stream<String> stream = reader.lines();

		stream.map(line -> {
			String[] s = line.split(" ");
			String name = s[0].trim();
			int year = Integer.parseInt(s[1]);
			Month month = Month.of(Integer.parseInt(s[2]));
			int day = Integer.parseInt(s[3]);
			Person person = new Person(name, LocalDate.of(year, month, day));
			
			persons.add(person);
			
			return person;			
			
		}).forEach(System.out::println);
	
		System.out.println();
		LocalDate now = LocalDate.of(2020, Month.NOVEMBER, 8);
		
		persons.stream().forEach(
				p -> {
					Period period = Period.between(p.getDateOfBirth(), now);
					System.out.println(p.getName() + " was Born " +
					period.get(ChronoUnit.YEARS) + " Year "  +  
					period.get(ChronoUnit.MONTHS) + " Month "  +  
					"[" + p.getDateOfBirth().until(now, ChronoUnit.MONTHS) + "] Months");
					
					
				});
		
		
		
		
	
	}

}
