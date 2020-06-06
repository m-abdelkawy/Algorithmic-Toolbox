//package Week3;

import java.util.Scanner;

public class FractionalKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int capacity = scanner.nextInt();
		int[] values = new int[n];
		int[] weights = new int[n];
		for (int i = 0; i < n; i++) {
			values[i] = scanner.nextInt();
			weights[i] = scanner.nextInt();
		}
		System.out.println(getOptimalValue(capacity, values, weights));
	}

	private static double getOptimalValue(int capacity, int[] values, int[] weights) {
		double value = 0;

		int n = values.length;

		while (capacity > 0) {

			double maxValuePerUnitWeight = Double.MIN_VALUE;
			int indexMax = -1;

			for (int i = 0; i < n; i++) {
				if (weights[i] > 0 && values[i] / weights[i] > maxValuePerUnitWeight) {
					maxValuePerUnitWeight = (double)values[i] / (double)weights[i];
					indexMax = i;
				}
			}

			if(indexMax == -1) return value;
			// update values
			double amountTaken = Math.min(capacity, weights[indexMax]);
			value += amountTaken * maxValuePerUnitWeight;
			weights[indexMax] -= amountTaken;
			
			capacity -= amountTaken;
		}

		return value;
	}
}
