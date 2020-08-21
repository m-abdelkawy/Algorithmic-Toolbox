//package Week4;

import java.util.Scanner;

public class Inversions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int[] b = new int[n];
		System.out.println(getNumberOfInversions(a, b, 0, a.length - 1));
	}

	private static int getNumberOfInversions(int[] arr, int[] temp, int left, int right) {
		int mid, inv_count = 0; 
        if (right > left) { 
            /* Divide the array into two parts and call _mergeSortAndCountInv() 
           for each of the parts */
            mid = (right + left) / 2; 
  
            /* Inversion count will be sum of inversions in left-part, right-part 
          and number of inversions in merging */
            inv_count = getNumberOfInversions(arr, temp, left, mid); 
            inv_count += getNumberOfInversions(arr, temp, mid + 1, right); 
  
            /*Merge the two parts*/
            inv_count += merge(arr, temp, left, mid + 1, right); 
        } 
        return inv_count; 
	}

	public static int merge(int[] arr, int[] temp, int left, int mid, int right) {
		 int i, j, k; 
	        int inv_count = 0; 
	  
	        i = left; /* i is index for left subarray*/
	        j = mid; /* j is index for right subarray*/
	        k = left; /* k is index for resultant merged subarray*/
	        while ((i <= mid - 1) && (j <= right)) { 
	            if (arr[i] <= arr[j]) { 
	                temp[k++] = arr[i++]; 
	            } 
	            else { 
	                temp[k++] = arr[j++]; 
	  
	                /*this is tricky -- see above explanation/diagram for merge()*/
	                inv_count = inv_count + (mid - i); 
	            } 
	        } 
	  
	        /* Copy the remaining elements of left subarray 
	       (if there are any) to temp*/
	        while (i <= mid - 1) 
	            temp[k++] = arr[i++]; 
	  
	        /* Copy the remaining elements of right subarray 
	       (if there are any) to temp*/
	        while (j <= right) 
	            temp[k++] = arr[j++]; 
	  
	        /*Copy back the merged elements to original array*/
	        for (i = left; i <= right; i++) 
	            arr[i] = temp[i]; 
	  
	        return inv_count; 
	}
}
