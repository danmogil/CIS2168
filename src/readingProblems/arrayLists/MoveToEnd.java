package readingProblems.arrayLists;

import java.util.ArrayList;
import java.util.List;

public class MoveToEnd {

	// theta(n)
	public static List<Integer> solution(List<Integer> ls, int b) {
		if (ls.size() == 0) return ls;
		ls = new ArrayList<>(ls);

		int r = 0, l = ls.size() - 1;

		while (ls.get(l) == b)
			l--;

		while (r < l) {
			if (ls.get(r) == b) {
				int temp = ls.get(l);
				ls.set(l--, ls.get(r));
				ls.set(r, temp);
			}
			r++;
		}
		return ls;
	}

	public static void main(String[] args) {
		System.out.println(MoveToEnd.solution(List.of(new Integer[] { 2, 1, 2, 2, 2, 6, 8, 2 }), 2)); // [1, 6, 8, 2, 2, 2, 2, 2]
		System.out.println(MoveToEnd.solution(List.of(new Integer[] { 1, 2, 3, 4 }), 3)); // [1, 2, 4, 3]
		System.out.println(MoveToEnd.solution(new ArrayList<Integer>(), 77)); // []
		System.out.println(MoveToEnd.solution(List.of(new Integer[] { 1, 1, 1, 1, 1 }), 77)); // [1, 1, 1, 1, 1]
	}
}
