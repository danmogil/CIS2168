package readingProblems;

import java.util.ArrayList;

class Stars {

	static ArrayList<String> addStars(ArrayList<String> input) {
		for (int i = 1; i <= input.size(); i += 2)
			input.add(i, "*");
		return input;
	}

	static ArrayList<String> removeStars(ArrayList<String> input) {
		for (int i = 1; i <= input.size(); i++)
			input.remove(i);
		return input;
	}
}