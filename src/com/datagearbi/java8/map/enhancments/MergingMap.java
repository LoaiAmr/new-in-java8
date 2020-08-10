package com.datagearbi.java8.map.enhancments;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergingMap {

	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>();

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(MergingMap.class.getResourceAsStream("people.txt")));

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

		List<Person> list1 = persons.subList(1, 10);
		List<Person> list2 = persons.subList(10, persons.size());

		Map<Integer, List<Person>> map1 = mapByAge(list1);
		System.out.println("Map1...");
		map1.forEach((age, list) -> System.out.println(age + " -> " + list));

		
		Map<Integer, List<Person>> map2 = mapByAge(list2);
		System.out.println("Map2...");
		map2.forEach((age, list) -> System.out.println(age + " -> " + list));
		
		
		map2.entrySet().stream()
					.forEach(
								entry ->
								map1.merge(entry.getKey(),
										   entry.getValue(),
										   (l1, l2) ->{
											 	l1.addAll(l2);
											 	return l1;
											 	})
							);
		
		System.out.println("Map 1 Merged...");
		map1.forEach((age, list) -> System.out.println(age + " -> " + list));
		

	}

	private static Map<Integer, List<Person>> mapByAge(List<Person> list) {
		Map<Integer, List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getAge));
		return map;

	}

}
