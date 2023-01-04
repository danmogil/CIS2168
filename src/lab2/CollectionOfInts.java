package lab2;

import java.util.Arrays;

public class CollectionOfInts {
	private int[] arr;

	public CollectionOfInts(int[] arr) {
		this.arr = Arrays.copyOf(arr, arr.length);
		Arrays.sort(this.arr);
	}

	public boolean contains(int key) {
		return indexOf(key) != -1;
	}

	private int indexOf(int key) {
		int lo = 0, hi = arr.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] > key)
				hi = mid - 1;
			else if (arr[mid] < key)
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}
}

/*
	I learned how to read data from a website. Otherwise, thes lab was trivial.
*/