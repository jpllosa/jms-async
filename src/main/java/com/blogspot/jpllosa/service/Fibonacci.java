package com.blogspot.jpllosa.service;

public class Fibonacci {

	public String fibonacci(int numbers) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// don't care
		}
		
		if (numbers < 0) return "";
		if (numbers == 0) return "0";
		if (numbers == 1) return "1";
		
		StringBuilder sb = new StringBuilder();
		int num1 = 0;
		int num2 = 1;
		sb.append(num2);
		for (int i = 1; i < numbers; i++) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			
			int sumOfPreviousTwo = num1 + num2;
			sb.append(sumOfPreviousTwo);
			num1 = num2;
			num2 = sumOfPreviousTwo;
		}
		
		return sb.toString().trim();
	}
	
	private int fibonacciCompute(int numbers) {
		if (numbers == 1 || numbers == 2) return 1;

		return fibonacciCompute(numbers - 2) + fibonacciCompute(numbers - 1);
	}
	
	public String fibonacciRecursion(int numbers) {
		if (numbers == 0) return "0";
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= numbers; i ++) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			
			sb.append(fibonacciCompute(i));
		}
		
		return sb.toString().trim();
	}
	
}