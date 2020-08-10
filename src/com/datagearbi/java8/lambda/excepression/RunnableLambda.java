package com.datagearbi.java8.lambda.excepression;

public class RunnableLambda {

	public static void main(String[] args) throws InterruptedException {

//		Runnable runnable = new Runnable() {
//
//			@Override
//			public void run() {
//				for (int i = 0; i < 5; i++) {
//					
//					System.out.println("Hello World  From Thread ["
//							+ Thread.currentThread().getName()
//							+ "]");
//					
//				}
//			}
//		};

		Runnable runnableLambda = () -> {

			for (int i = 0; i < 5; i++) {
				System.out.println("Hello World  From Thread [" + Thread.currentThread().getName() + "]");
			}
		};

		Thread thread = new Thread(runnableLambda);
		thread.start();
		thread.join();

	}

}
