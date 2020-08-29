//package Week5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Scanner scanner = new Scanner(System.in); int n = scanner.nextInt();
		 * //List<Integer> sequence = optimal_sequence(n); int[] sequence =
		 * dp_sequence(n); System.out.println(sequence.length - 1); for (Integer x :
		 * sequence) { System.out.print(x + " "); } System.out.print("number:" + " " +
		 * sequence[n]);
		 */

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		// List<Integer> sequence = optimal_sequence(n);
		List<Integer> sequence = dp_sequence2(n);
		System.out.println(sequence.size() - 1);
		for (Integer x : sequence) {
			System.out.print(x + " ");
		}
	}

	private static int[] dp_sequence(int n) {
		int[] arr = new int[n + 1];
		for (int i = 2; i < n + 1; i++) {
			int min1 = arr[i - 1];
			int min2 = Integer.MAX_VALUE, min3 = Integer.MAX_VALUE;
			if (i % 2 == 0)
				min2 = arr[i / 2];
			if (i % 3 == 0)
				min3 = arr[i / 3];

			int minOp = Math.min(min1, Math.min(min2, min3));
			arr[i] = minOp + 1;
		}
		return arr;
	}

	private static List<Integer> dp_sequence2(int n) {
		List<Integer> lstSequence = new ArrayList<Integer>();
		int[] arr = new int[n + 1];
		for (int i = 2; i < n + 1; i++) {
			int min1 = arr[i - 1];
			int min2 = Integer.MAX_VALUE, min3 = Integer.MAX_VALUE;
			if (i % 2 == 0)
				min2 = arr[i / 2];
			if (i % 3 == 0)
				min3 = arr[i / 3];

			int minOp = Math.min(min1, Math.min(min2, min3));

			arr[i] = minOp + 1;
		}
		lstSequence.add(n);
		for (int i = n, j = n - 1; i >= 1 & j >= 1; j--) {
			if (arr[i] - arr[j] == 1 && (j*2 == i || i-j == 1 || j*3 ==i)) {
				lstSequence.add(j);
				i = j;
			}
		}
		Collections.reverse(lstSequence);
		return lstSequence;
	}

	private static List<Integer> optimal_sequence(int n) {
		List<Integer> sequence = new ArrayList<Integer>();
		while (n >= 1) {
			sequence.add(n);
			int min1 = n - 1;
			int min2 = Integer.MAX_VALUE;
			int min3 = Integer.MAX_VALUE;
			if (n % 2 == 0) {
				min2 = n / 2;
			}
			if (n % 3 == 0) {
				min3 = n / 3;
			}
			int min = Math.min(min1, Math.min(min2, min3));
			if (min == min1) {
				n -= 1;
			} else if (min == min2) {
				n /= 2;
			} else if (min == min3) {
				n /= 3;
			}
		}

		Collections.reverse(sequence);
		return sequence;
	}
}
