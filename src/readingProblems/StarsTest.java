package readingProblems;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class StarsTest {

	private final String[] noStars = { "the", "quick", "brown", "fox" };
	private final String[] stars = { "the", "*", "quick", "*", "brown", "*", "fox", "*" };

	@Test
	void testAddStars() {
		var input = new ArrayList<>(List.of(noStars));
		assertArrayEquals(stars, Stars.addStars(input).toArray());
	}

	@Test
	void testRemoveStars() {
		var input = new ArrayList<>(List.of(stars));
		assertArrayEquals(noStars, Stars.removeStars(input).toArray());
	}

}