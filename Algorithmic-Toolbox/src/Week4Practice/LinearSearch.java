package Week4Practice;

public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 3, 4, 7, 9, 12, 2 };
		int index = linearSearchDivideAndConquer(arr, 0, arr.length-1, 8);
		System.out.println(index);
	}

	public static int linearSearchDivideAndConquer(int[] a, int low, int high, int key) {
		if (high < low)
			return -1; //Not found
		else if (a[low] == key)
			return low;

		return linearSearchDivideAndConquer(a, low + 1, high, key);
	}
	
	public static int linearSearchIt(int[] a, int low, int high, int key) {
		for (int i = low; i < high+1; i++) {
			if(a[i]==key) return i;
		}
		return -1;
	}

}
