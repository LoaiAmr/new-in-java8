package com.datagearbi.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class MapStream {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> odd = Arrays.asList(1, 3, 5);
		List<Integer> even = Arrays.asList(2, 4, 6);

		List<List<Integer>> allList = Arrays.asList(list, odd, even);
		
		System.out.println(allList);
		
		Function<List<?>, Integer> size = List::size;
		Function<List<Integer>, Stream<Integer>> flatMapper = l -> l.stream();
		
		allList.stream()
//			.flatMap(flatMapper)
			.map(size)
			.forEach(System.out::println);
		
		
		

	}

}
