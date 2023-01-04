package readingProblems.presidents;

public class President {
	String name;
	int year;

	public President(String firstName, int yearElected) {
		name = firstName;
		year = yearElected;
	}

	@Override
	public String toString() {
		return name;
	}

}