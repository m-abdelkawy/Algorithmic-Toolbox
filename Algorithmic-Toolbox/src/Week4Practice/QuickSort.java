package Week4Practice;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Helper.TestClientQuickSort();
	}

	public static void sort(int[] a, int l, int r) {
		if (r<=l)
			return;

		int j = partition(a, l, r);
		sort(a, l, j-1);
		sort(a, j+1, r);
	}

	public static int partition(int[] a, int l, int r) {
		if(r<=l) 
			return r;
		int pivot = a[l];
		int j = l-1;
		for (int i = l; i <= r; i++) {
			if (a[i] <= pivot) {
				j++;
				Helper.swapInt(a, i, j);
			}
		}

		// put pivot in the right position
		Helper.swapInt(a, l, j);

		return j;
	}

}
