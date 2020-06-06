//Fibonacci Number again
package Week2;

import java.util.Scanner;

public class FibonacciHuge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		int m = scanner.nextInt();
		System.out.println(getFibonacciHuge(n, m));
	}

	public static int pisanoPeriodLength(int m) {
		int previous = 0;
		int current = 1;

		int i;
		for (i = 2; i <= m * m; i++) {
			int tempPrevious = previous;
			previous = current;
			current = (current + tempPrevious) % m;

			if (previous == 0 && current == 1) {
				System.out.println("Pisano Period Length: " + (i - 1));
				return i - 1;
			}
		}
		return 2;
	}

	private static long getFibonacciHuge(long n, int m) {

		long x = n % pisanoPeriodLength(m);

		return calc_fib(x, m);
	}

	private static long calc_fib(long n, int m) {
		if (n <= 1)
			return n;

		int previous = 0;
		int current = 1;

		for (int i = 0; i < n - 1; ++i) {
			int tmp_previous = previous % m;
			previous = current % m;
			current = (tmp_previous + current) % m;
		}

		return current % m;
	}
}
