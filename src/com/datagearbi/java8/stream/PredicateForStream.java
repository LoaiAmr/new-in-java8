package com.datagearbi.java8.stream;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateForStream {

	public static void main(String[] args) {


		Stream<String> numberStream = Stream.of("One", "Two", "Three", "Four", "Five");
		Predicate<String> pred1 = s -> s.length() > 3;
		Predicate<String> pred2 = Predicate.isEqual("Four");
		
		
		numberStream
//		.filter(pred1)
//		.filter(pred2)
//		.filter(pred1.and(pred2))
		.filter(pred1.or(pred2))
		.forEach( s -> System.out.println(s));
		
	}
	
}
