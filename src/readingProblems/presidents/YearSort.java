package readingProblems.presidents;

import java.util.Comparator;

public class YearSort implements Comparator<President> {
	@Override
	public int compare(President o1, President o2) {
		return Integer.compare(o1.year, o2.year);
	}
}
