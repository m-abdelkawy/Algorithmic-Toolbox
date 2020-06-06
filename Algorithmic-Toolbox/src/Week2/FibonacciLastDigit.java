package Week2;

import java.util.Scanner;

public class FibonacciLastDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        System.out.println(c);
	}

	private static int getFibonacciLastDigit(int n) {
		if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous%10;
            previous = current%10;
            current = (tmp_previous + current)%10;
        }

        return current % 10;
	}
}
