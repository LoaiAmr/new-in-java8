package com.datagearbi.java8.lambda.excepression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChainConsumer {

	public static void main(String[] args) {

		List<String> numbers = Arrays.asList("One","Two", "Three", "Four", "Five");
		
		List<String> result = new ArrayList<>();
		
//		Consumer<String>  c1 = s -> System.out.println(s);
		Consumer<String>  c1 = System.out::println;
		Consumer<String>  c2 =result::add;
	 	
//		numbers.forEach(c1);
		numbers.forEach(c1.andThen(c2));
		System.out.println("The size of result: " + result.size());
		

	}

}
