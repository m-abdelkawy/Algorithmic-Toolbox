//package Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		randomizedQuickSort(a, 0, n - 1);
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static Random random = new Random();

	/*
	 * This function partitions a[] in three parts a) a[l..i] contains all elements
	 * smaller than pivot b) a[i+1..j-1] contains all occurrences of pivot c)
	 * a[j..r] contains all elements greater than pivot
	 */
	private static int[] partition3(int[] a, int l, int r) {
		// write your code here
		//to handle 2 elements
		if(r-l <= 1) {
			if(a[r]<a[l])
				swap(a, r, l);
			return new int[] {l,r};
		}
		int mid = l;
		int pivot = a[r];

		while (mid <= r) {
			if (a[mid] < pivot)
				swap(a, mid++, l++);
			else if (a[mid] == pivot)
				mid++;
			else if (a[mid] > pivot)
				swap(a, mid, r--);
		}

		int m1 = l;
		int m2 = mid;
		int[] m = { m1, m2 };
		return m;
	}

	private static int partition2(int[] a, int l, int r) {
		int x = a[l];
		int j = l;
		for (int i = l + 1; i <= r; i++) {
			if (a[i] <= x) {
				j++;
				swap(a, i, j);
			}
		}
		swap(a, l, j);
		return j;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static void randomizedQuickSort(int[] a, int l, int r) {
		if (l >= r) {
			return;
		}
		// pivot random index
		int k = random.nextInt(r - l + 1) + l;
		swap(a, l, k);
		// use partition3
		int[] m = partition3(a, l, r);
		randomizedQuickSort(a, l, m[0]-1);
		randomizedQuickSort(a, m[1], r);
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
