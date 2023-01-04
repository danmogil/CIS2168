package readingProblems.linkedLists;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import readingProblems.linkedLists.Solutions.LinkedList;

class SolutionsTest {

	LinkedList ls;
	int[] input = { 1, 1, 3, 4, 4, 4, 5, 6, 6 };

	@BeforeEach
	void init() { ls = new LinkedList(input); }

	@Test
	void testDeDup() { assertArrayEquals(new Integer[] { 1, 3, 4, 5, 6 }, Solutions.deDup(ls).toArray()); }

	@Test
	void testRmLast() { assertArrayEquals(new Integer[] { 1, 1, 3, 4, 4, 4, 5, 6 }, Solutions.rmLast(ls).toArray()); }

	@Test
	void testDelete() {
		assertArrayEquals(new Integer[] { 1, 1, 3, 4, 4, 5, 6, 6 }, Solutions.delete(ls, 3).toArray());
		assertArrayEquals(new Integer[] { 1, 3, 4, 4, 5, 6, 6 }, Solutions.delete(ls, 0).toArray());
		assertThrows(IllegalArgumentException.class, () -> { Solutions.delete(ls, -1); });
		assertThrows(IllegalArgumentException.class, () -> { Solutions.delete(ls, 20); });
	}

	@Test
	void testFind() {
		assertEquals(true, Solutions.find(ls, 5));
		assertEquals(false, Solutions.find(ls, 7));
	}

}
