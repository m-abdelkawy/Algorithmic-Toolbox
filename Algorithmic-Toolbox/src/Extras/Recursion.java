package Extras;

import java.util.Scanner;

public class Recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		
		System.out.println("Factorial of " + a + " is: " + factorialRecursive(a));
	}

	public static double factorialRecursive(int num) {
		if (num <= 1)
			return 1;
		return num * factorialRecursive(num - 1);
	}
}
