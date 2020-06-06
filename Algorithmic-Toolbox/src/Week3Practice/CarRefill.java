package Week3Practice;

public class CarRefill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[] x = { 0, 350, 550, 750, 950, 1200 };
		int L = 400;

		int nRefill = minRefill(x, n, L);

		System.out.println("Number of Refills: " + nRefill);
	}

	public static int minRefill(int[] xArrDistance, int nStation, int fullTankDistance) {
		int numRefill = 0, currentRefill = 0, lastRefill = 0;

		while (currentRefill <= nStation) {
			lastRefill = currentRefill;
			while (currentRefill <= nStation
					&& xArrDistance[currentRefill + 1] - xArrDistance[lastRefill] <= fullTankDistance) {
				currentRefill += 1;
			}
			if (currentRefill == lastRefill)
				return -1;

			if (currentRefill <= nStation) {
				System.out.println("Current Refill: " + xArrDistance[currentRefill]);
				numRefill += 1;

			}
		}

		return numRefill;
	}
}
