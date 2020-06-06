//package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxPairwiseProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		// int n = 2 * 10 * 10 * 10 * 10 * 10;
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
			// numbers[i-1] = i;
		}
		System.out.println(getMaxPairwiseProduct(numbers));
	}

	static long getMaxPairwiseProduct(int[] numbers) {
		int n = numbers.length;

		int max_index1 = -1;
		int max_index2 = -1;

		for (int i = 0; i < n; i++) {
			if (max_index1 == -1 || numbers[i] > numbers[max_index1])
				max_index1 = i;
		}

		for (int i = 0; i < n; i++) {
			// if ((numbers[i] != numbers[max_index1]) && (max_index2 == -1 || numbers[i] >
			// numbers[max_index2]))
			// max_index2 = i;

			if ((i != max_index1) && (max_index2 == -1 || numbers[i] > numbers[max_index2]))
				max_index2 = i;
		}

		return Long.valueOf(numbers[max_index1]) * Long.valueOf(numbers[max_index2]);
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
