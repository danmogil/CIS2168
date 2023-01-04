package readingProblems.presidents;

import java.util.Comparator;

public class NameSort implements Comparator<President> {
	@Override
	public int compare(President o1, President o2) {
		return o1.name.compareTo(o2.name);
	}
}
