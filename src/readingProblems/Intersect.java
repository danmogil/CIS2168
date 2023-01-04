package readingProblems;

import java.util.ArrayList;

/*
 * Write a method called intersect that accepts two sorted ArrayLists of Integers
 * and returns a new list that contains only the elements that are found in both lists.
 */

public class Intersect {

	// O(N^2) solution
	static ArrayList<Integer> sol1(ArrayList<Integer> ls1, ArrayList<Integer> ls2) {
		ArrayList<Integer> out = new ArrayList<Integer>();
		for (Integer x : ls1) {
			if (ls2.contains(x))
				out.add(x);
		}
		return out;
	}

	// O(NlogN)
	static ArrayList<Integer> sol2(ArrayList<Integer> ls1, ArrayList<Integer> ls2) {
		ArrayList<Integer> out = new ArrayList<Integer>();
		for (Integer x : ls1) {
			if (binarySearch(ls2, x))
				out.add(x);
		}
		return out;
	}

	private static boolean binarySearch(ArrayList<Integer> ls, int target) {
		int lo = 0, hi = ls.size() - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (ls.get(mid) == target)
				return true;
			else if (ls.get(mid) > target)
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		return false;
	}
}
