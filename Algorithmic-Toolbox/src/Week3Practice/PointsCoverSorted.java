package Week3Practice;

public class PointsCoverSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] x = { 0, 0.2, 0.8, 2.2, 2.4, 2.8, 3.2, 5, 7 };

		int nSeg = minSegments(x, 1);

		System.out.println("Min Segments: " + nSeg);
	}

	public static int minSegments(double[] x, double segLength) {
		int nSeg = 0;
		int n = x.length;
		int i = 0;

		while (i < n) {
			double r = x[i] + segLength;
			i++;
			while (i < n && x[i] <= r) {
				i++;
			}
			nSeg++;
		}

		return nSeg;
	}
}
