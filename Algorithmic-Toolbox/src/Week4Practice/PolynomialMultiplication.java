package Week4Practice;

public class PolynomialMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] A = { 3, 2, 5 };
		// int[] B = { 5, 1, 2 };

		int[] A = { 4, 3, 2, 1 }; // degree 3 means n - 1 == 3 => n == 4
		int[] B = { 1, 2, 3, 4 };

		// int[] c = multPolyNaive(A, B, 3);
		// int[] c = multPolyDivideAndConquerNaive(A, B, 4, 0, 0);
		int[] c = karatsubaMultiply(A, B, 4);

		display(c);
	}

	public static int[] multPolyNaive(int[] A, int[] B, int n) {
		// O(n2)
		int[] result = new int[2 * n - 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i + j] += A[i] * B[j];
			}
		}

		return result;
	}

	public static int[] multPolyDivideAndConquerNaive(int[] A, int[] B, int n, int a, int b) {
		// a => the coefficient in A that we are interested in
		// b => the coefficient in B that we are interested in

		int[] result = new int[2 * n - 1];
		if (n == 1) {// base case
			result[0] = A[a] * B[b];
			return result;
		}

		// Calculate left half of the coefficient array
		int[] AlBl = new int[n - 1];
		AlBl = multPolyDivideAndConquerNaive(A, B, n / 2, a, b);
		PopLeft(result, AlBl);

		// Calculate right half of the coefficient array
		int[] ArBr = new int[n - 1];
		ArBr = multPolyDivideAndConquerNaive(A, B, (n / 2), a + (n / 2), b + (n / 2));
		PopRight(result, ArBr);

		// Calculate Aleft * Bright
		int[] AlBr = new int[n - 1];
		AlBr = multPolyDivideAndConquerNaive(A, B, n / 2, a, b + (n / 2));

		// Calculate Aright * Bleft
		int[] ArBl = new int[n - 1];
		ArBl = multPolyDivideAndConquerNaive(A, B, n / 2, a + (n / 2), b);

		int[] sum = new int[n - 1];
		sum = SumArr(AlBr, ArBl);

		// embed Array
		midPart(result, sum, n / 2, n + (n / 2) - 1);
		return result;
	}

	public static int[] karatsubaMultiply(int[] a, int[] b, int n) {
		int[] result = new int[2 * n - 1];

		// base case where the polynomial has only one coefficient
		if (n == 1) {
			result[0] = a[0] * b[0];
			return result;
		}

		int[] al = SubArray(a, 0, n / 2);
		int[] ar = SubArray(a, n / 2 + 1, a.length - 1);
		int[] bl = SubArray(b, 0, n / 2);
		int[] br = SubArray(b, n / 2 + 1, b.length - 1);

		int[] z2 = karatsubaMultiply(al, bl, n / 2);
		PopLeft(result, z2);
		int[] z0 = karatsubaMultiply(ar, br, n / 2);
		PopRight(result, z0);
		int[] z1 = subtract2(subtract2((karatsubaMultiply(add2(al, ar), add2(bl, br), n / 2)), z2), z0);

		// embed Array
		
		return add2(add2(Multiply_Base(z2, 2*(n/2)),Multiply_Base(z1,n/2)),z0);
	}

	public static int[] add(int[] A, int[] B) {
		int[] result = new int[A.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = A[i] + B[i];
		}
		return result;
	}
	
	public static int[] add2(int[] a, int[]b)
    {

        b=Equal(a, b);

    int[] result=new int[a.length+1];

        for(int i=result.length-1;i>=1;i--){
            result[i]+=a[i-1]+b[i-1];

            if(result[i]>=10){
                result[i-1]+=result[i]/10;
                result[i]=result[i]%10;

            }
        }

        if(result[0]==0)
        {
            int[]result2=new int[a.length];

         for(int i=0;i<result2.length;i++)
            result2[i]=result[i+1];

            return result2;

        }   
        return result;
    }


	public static int[] subtract(int[] A, int[] B) {
		int[] result = new int[A.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = A[i] - B[i];
		}
		return result;
	}
	
	public static int[] subtract2(int[] a, int[]b){
	        
         if(a.length>b.length){
         b=Equal(a,b);
         }

         int sub=0;
         int carry =0;

         int[] result=new int[a.length];

         for(int i=a.length-1;i>=0;i--){

             sub=a[i]-b[i]-carry;
             carry=0;

             if(sub<0){
                 carry=1;
                 sub+=10;
             }
             result[i]=sub;

         }
         int temp=0;
         while(temp<result.length && result[temp]==0  ){
             temp++;
         }
             
         if(temp!=0){
             int[] result2=new int[result.length-temp];

             for(int i=0;i<result2.length;i++)
             result2[i]=result[i+temp];
             
             return result2;
         }
     
         return result;
     }        


	public static int[] SubArray(int[] a, int start, int end) {
		int[] result = new int[end - start + 1];

		for (int i = 0, j = start; i < result.length && j <= end; i++, j++) {
			result[i] = a[j];
		}
		return result;
	}

	public static int[] Equal(int[] a, int[] b) {

		int diff = a.length - b.length;

		int[] b2 = new int[a.length];

		for (int i = diff; i < a.length; i++)
			b2[i] = b[i - diff];

		return b2;
	}

	public static int[] Multiply_Base(int[] a, int power) {
		int[] a2 = new int[a.length + power];

		for (int i = 0; i < a.length; i++)
			a2[i] = a[i];

		return a2;
	}

	public static void PopLeft(int[] r, int[] left) {
		for (int i = 0; i < left.length; i++) {
			r[i] = left[i];
		}
	}

	public static void PopRight(int[] r, int[] right) {
		int rLength = r.length;

		for (int i = 0; i < right.length; i++) {
			r[rLength - 1 - i] = right[right.length - 1 - i];
		}
	}

	public static int[] SumArr(int[] r, int[] l) {
		int[] sum = new int[r.length];
		for (int i = 0; i < l.length; i++) {
			sum[i] = l[i] + r[i];
		}
		return sum;
	}

	public static void midPart(int[] res, int[] empedded, int start, int end) {
		for (int i = start; i < end; i++) {
			res[i] += empedded[i - start];
		}
	}

	public static int[] multPolyDivideAndConquerFaster(int[] A, int[] B, int n, int a, int b) {
		int[] result = new int[2 * n - 1];
		if (n == 1) {// base case
			result[0] = A[a] * B[b];
			return result;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i + j] += A[i] * B[j];
			}
		}

		return result;
	}

	public static void display(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
}
