package lab2b;

import java.util.HashSet;
import java.util.Set;

public class Excersise2 {
	public static int[] twoSum(int[] arr, int target) {
		Set<Integer> ls = new HashSet<>();

		for (int x : arr) {
			if (ls.contains(target - x)) return new int[] { x, target - x };
			ls.add(x);
		}

		return new int[2];
	}

}
