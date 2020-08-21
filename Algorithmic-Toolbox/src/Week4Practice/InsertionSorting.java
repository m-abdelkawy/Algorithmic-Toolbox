package Week4Practice;

public class InsertionSorting {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 7, 1, 3, 9 };
		insertionSort(arr);
		display(arr);
	}

	public static void insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int j = i - 1;
			while (j >= 0 && arr[j] > arr[j + 1]) {
				swap(j + 1, j, arr);
				j--;
			}
		}
		System.out.println("ddddddddd");
	}

	public static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void display(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}
}
