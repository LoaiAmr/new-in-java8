package com.datagearbi.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TypesOfOperationsInStream {

	public static void main(String[] args) {
	
		Stream<String> numberStream = Stream.of("One", "Two", "Three", "Four", "Five");
		

		Predicate<String> pred1 = Predicate.isEqual("Two");
		Predicate<String> pred2 = Predicate.isEqual("Three");
		
		List<String> list = new ArrayList<>();
		
		numberStream
				.peek(System.out::println) //It is an Intermediate, Lazy Operation...
				.filter(pred1.or(pred2))//It is an Intermediate, Lazy Operation...
//				.peek(list::add);
				.forEach(list::add);//It is an Terminal, Not Lazy Operation...
		
		System.out.println("Done...");
		System.out.println("The size: " + list.size());
	
	}
}
