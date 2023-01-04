package lab1b;

import java.util.Arrays;
import java.util.Random;

public class Lottery {

	private int poolSize;
	private int numDraws;
	private final int[] numbers;
	private final int[] drawings;

	private final Random r = new Random();

	public Lottery(int poolSize, int numDraws) {
		if (poolSize < 1 || numDraws < 1)
			throw new IllegalArgumentException("poolSize and numDraws must be positive");
		if (numDraws > poolSize)
			throw new IllegalArgumentException("numDraws cannot exceed poolSize");

		this.poolSize = poolSize;
		this.numDraws = numDraws;
		drawings = new int[numDraws];
		numbers = new int[poolSize];
		Arrays.setAll(numbers, i -> i + 1);
	}

	public int[] draw() {
		for (int i = 0; i < numDraws; i++) {
			int iDraw = r.nextInt(poolSize--);
			drawings[i] = numbers[iDraw];
			numbers[iDraw] = numbers[poolSize];
		}
		return drawings;
	}

	public int getPoolSize() {
		return poolSize;
	}

	public int getNumDraws() {
		return numDraws;
	}

	public static void main(String[] args) {
		Lottery lt = new Lottery(49, 6);
		System.out.println(Arrays.toString(lt.draw()));
	}
}
