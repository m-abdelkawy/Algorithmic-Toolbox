package Week4Practice;

import java.util.Scanner;

public class Helper {
	public static <T extends Comparable<T>> boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}

	public static <T extends Comparable<T>> void display(T[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
	
	public static <T extends Comparable<T>> void swap(T[] a, int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j]= temp; 
	}
	
	public static void swapInt(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j]= temp; 
	}
	
	public static void displayIntArr(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
	
	public static void TestClientMergeSort() {
		System.out.println("-------------------------------------------------------");
		System.out.println("   Selection Sort Test Client (Generic Version):");
		System.out.println("-------------------------------------------------------");
		System.out.print("Enter size of the Array: ");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();

		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			System.out.print("Enter Element No." + (i + 1) + ": ");
			arr[i] = scanner.nextInt();
		}

		System.out.println("Before Sorting: ");
		Helper.displayIntArr(arr);
		System.out.println();

		System.out.println("During Sorting: ");
		MergeSort.sort(arr, new int[arr.length], 0, arr.length-1);
		System.out.println();

		System.out.println("After Sorting: ");
		Helper.displayIntArr(arr);
		System.out.println();
	}
	
	public static void TestClientQuickSort() {
		System.out.println("-------------------------------------------------------");
		System.out.println("   Selection Sort Test Client (Generic Version):");
		System.out.println("-------------------------------------------------------");
		System.out.print("Enter size of the Array: ");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();

		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			System.out.print("Enter Element No." + (i + 1) + ": ");
			arr[i] = scanner.nextInt();
		}

		System.out.println("Before Sorting: ");
		Helper.displayIntArr(arr);
		System.out.println();

		System.out.println("During Sorting: ");
		QuickSort.sort(arr, 0, arr.length-1);
		System.out.println();

		System.out.println("After Sorting: ");
		Helper.displayIntArr(arr);
		System.out.println();
	}
}
