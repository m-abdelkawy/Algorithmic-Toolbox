package Week4Practice;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Helper.TestClientMergeSort();
	}

	public static void sort(int[] a, int[] aux, int l, int r) {
		//base case
		if(r<=l) return;
		
		// recursive sorting
		int mid = l + (r-l)/2;
		sort(a, aux, l, mid);
		sort(a, aux, mid+1, r);

		//merge the two halves
		merge(a, aux, l, mid, r);
	}

	public static void merge(int[] a, int[] aux, int l, int mid, int r) {
		//copy elements in the original array into the auxiliary array
		for (int i = l; i <= r; i++) {
			aux[i] =a[i];
		}
		
		//merge
		int i = l, j = mid+1;
		for (int k = l; k <= r; k++) {
			if(i > mid) //left array is finished
				a[k]= aux[j++];
			else if(j > r) //right array is finished
				a[k] = aux[i++];
			else if(aux[i]<= aux[j])
				a[k]=aux[i++];
			else a[k]=aux[j++];
		}
	}

	public static void display(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}
}
