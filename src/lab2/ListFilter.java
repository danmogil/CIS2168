package lab2;

public class ListFilter {
	public static void main(String[] args) {

		String validURL = "https://gist.githubusercontent.com/david-dobor/8e72f21c733b677af60f35086e65924f/raw/2e6e4daa0b019b22de38b9e6572af29cf19b6139/valid1M.txt";
		String contenderURL = "https://gist.githubusercontent.com/david-dobor/ac1a8528a0b8a5a88e41777c56e51bc4/raw/f7a65a9682f186ce25d2e9e2f6aa95b664c90c72/contenders1M.txt";

		In in = new In(validURL);
		int[] valid = in.readAllInts();

		CollectionOfInts c = new CollectionOfInts(valid);

		in = new In(contenderURL);
		int[] contenders = in.readAllInts();

		for (int contender : contenders) {
			if (!c.contains(contender))
				System.out.println(contender);
		}

	}
}
