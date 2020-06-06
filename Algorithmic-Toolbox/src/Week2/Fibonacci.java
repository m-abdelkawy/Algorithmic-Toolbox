
package Week2;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		System.out.println(calc_fib(n));
	}

	private static long calc_fib(int n) {
		if (n <= 1)
			return n;
		int[] fArr = new int[n + 1];
		fArr[0] = 0;
		fArr[1] = 1;
		int i = 2;
		while (i <= n) {
			fArr[i] = fArr[i - 1] + fArr[i - 2];
			i++;
		}

		return fArr[n];
	}
}
