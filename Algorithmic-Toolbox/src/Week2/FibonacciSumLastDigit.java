//package Week2;

import java.util.Scanner;

public class FibonacciSumLastDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long s = getFibonacciSumLastDigitFast(n);
		System.out.println(s);
	}

	private static long getFibonacciSumLastDigit(long n) {
		if (n <= 1)
			return n;

		int previous = 0;
		int current = 1;

		long sum = 1;
		int tempPrevious = previous;
		for (long i = 2; i <= n; i++) {
			tempPrevious = previous;
			previous = current;
			current += tempPrevious % 10;

			sum += current % 10;
		}
		return sum % 10;
	}

	private static long getFibonacciSumLastDigitFast(long n) {
		if (n <= 1)
			return n;

		long rem60 = n % 60;

		if (rem60 == 0)
			return 0;

		//long new_n = rem60 + 2;
		
		int previous = 0;
		int current = 1;

		long sum = 1;
		int tempPrevious = previous;
		for (long i = 2; i <= rem60; i++) {
			tempPrevious = previous;
			previous = current;
			current += tempPrevious % 10;

			sum += current % 10;
		}
		return sum % 10;
	}

}
