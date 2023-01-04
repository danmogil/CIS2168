package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// direction = EAST || WEST
// returned indexes sorted in ASC

public class SunsetViews {

	public static List<Integer> solutionA(int[] buildings, String direction) {
		MyStack<Integer> s = new MyStack<>();
		boolean isWest = direction.compareTo("WEST") == 0;

		int startAt = 0;
		int step = 1;

		if (isWest) {
			startAt = buildings.length - 1;
			step = -1;
		}

		int i = startAt;
		while (i >= 0 && i < buildings.length) {
			int h = buildings[i];
			while (s.size() > 0 && buildings[s.peek()] <= h)
				s.pop();
			s.push(i);
			i += step;
		}

		List<Integer> ls = new ArrayList<>();
		for (Integer x : s)
			ls.add(x);

		if (!isWest) Collections.reverse(ls);
		return ls;
	}

	public static List<Integer> solutionB(int[] buildings, String direction) {
		List<Integer> ls = new LinkedList<>();
		boolean isEast = direction.compareTo("EAST") == 0;

		int max = 0;
		int startAt = 0;
		int step = 1;

		if (isEast) {
			startAt = buildings.length - 1;
			step = -1;
		}

		int i = startAt;
		while (i >= 0 && i < buildings.length) {
			if (buildings[i] > max) {
				ls.add(i);
				max = buildings[i];
			}
			i += step;
		}

		if (isEast) Collections.reverse(ls);

		return ls;
	}

	public static void main(String[] args) {
		System.out.println(solutionA(new int[] { 3, 5, 4, 4, 3, 1, 3, 2 }, "EAST")); // [1, 3, 6, 7]
		System.out.println(solutionA(new int[] { 3, 5, 4, 4, 3, 1, 3, 2 }, "WEST")); // [0, 1]
		System.out.println(solutionB(new int[] { 3, 5, 4, 4, 3, 1, 3, 2 }, "EAST")); // [1, 3, 6, 7]
		System.out.println(solutionB(new int[] { 3, 5, 4, 4, 3, 1, 3, 2 }, "WEST")); // [0, 1]
	}

}
