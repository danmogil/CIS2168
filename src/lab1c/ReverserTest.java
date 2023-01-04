package lab1c;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

class ReverserTest {
	@Test
	void testInput1() {
		assertArrayEquals(new int[] { 8, 6, 1, 2 }, Reverser.reverse(new int[] { 2, 1, 6, 8 }));
	}

	@Test
	void testInput2() {
		assertArrayEquals(new int[] { 2, 1, 5 }, Reverser.reverse(new int[] { 5, 1, 2 }));
	}

	@Test
	void testEmpty() {
		assertArrayEquals(new int[] {}, Reverser.reverse(new int[] {}));
	}

}
