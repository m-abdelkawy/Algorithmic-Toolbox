package Week5Practice;

import java.util.Arrays;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//how many operations to convert string2 to string1
		String dna1 = "editing";
		String dna2 = "distance";
		
		
		System.out.println(editDist(dna1, dna2));
	}

	public static int editDist(String str1, String str2) {
		int m = str1.length() + 1;
		int n = str2.length() + 1;
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			arr[i][0] = i;
		}
		for (int j = 0; j < n; j++) {
			arr[0][j] = j;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				int inserion = arr[i - 1][j]+1;
				int deletion = arr[i][j - 1]+1;
				int match = arr[i - 1][j - 1];
				int mismatch = arr[i - 1][j - 1] + 1;
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					arr[i][j] = match;
				}
				else {
					arr[i][j]=Math.min(Math.min(inserion, deletion), mismatch);
				}
			}
		}
		displayArr2Dim(arr);
		return arr[m-1][n-1];
	}

	private static void displayArr2Dim(int[][] arr){
		System.out.println(arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
