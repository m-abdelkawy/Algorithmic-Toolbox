//package Week3;

import java.util.Scanner;

public class CarFueling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int dist = scanner.nextInt();
		int tank = scanner.nextInt();
		int n = scanner.nextInt();
		int stops[] = new int[n];
		for (int i = 0; i < n; i++) {
			stops[i] = scanner.nextInt();
		}

		System.out.println(computeMinRefills(dist, tank, stops));
	}

	static int computeMinRefills(int dist, int tank, int[] stops) {
		int nStop = stops.length;
		int nDist = nStop + 2;

		int[] distanceArr = new int[nDist];
		distanceArr[0] = 0;
		for (int i = 1; i < nDist - 1; i++) {
			distanceArr[i] = stops[i - 1];
		}
		distanceArr[distanceArr.length - 1] = dist;

		int currentRefill = 0;
		int lastRefill = 0;
		int nRefill = 0;

		while (currentRefill <= nStop) {
			lastRefill = currentRefill;

			for (int i = currentRefill + 1; i < nDist; i++) {
				if (distanceArr[i] - distanceArr[lastRefill] <= tank) {
					currentRefill = i;
				} else {
					break;
				}
			}

			if (currentRefill == lastRefill)
				return -1;
			if (currentRefill <= nStop)
				nRefill++;

		}

		return nRefill;
	}
}
