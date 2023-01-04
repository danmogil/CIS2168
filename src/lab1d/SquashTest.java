package lab1d;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SquashTest {

	@Test
	void testInput() {
		int[] input = { 0, 0, 0, 0, 1, 1, 0, 0, 0, 7, 7, 7, 1, 1, 0 };
		int[] result = { 0, 1, 0, 7, 1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		assertArrayEquals(result, Squash.squash(input));
	}

	@Test
	void testEmpty() {
		int[] input = {};
		int[] result = {};
		assertArrayEquals(result, Squash.squash(input));
	}

}
