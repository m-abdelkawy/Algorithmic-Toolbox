package Week4Practice;

import java.util.Arrays;
import java.util.Scanner;

public class Karatsuba {

	public static int[] Multiply_Base(int[] a, int power) {
		int[] a2 = new int[a.length + power];

		for (int i = 0; i < a.length; i++)
			a2[i] = a[i];

		return a2;
	}

	public static int[] Equal(int[] a, int[] b) {

		int[] b2 = new int[a.length];

		for (int i = 0; i < b.length; i++)
			b2[i] = b[i];

		return b2;
	}

	public static int Maximum(int a, int b) {
		if (a > b)
			return a;

		else
			return b;
	}

	public static int[] Add(int[] a, int[] b) {
		if (a.length > b.length)
			b = Equal(a, b);

		int[] result = new int[a.length];

		for (int i = 0; i < result.length; i++) {
			result[i] = a[i] + b[i];
		}
		return result;
	}

	public static int[] Substract(int[] a, int[] b) {

		if (a.length > b.length) {
			b = Equal(a, b);
		}

		int[] result = new int[a.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = a[i] - b[i];
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

	public static int[] Multiplication(int[] a, int[] b) {
		int[] result = new int[a.length * 2 - 1];
		if (a.length == 1) {
			result[0] = a[0] * b[0];
			return result;
		}
		int n = a.length;

		int m = n / 2;

		int[] al = SubArray(a, 0, m - 1);
		int[] ar = SubArray(a, m, n - 1);
		int[] bl = SubArray(b, 0, m - 1);
		int[] br = SubArray(b, m, n - 1);

		int[] alar = Add(al, ar);
		int[] blbr = Add(bl, br);

		int[] z2 = Multiplication(al, bl);
		int[] z0 = Multiplication(ar, br);
		int[] z1 = Substract(Substract(Multiplication(alar, blbr), z2), z0);

		result = assembleResult(result, z2, z1, z0, n);
		return result;

	}

	public static int[] assembleResult(int[] result, int[] z2, int[] z1, int[] z0, int n) {
		// Assemble the product from the low, middle and high parts. Start with the low
		// and high parts of the product.
		for (int halfSizeIndex = 0, middleOffset = n / 2; halfSizeIndex < n-1; ++halfSizeIndex) {
			result[halfSizeIndex] += z0[halfSizeIndex];
			result[halfSizeIndex + n] += z2[halfSizeIndex];
			result[halfSizeIndex + middleOffset] += z1[halfSizeIndex];
		}

		return result;
	}

	private static double[] karatsubaMultiplyRecursive(double[] multiplicand, double[] multiplier) {

		double[] product = new double[2 * multiplicand.length];

		// Handle the base case where the polynomial has only one coefficient
		if (multiplicand.length == 1) {
			product[0] = multiplicand[0] * multiplier[0];
			return product;
		}

		int halfArraySize = multiplicand.length / 2;

		// Declare arrays to hold halved factors
		double[] multiplicandLow = new double[halfArraySize];
		double[] multiplicandHigh = new double[halfArraySize];
		double[] multipliplierLow = new double[halfArraySize];
		double[] multipliierHigh = new double[halfArraySize];

		double[] multiplicandLowHigh = new double[halfArraySize];
		double[] multipliplierLowHigh = new double[halfArraySize];

		// Fill in the low and high arrays
		for (int halfSizeIndex = 0; halfSizeIndex < halfArraySize; ++halfSizeIndex) {

			multiplicandLow[halfSizeIndex] = multiplicand[halfSizeIndex];
			multiplicandHigh[halfSizeIndex] = multiplicand[halfSizeIndex + halfArraySize];
			multiplicandLowHigh[halfSizeIndex] = multiplicandLow[halfSizeIndex] + multiplicandHigh[halfSizeIndex];

			multipliplierLow[halfSizeIndex] = multiplier[halfSizeIndex];
			multipliierHigh[halfSizeIndex] = multiplier[halfSizeIndex + halfArraySize];
			multipliplierLowHigh[halfSizeIndex] = multipliplierLow[halfSizeIndex] + multipliierHigh[halfSizeIndex];

		}

		// Recursively call method on smaller arrays and construct the low and high
		// parts of the product
		double[] productLow = karatsubaMultiplyRecursive(multiplicandLow, multipliplierLow);
		double[] productHigh = karatsubaMultiplyRecursive(multiplicandHigh, multipliierHigh);

		double[] productLowHigh = karatsubaMultiplyRecursive(multiplicandLowHigh, multipliplierLowHigh);

		// Construct the middle portion of the product
		double[] productMiddle = new double[multiplicand.length];
		for (int halfSizeIndex = 0; halfSizeIndex < multiplicand.length; ++halfSizeIndex) {
			productMiddle[halfSizeIndex] = productLowHigh[halfSizeIndex] - productLow[halfSizeIndex]
					- productHigh[halfSizeIndex];
		}

		// Assemble the product from the low, middle and high parts. Start with the low
		// and high parts of the product.
		for (int halfSizeIndex = 0, middleOffset = multiplicand.length
				/ 2; halfSizeIndex < multiplicand.length; ++halfSizeIndex) {
			product[halfSizeIndex] += productLow[halfSizeIndex];
			product[halfSizeIndex + multiplicand.length] += productHigh[halfSizeIndex];
			product[halfSizeIndex + middleOffset] += productMiddle[halfSizeIndex];
		}

		return product;

	}

	public static void main(String[] args) {

		int[] A = { 4, 3, 2, 1 }; // degree 3 means n - 1 == 3 => n == 4
		int[] B = { 1, 2, 3, 4 };

		// int[] c = multPolyNaive(A, B, 3);
		// int[] c = multPolyDivideAndConquerNaive(A, B, 4, 0, 0);
		int[] c = Multiplication(A, B);
		// double[] c = karatsubaMultiplyRecursive(A, B);

		display(c);

	}

	public static void display(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
}