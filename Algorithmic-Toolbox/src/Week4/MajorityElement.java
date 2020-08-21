//package Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MajorityElement {

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		if (getMajorityElement(a, 0, a.length - 1) != -1) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

		// System.out.println(getMajorityElement(a, 0, a.length - 1));
	}

	private static int getMajorityElement(int[] a, int left, int right) {
		if (a.length == 2 && a[0] != a[1])
			return -1;
		if (left == right)
			return -1;
		if (left + 1 == right) {
			return a[left];
		}

		int mid = left + (right - left) / 2;

		int leftElm = getMajorityElement(a, left, mid);
		int rightElm = getMajorityElement(a, mid + 1, right);

		int leftCount = count(a, left, right, leftElm);
		int rightCount = count(a, leftCount, right, rightElm);

		if (leftCount != -1 && leftCount > (right - left + 1) / 2 && leftCount >= rightCount)
			return leftElm;
		else if (rightCount != -1 && rightCount > (right - left + 1) / 2 && rightCount >= leftCount)
			return rightElm;

		return -1;
	}

	public static int count(int[] a, int left, int right, int elm) {
		int count = 0;
		for (int i = left; i <= right; i++) {
			if (a[i] == elm)
				count++;
		}
		return count;
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
