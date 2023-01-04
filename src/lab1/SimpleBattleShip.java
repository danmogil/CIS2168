package lab1;

public class SimpleBattleShip {
	static final int SHIP_SIZE = 3;
	private int[] shipCoords;
	private int numOfHits;

	public String updateStatus(int guess) {
		for (int x : shipCoords) {
			if (guess == x) {
				if (++numOfHits == SHIP_SIZE)
					return "Kill";
				return "Hit";
			}
		}
		return "Miss";
	}

	public void setPosition(int[] coords) {
		shipCoords = coords;
	}
}
