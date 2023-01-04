package lab1b;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TestLottery {

	@RepeatedTest(100)
	@DisplayName("assert no duplicate drawings")
	void testDuplicates() {
		Lottery lt = new Lottery(49, 6);
		var set = new HashSet<Integer>();
		for (int x : lt.draw())
			set.add(x);
		assertEquals(lt.getNumDraws(), set.size());
	}

	@Test
	@DisplayName("test negative poolSize")
	void testNegativePoolSize() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Lottery(-1, 6);
		});
	}

	@Test
	@DisplayName("test negative numDraws")
	void testNegativeNumDraws() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Lottery(49, -1);
		});
	}

	@Test
	@DisplayName("test numDraws > poolSize")
	void testNumDrawsLarger() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Lottery(6, 49);
		});
	}

}
