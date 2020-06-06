package Week4Practice;

import java.beans.IntrospectionException;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int A[] = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}

		System.out.println("Enter number to search for: ");

		int key = scanner.nextInt();

		System.out.println(binarySearchIterative(A, 0, n - 1, key));

	}

	public static int binarySearch(int[] A, int low, int high, int key) {
		if (high < low)
			return low - 1;

		int mid = (high + low) / 2;

		if (key == A[mid])
			return mid;
		else if (key < A[mid])
			return binarySearch(A, low, mid - 1, key);
		else
			return binarySearch(A, mid + 1, high, key);
	}

	public static int binarySearchIterative(int[] A, int low, int high, int key) {
		while (low <= high) {
			int mid = (high + low) / 2;

			if (key == A[mid])
				return mid;
			else if (key < A[mid])
				high = mid - 1;
			else if (key > A[mid])
				low = mid + 1;
		}
		return low - 1;
	}
}
