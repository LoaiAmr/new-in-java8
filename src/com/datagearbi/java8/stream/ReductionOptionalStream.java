package com.datagearbi.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionOptionalStream {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 5);
		
//			Integer red = 
			Optional<Integer> red = 
				list.stream()
					.reduce(Integer::max);
//					.reduce(0, Integer::max);
		
		System.out.println("Red: " + red);
		
	}
}
