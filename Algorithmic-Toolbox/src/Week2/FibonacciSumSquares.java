//package Week2;

import java.util.Scanner;

public class FibonacciSumSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long s = getFibonacciSumSquaresFast(n);
		System.out.println(s);
	}

	private static long getFibonacciSumSquares(long n) {
		if (n <= 1)
			return n;

		int previous = 0;
		int current = 1;

		int sumSquare = previous + current;

		for (int i = 2; i <= n; i++) {
			int tempPrevious = previous;
			previous = current;
			current += tempPrevious % 10;

			sumSquare += current * current;
			sumSquare %= 10;
		}
		
		return sumSquare;
	}
	
	private static long getFibonacciSumSquaresFast(long n) {
		if (n <= 1)
			return n;

		long rem60 = n%60;
		
		if(rem60 == 0) return 0;
		
		int previous = 0;
		int current = 1;

		int sumSquare = previous + current;

		for (long i = 2; i <= rem60; i++) {
			int tempPrevious = previous;
			previous = current;
			current += tempPrevious % 10;

			sumSquare += current * current;
			sumSquare %= 10;
		}
		
		return sumSquare;
	}
}
