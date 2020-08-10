package com.datagearbi.java8.map.enhancments;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuldingBiMap {

	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>();

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(BuldingBiMap.class.getResourceAsStream("people.txt")));

		Stream<String> stream = reader.lines();

		stream.map(line -> {
			String[] s = line.split(" ");
			String name = s[0].trim();
			int age = Integer.parseInt(s[1]);
			String gender = s[2];
			Person person = new Person(name, age, gender);

			persons.add(person);

			return person;

		}).forEach(System.out::println);

		System.out.println();
		Map<Integer, List<Person>> map = persons.stream().collect(Collectors.groupingBy(Person::getAge));

		map.forEach((age, list) -> System.out.println(age + " -> " + list));

		Map<Integer, Map<String, List<Person>>> biMap = new HashMap<>();

		persons.forEach(person -> biMap.computeIfAbsent(person.getAge(), HashMap::new).merge(person.getGender(),
				new ArrayList<>(Arrays.asList(person)), (l1, l2) -> {
					l1.addAll(l2);
					return l1;
				})
		);
		
		System.out.println("Bimap is Here...");
		biMap.forEach((age, list) -> System.out.println(age + " -> " + list));
		
		
	}

}
