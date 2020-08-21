package Week4Practice;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 7, 1, 3, 9 };
		selectionSort(arr);
		display(arr);
	}

	public static void selectionSort(int[] arr) {
		//O(n2)
		int n = arr.length;
		int minIndex = 0;
		for (int i = 0; i < n-1; i++) {
			minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex])
					minIndex = j;
			}
			if (arr[minIndex] != arr[i])
				swap(i, minIndex, arr);
		}
	}

	public static void swap(int i, int minIndex, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex] = temp;
	}

	public static void display(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}

	public static int findSmallestIndex(int st, int end, int[] arr) {
		int smallestIndex = st;
		for (int i = st; i <= end; i++) {
			if (arr[i] < arr[smallestIndex])
				smallestIndex = i;
		}
		return smallestIndex;
	}

}
