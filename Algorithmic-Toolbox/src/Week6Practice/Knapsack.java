package Week6Practice;

import java.util.Arrays;

public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int capacity = 10;
		int[] vArr = { 30, 14, 16, 9 };
		int[] wArr = { 6, 3, 4, 2 };

		System.out.println(knapsackNoRepetition(capacity, vArr, wArr));
	}

	private static int knapsackRepetition(int capacity, int[] vArr, int[] wArr) {
		int n = vArr.length;
		int[] val = new int[capacity + 1];
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < capacity + 1; i++) {
			val[i] = 0;
			for (int j = 0; j < n; j++) {
				// diff = i - wArr[j];
				if (wArr[j] <= i) {
					int value = val[i - wArr[j]] + vArr[j];
					if (value > val[i]) {
						val[i] = value;
					}
				}
			}
		}
		return val[capacity];
	}

	private static int knapsackNoRepetition(int capacity, int[] vArr, int[] wArr) {
		int n = vArr.length;
		int[][] val = new int[capacity + 1][n + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < capacity; j++) {
				val[j + 1][i + 1] = val[j + 1][i];
				if (j+1 >= wArr[i]) {
					int value = val[(j+1) - wArr[i]][i] + vArr[i];
					if (value > val[j + 1][i+1]) {
						val[j + 1][i+1] = value;
					}
				}
			}
		}
		displayArr2Dim(val);
		return val[capacity][n];
	}

	private static void displayArr2Dim(int[][] arr){
		System.out.println(arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
