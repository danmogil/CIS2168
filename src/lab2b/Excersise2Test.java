package lab2b;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class Excersise2Test {

	@Test
	void testA() {
		assertArrayEquals(new int[] { 7, 2 }, Excersise2.twoSum(new int[] { 2, 11, 7, 50 }, 9));
	}

	@Test
	void testB() {
		assertArrayEquals(new int[] { 8, 2 }, Excersise2.twoSum(new int[] { 2, 1, 6, 8 }, 10));
	}

	@Test
	void testC() {
		assertArrayEquals(new int[] { -210, 47 },
				Excersise2.twoSum(new int[] { 21, -301, -12, -4, -65, 47, -56, -210, -356, 9, 0, -3, 1024 }, -163));
	}

	@Test
	void testNoSol() {
		assertArrayEquals(new int[] { 0, 0 }, Excersise2.twoSum(new int[] { 3, 4, 5 }, 12));
	}

	@Test
	void testEmpty() {
		assertArrayEquals(new int[] { 0, 0 }, Excersise2.twoSum(new int[] {}, 0));
	}

}
