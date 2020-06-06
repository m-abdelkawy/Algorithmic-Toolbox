//package Week3;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.kerberos.KerberosKey;

public class CoveringSegments {
	private static class Segment {
		int start, end;

		Segment(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Segment[] segments = new Segment[n];
		for (int i = 0; i < n; i++) {
			int start, end;
			start = scanner.nextInt();
			end = scanner.nextInt();
			segments[i] = new Segment(start, end);
		}
		Integer[] points = optimalPoints(segments);
		System.out.println(points.length);
		for (int point : points) {
			System.out.print(point + " ");
		}
	}

	private static Integer[] optimalPoints(Segment[] segments) {
		// write your code here
		List<Integer> lstPt = new ArrayList<Integer>(); 
		Integer[] points = new Integer[2 * segments.length];
		for (int i = 0; i < segments.length; i++) {
			points[2 * i] = segments[i].start;
			points[2 * i + 1] = segments[i].end;
		}
		
		while(points.length > 0) {
			int indexMinRight = chooseMinRightPoint(points);
			lstPt.add(points[indexMinRight]);
			points = RemoveSegmentsByEndPt(points, indexMinRight);
		}

		return lstPt.toArray(new Integer[lstPt.size()]);
	}

	private static int chooseMinRightPoint(Integer[] points) {
		int n = points.length / 2;

		int minEndPt = Integer.MAX_VALUE;
		int indexMinEnd = -1;
		for (int i = 0; i < n; i++) {
			if (points[2 * i + 1] < minEndPt) {
				minEndPt = points[2 * i + 1];
				indexMinEnd = 2 * i + 1;
			}
		}

		return indexMinEnd;
	}

	private static Integer[] RemoveSegmentsByEndPt(Integer[] points, int indexEndpt) {
		List<Integer> proxyArr = new ArrayList<Integer>();

		int n = points.length / 2;
		int pt = points[indexEndpt];

		// int[] proxyArray = new int[points.length - 2];

		for (int i = 0; i < n; i++) {
			if ((pt >= points[2 * i] && pt <= points[2 * i + 1])) {
				continue;
			}

			proxyArr.add(points[2 * i]);
			proxyArr.add(points[2 * i + 1]);
		}

		return proxyArr.toArray(new Integer[proxyArr.size()]);
	}
}
