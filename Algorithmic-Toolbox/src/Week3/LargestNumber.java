//package Week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		String[] a = new String[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.next();
		}
		System.out.println(largestNumber(a));

	}

	private static String largestNumber(String[] a) {
		int indexMax = 0;
		String maxInt = "0";

		String result = "";

		while (a.length > 1) {
			maxInt = "0";
			for (int i = 0; i < a.length; i++) {
				for (int j = i + 1; j < a.length; j++) {
					/*
					 * if (Integer.parseInt(a[j]) > 0 && firstDigitGet(Integer.parseInt(a[j])) >
					 * firstDigitGet(Integer.parseInt(a[j - 1]))) { indexMaxNum = i; }
					 */

					
					if (isBigger(a[i], a[j])) {
						if(isBigger(maxInt, a[i])) {
							continue;
						}
						maxInt = a[i];
						indexMax = i;
					} else {
						if(isBigger(maxInt, a[j])) {
							continue;
						}
						maxInt = a[j];
						indexMax = j;
					}
				}

			}
			result += maxInt;
			a = RemoveSegmentsByEndPt(a, indexMax);
		}
		return result+=a[0];
	}

	private static int firstDigitGet(int num) {
		while (num >= 10) {
			num /= 10;
		}
		return num;
	}

	private static boolean isBigger(String a, String b) {
		// bool isALessInLength = a.length()<b.length()?true:false;

		String ab = a + b;
		String ba = b + a;

		if (Integer.parseInt(ab) >= Integer.parseInt(ba))
			return true;

		return false;
	}

	private static String[] RemoveSegmentsByEndPt(String[] points, int indexEndpt) {
		List<String> proxyArr = new ArrayList<String>();

		int n = points.length;

		for (int i = 0; i < n; i++) {
			if (i == indexEndpt) {
				continue;
			}

			proxyArr.add(points[i]);
		}

		return proxyArr.toArray(new String[proxyArr.size()]);
	}
}
