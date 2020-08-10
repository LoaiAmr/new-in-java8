package com.datagearbi.java8.lambda.excepression;

import java.io.File;
import java.io.FileFilter;

public class LambdaExcepression {

	public static void main(String[] args) {

//		FileFilter filter = new FileFilter() {
//
//			@Override
//			public boolean accept(File pathname) {
//				return pathname.getName().endsWith(".metadata");
//			}
//		};

		FileFilter  filterLambda = (File pathname) -> pathname.getName().endsWith(".metadata");
		
		File directory = new File("C:\\Users\\user\\eclipse-workspace");
		File[] files = directory.listFiles(filterLambda);

		for (File f : files) {
			System.out.println(f);
		}

	}

}
