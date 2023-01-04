package lab2b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Zigzag {

	// Traversal with boundary handling
	public static List<Integer> solA(int[][] m) {
		int height = m.length - 1, width = m[0].length - 1;
		List<Integer> t = new ArrayList<>();

		int r = 0, c = 0;
		boolean goingDown = true;

		while (!outOfBounds(r, c, height, width)) {

			t.add(m[r][c]);

			if (goingDown) {
				if (c == 0 || r == height) {
					goingDown = false;
					if (r == height) c++;
					else r++;
				} else {
					r++;
					c--;
				}
			}

			else {
				if (r == 0 || c == width) {
					goingDown = true;
					if (c == width) r++;
					else c++;
				} else {
					r--;
					c++;
				}
			}
		}
		return t;
	}

	// Traverse each diagonal, reverse every other
	public static List<Integer> solB(int[][] m) {
		int rows = m.length, cols = m[0].length;
		List<Integer> t = new ArrayList<>(rows * cols);

		boolean rev = true;

		int r = 0, c = 0;
		while (c < cols) {
			List<Integer> d = new ArrayList<>();
			for (int i = r, j = c; i >= 0 && j < cols; i--, j++)
				d.add(m[i][j]);

			if (rev) Collections.reverse(d);
			t.addAll(d);

			rev = !rev;
			if (r < rows - 1) r++;
			else c++;
		}

		return t;
	}

	private static boolean outOfBounds(int r, int c, int height, int width) {
		return r < 0 || r > height || c < 0 || c > width;
	}
}