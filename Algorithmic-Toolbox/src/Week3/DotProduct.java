//package Week3;

import java.util.Scanner;

public class DotProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = scanner.nextInt();
		}
		System.out.println(maxDotProduct(a, b));
	}

	private static long maxDotProduct(int[] a, int[] b) {
		// a: profit per click
		// b: average number of clicks per day
		int n = a.length;
		int lim = n;

		

		long result = 0;

		while (lim > 0) {
			long maxProduct = 0;
			
			int maxA = Integer.MIN_VALUE;
			int maxB = Integer.MIN_VALUE;

			int iMaxA = 0;
			int iMaxB = 0;

			for (int i = 0; i < n; i++) {
				if (a[i] >= maxA) {
					iMaxA = i;
					maxA = a[i];
				}
			}

			for (int j = 0; j < n; j++) {
				if (b[j] >= maxB) {
					iMaxB = j;
					maxB = b[j];
				}
			}

			a[iMaxA] = Integer.MIN_VALUE;
			b[iMaxB] =Integer.MIN_VALUE;
			lim--;
			maxProduct = maxA * maxB;
			result += maxProduct;
		}

		return result;
	}
}
