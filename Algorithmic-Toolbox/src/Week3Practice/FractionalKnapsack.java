package Week3Practice;

import java.util.Enumeration;
import java.util.Hashtable;

public class FractionalKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int capacity = 7;
		int[] w = { 4, 3, 2 };
		int[] v = { 20, 18, 14 };

		Hashtable<Integer, int[]> hashtable = knapsackSorted(capacity, w, v);

		Enumeration<Integer> keys = hashtable.keys();

		while (keys.hasMoreElements()) {
			System.out.println(keys.nextElement());
		}
	}

	// O(n2)
	public static Hashtable<Integer, int[]> knapsack(int capacity, int[] w, int[] v) {
		int n = w.length;
		int[] q = new int[n];
		int vTotal = 0;

		Hashtable<Integer, int[]> my_dict = new Hashtable<Integer, int[]>();

		while (capacity > 0) {

			int vPerUnitMax = 0;
			int indexMaxVperUnit = 0;
			for (int j = 0; j < n; j++) {
				if (w[j] != 0 && v[j] / w[j] > vPerUnitMax) {
					vPerUnitMax = v[j] / w[j];
					indexMaxVperUnit = j;
				}
			}

			int amountTaken = Math.min(capacity, w[indexMaxVperUnit]);

			// update
			capacity -= amountTaken;
			q[indexMaxVperUnit] += amountTaken;
			vTotal += amountTaken * vPerUnitMax;
			w[indexMaxVperUnit] -= amountTaken;
		}

		my_dict.put(vTotal, q);
		return my_dict;
	}

	// O(n)
	public static Hashtable<Integer, int[]> knapsackSorted(int capacity, int[] w, int[] v) {
		int n = w.length;
		int[] q = new int[n];
		int vTotal = 0;

		Hashtable<Integer, int[]> my_dict = new Hashtable<Integer, int[]>();

		int indexMaxVperUnit = n;
		int vPerUnitMax = 0;
		while (capacity > 0 && indexMaxVperUnit >= 0) {

			indexMaxVperUnit--;

			if (w[indexMaxVperUnit] != 0) {
				vPerUnitMax = v[indexMaxVperUnit] / w[indexMaxVperUnit];

				int amountTaken = Math.min(capacity, w[indexMaxVperUnit]);

				// update
				capacity -= amountTaken;
				q[indexMaxVperUnit] += amountTaken;
				vTotal += amountTaken * vPerUnitMax;
				w[indexMaxVperUnit] -= amountTaken;
			}
		}

		my_dict.put(vTotal, q);
		return my_dict;
	}
}
