//package Week6;

import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int W, n;
		W = scanner.nextInt();
		n = scanner.nextInt();
		int[] w = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = scanner.nextInt();
		}
		System.out.println(optimalWeight(W, w));
	}

	static int optimalWeight(int W, int[] w) {
		int n = w.length;
		int[][] val = new int[W + 1][n + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < W; j++) {
				val[j + 1][i + 1] = val[j + 1][i];
				if (j+1 >= w[i]) {
					int value = val[(j+1) - w[i]][i] + w[i];
					if (value > val[j + 1][i+1]) {
						val[j + 1][i+1] = value;
					}
				}
			}
		}
		return val[W][n];
	}
}
