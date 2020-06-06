//package Week2;

import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		System.out.println(euclidgcd(a, b));
	}

	public static int euclidgcd(int a, int b) {
		if (b == 0)
			return a;

		int aPrime = a % b;

		return euclidgcd(b, aPrime);
	}
}
