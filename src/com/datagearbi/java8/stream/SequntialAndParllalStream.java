package com.datagearbi.java8.stream;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Stream;

public class SequntialAndParllalStream {

	public static void main(String[] args) {
		String[] strings = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

		
		System.out.println("-------\nRunning sequential\n-------");
		long startTimeForSequntial = getTimeForOperation();
		run(Arrays.stream(strings).sequential());
		long endTimeForSequntial  = getTimeForOperation();
		System.out.println("The Time For Sequential Time is: " + getTime(startTimeForSequntial, endTimeForSequntial));

		System.out.println("-------\nRunning parallel\n-------");
		long startTimeForParallel= getTimeForOperation();
		run(Arrays.stream(strings).parallel());
		long endTimeForParallel  = getTimeForOperation();
		System.out.println("The Time For Sequential Time is: " + getTime(startTimeForParallel, endTimeForParallel));
	}

	public static void run(Stream<String> stream) {

		stream.forEach(s -> {
			System.out.println(LocalTime.now() + " - value: " + s + " - thread: " + Thread.currentThread().getName());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}

	public static long getTimeForOperation() {
		return System.currentTimeMillis();

	}

	public static long getTime(long startTime, long endTime) {
		return endTime - startTime;
	}

}