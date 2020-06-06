//package Week2;

import java.util.Scanner;

public class FibonacciPartialSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		long m = scanner.nextLong();
		long n = scanner.nextLong();
		long s = getFibonacciSumFast(m, n);
		System.out.println(s);
	}

	private static long getFibonacciSum(long m, long n) {
		if (m == 0 && n == 0) {
			return 0;
		}

		long previous = 0;
		long current = 1;
		long sum = 0;

		if (m < 2) {
			m = 2;
			sum = previous + current;
		}

		for (long i = 2; i < m; i++) {
			long tempPrevious = previous;
			previous = current;
			current += tempPrevious % 10;

			// System.out.println(current);
			// System.out.println("Finished");
		}
		for (long i = m; i <= n; i++) {
			long tempPrevious = previous;
			previous = current;
			current += tempPrevious % 10;
			sum += current % 10;

			// System.out.println(current);
		}

		return sum % 10;
	}

	private static long getFibonacciSumFast(long m, long n) {
		if (m == 0 && n == 0) {
			return 0;
		}

		long rem60M = m % 60;

		long rem60N = n % 60;

		while (rem60N < rem60M) {
			rem60N += 60;
		}

		long previous = 0;
		long current = 1;
		long sum = 0;

		if (rem60M < 2) {
			rem60M = 2;
			sum = previous + current;
		}

		for (long i = 2; i < rem60M; i++) {
			long tempPrevious = previous;
			previous = current;
			current += tempPrevious % 10;
			//current %= 10;
			// System.out.println(current);
			// System.out.println("Finished");
		}
		for (long i = rem60M; i <= rem60N; i++) {
			long tempPrevious = previous;
			previous = current;
			current += tempPrevious % 10;
			//current %= 10;

			sum += current % 10;

			// System.out.println(current);
		}

		return sum % 10;
	}
}
