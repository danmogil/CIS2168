package lab2b;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ZigzagTest {

	private int[][] a = { { 1, 3, 4, 7 }, { 2, 5, 6, 8 } };
	private int[][] b = { { 1, 3, 4, 10 }, { 2, 5, 9, 11 }, { 6, 8, 12, 15 }, { 7, 13, 14, 16 } };
	private int[][] c = { { 1 } };
	private int[][] d = { { 1, 2, 3, 4, 5, 6, 7 } };
	private int[][] e = { { 1 }, { 2 }, { 3 }, { 4 } };
	private int[][] f = { { 1, 3 }, { 2, 4 }, { 5, 7 }, { 6, 8 }, { 9, 10 } };
	private int[][] g = { { 1, 21, -3, 4, 15, 6, -7, 88, 9 }, { 10, 11, 112, 12, 20, -1, -2, -3, -4 },
			{ 6, 8, 113, 19, 21, 0, 0, 0, 0 }, { 7, 2, 18, 22, -27, 12, 32, -11, 66 },
			{ 15, 17, 23, 226, 28, -28, -226, -23, -17 }, { 16, 24, 27, 299, 30, 29, 32, 31, 88 } };

	@Test
	void testA() {
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }, Zigzag.solA(a).toArray());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }, Zigzag.solB(a).toArray());
	}

	@Test
	void testB() {
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 },
				Zigzag.solA(b).toArray());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 },
				Zigzag.solB(b).toArray());
	}

	@Test
	void testC() {
		Assert.assertArrayEquals(new Integer[] { 1 }, Zigzag.solA(c).toArray());
		Assert.assertArrayEquals(new Integer[] { 1 }, Zigzag.solB(c).toArray());
	}

	@Test
	void testD() {
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }, Zigzag.solA(d).toArray());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }, Zigzag.solB(d).toArray());
	}

	@Test
	void testE() {
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, Zigzag.solA(e).toArray());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, Zigzag.solB(e).toArray());
	}

	@Test
	void testF() {
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, Zigzag.solA(f).toArray());
		Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, Zigzag.solB(f).toArray());
	}

	@Test
	void testG() {
		Assert.assertArrayEquals(new Integer[] { 1, 10, 21, -3, 11, 6, 7, 8, 112, 4, 15, 12, 113, 2, 15, 16, 17, 18, 19, 20,
				6, -7, -1, 21, 22, 23, 24, 27, 226, -27, 0, -2, 88, 9, -3, 0, 12, 28, 299, 30, -28, 32, 0, -4, 0, -11, -226, 29,
				32, -23, 66, -17, 31, 88 }, Zigzag.solA(g).toArray());
		Assert.assertArrayEquals(new Integer[] { 1, 10, 21, -3, 11, 6, 7, 8, 112, 4, 15, 12, 113, 2, 15, 16, 17, 18, 19, 20,
				6, -7, -1, 21, 22, 23, 24, 27, 226, -27, 0, -2, 88, 9, -3, 0, 12, 28, 299, 30, -28, 32, 0, -4, 0, -11, -226, 29,
				32, -23, 66, -17, 31, 88 }, Zigzag.solB(g).toArray());
	}

	@Test
	void testEmpty() {
		Assert.assertArrayEquals(new Integer[] {}, Zigzag.solA(new int[][] { {} }).toArray());
		Assert.assertArrayEquals(new Integer[] {}, Zigzag.solA(new int[][] { {} }).toArray());
	}

}
