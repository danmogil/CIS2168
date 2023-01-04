package lab2b;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class Excersise3Test {

	@Test
	void testIntersect() {
		assertEquals(List.of(4, 11, 17, 28, 59), Excersise3.intersect(List.of(1, 4, 8, 9, 11, 15, 17, 28, 41, 59),
				List.of(4, 7, 11, 17, 19, 20, 23, 28, 37, 59, 81)));
	}

	@Test
	void testReverse() {
		assertEquals(List.of("level", "olleh", "gnitset"), Excersise3.reverse(List.of("level", "hello", "testing")));
	}

}
