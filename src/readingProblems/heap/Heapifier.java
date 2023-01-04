package readingProblems.heap;

import java.util.Arrays;

public class Heapifier {

	public static int[] heapify(int[] a) {
		int j = a.length;
		for (int i = j / 2; i >= 1; i--)
			sink(a, i, j);
		return a;
	}

	private static void sink(int[] a, int i, int j) {
		int k = 2 * i;
		while (k <= j) {
			if (k < j && less(a, k, k + 1)) k++;
			if (!less(a, i, k)) break;
			exch(a, i, k);
			i = k;
		}
	}

	private static boolean less(int[] a, int i, int j) { return a[i - 1] < a[j - 1]; }

	private static void exch(int[] a, int i, int j) {
		int temp = a[i - 1];
		a[i - 1] = a[j - 1];
		a[j - 1] = temp;
	}

	public static void main(String[] args) {
		int[] in = { 2, 1, 6, 8, 9, 3 };
		System.out.print(Arrays.toString(heapify(in)));
	}

}
