package lab2b;

import java.util.ArrayList;
import java.util.List;

public class Excersise3 {

	// O(N) where N represents the length of the shortest list
	public static List<Integer> intersect(List<Integer> sorted1, List<Integer> sorted2) {
		List<Integer> i = new ArrayList<>();
		int j = 0, k = 0;
		while (j < sorted1.size() && k < sorted2.size()) {
			if (sorted1.get(j) < sorted2.get(k)) j++;
			else if (sorted1.get(j) > sorted2.get(k)) k++;
			else {
				i.add(sorted1.get(j++));
				k++;
			}
		}
		return i;
	}

	// O(X*Y) where X and Y represent the lengths of ls1 and ls2
	public static List<Integer> intersectUnsorted(List<Integer> ls1, List<Integer> ls2) {
		List<Integer> i = new ArrayList<>();
		for (int x : ls1)
			if (ls2.contains(x)) i.add(x);
		return i;
	}

	public static List<String> reverse(List<String> ls) {
		List<String> r = new ArrayList<>();
		for (String x : ls)
			r.add(reverse(x));
		return r;
	}

	private static String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--)
			sb.append(s.charAt(i));
		return sb.toString();
	}
}
