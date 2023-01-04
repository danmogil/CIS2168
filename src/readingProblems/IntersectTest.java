package readingProblems;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class IntersectTest {

	ArrayList<Integer> ls1 = new ArrayList<>(List.of(1, 4, 8, 9, 11, 15, 17, 28, 41, 59));
	ArrayList<Integer> ls2 = new ArrayList<>(List.of(4, 7, 11, 17, 19, 20, 23, 28, 37, 59, 81));
	Integer[] expected = { 4, 11, 17, 28, 59 };

	@Test
	void testSol1() {
		assertArrayEquals(expected, Intersect.sol1(ls1, ls2).toArray());
	}

	@Test
	void testSol2() {
		assertArrayEquals(expected, Intersect.sol2(ls1, ls2).toArray());
	}

}
