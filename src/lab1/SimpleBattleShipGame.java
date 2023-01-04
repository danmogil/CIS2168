package lab1;

import java.util.Random;

public class SimpleBattleShipGame {

	final static int GRID_SIZE = 6;

	public static void main(String[] args) {
		SimpleBattleShip ship = new SimpleBattleShip();
		int numGuesses = 0;

		int startCoord = new Random().nextInt(GRID_SIZE - SimpleBattleShip.SHIP_SIZE);
		ship.setPosition(new int[] { startCoord, startCoord + 1, startCoord + 2 });

		boolean isAlive = true;
		String prompt = String.format("Enter a number between 0-%d", GRID_SIZE - 1);

		while (isAlive) {
			String status = ship.updateStatus(GameHelper.getInput(prompt));
			numGuesses++;

			System.out.println(status);
			if (status.equals("Kill")) {
				isAlive = false;
				System.out.println(String.format("You took %d guesses", numGuesses));
			}
		}

	}
}

/*
 * Fixing duplicate hit logic:
 * 	Use a boolean array to represent the ship's coords/state.
 * 	Hit iff' shipCoords[userInput] is true. On hit, change to false.
 */