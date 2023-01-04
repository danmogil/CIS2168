package lab1d;

public class Squash {
	// O(2N) -> O(N)
	static int[] squash(int[] arr) {
		int[] squashed = new int[arr.length];
		if (arr.length == 0)
			return squashed;

		int j = 1;

		for (int i = j; i < arr.length; i++) {
			if (arr[i] != arr[i - 1])
				squashed[j++] = arr[i];
		}

		while (j < arr.length)
			squashed[j++] = -1;

		return squashed;
	}
}
