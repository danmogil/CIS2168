package lab1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestSimpleBattleShip {

	private SimpleBattleShip ship;
	private final int[] coors = { 3, 4, 5 };

	@BeforeEach
	void init() {
		ship = new SimpleBattleShip();
		ship.setPosition(coors);
	}

	@Test
	@DisplayName("when miss")
	void testMiss() {
		String status = ship.updateStatus(1);
		assertEquals("Miss", status);
	}

	@Test
	@DisplayName("when hit")
	void testHit() {
		String status = ship.updateStatus(3);
		assertEquals("Hit", status);
	}

	@Test
	@DisplayName("when killed")
	void testKill() {
		ship.updateStatus(3);
		ship.updateStatus(4);
		String status = ship.updateStatus(5);
		assertEquals("Kill", status);
	}

}
