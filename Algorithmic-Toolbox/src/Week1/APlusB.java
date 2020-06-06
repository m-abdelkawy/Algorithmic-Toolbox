package Week1;

import java.util.Scanner;

public class APlusB{

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		System.out.println(sumOfDigits(a, b));
}

	static int sumOfDigits(int first_digit, int second_digit) {
		return first_digit + second_digit;
	}
}
