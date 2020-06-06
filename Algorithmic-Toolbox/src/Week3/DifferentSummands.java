//package Week3;

import java.util.*;

public class DifferentSummands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> summands = optimalSummands(n);
		System.out.println(summands.size());
		for (Integer summand : summands) {
			System.out.print(summand + " ");
		}
	}

	private static List<Integer> optimalSummands(int n) {
		List<Integer> summands = new ArrayList<Integer>();

		for (int i = 1; i < n + 1; i++) {
			if (n - i > i) {
				summands.add(Integer.valueOf(i));
				n -= i;
			} else {
				summands.add(Integer.valueOf(n));
				break;
			}
		}

		return summands;
	}
}
