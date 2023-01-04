package lab4;

import java.util.Iterator;

public class BabyListEfficiencyTest {
	public static void main(String[] args) {
		// create some list for testing
		int n = 50000; // number of elements in the list // CHANGE THIS NUMBER TO
										// RUN OTHER TESTS
		BabyList<Integer> list = new BabyList<>();
		for (int i = 0; i < n; i++)
			list.add(i % 4);
		// System.out.println(list); // list is 0 1 2 3 0 1 2 3 0 1 2 3 ...

		int numOfTests = 3; // number of tests whose average time to report (higher
												// sample size -> more accurate results)

		// 1-st batch of tests: SLList without an Iterator
//		testGetNoIterator(list, numOfTests);

		// 2-nd batch of tests: SLList without an Iterator
		testIteratorNext(list, numOfTests);

	}

	public static void testGetNoIterator(BabyList list, int numOfTests) {
		double average;
		long start = System.currentTimeMillis();
		int element; // the current list element
		String[] anim = { " |", " /", " -", " \\" }; // to do something in constant
																									// time (rotating bar)
		for (int test = 0; test < numOfTests; test++)
			// for each test, run get() for every list element
			for (int i = 0; i < list.size(); i++) {
				element = (Integer) list.get(i);
				System.out.print("\rRunning... " + anim[element] + "  " + element
						+ " (each operation takes no more than some constant time)");
			}
		long end = System.currentTimeMillis();
		average = ((double) (end - start)) / numOfTests;
		System.out.println("\rThis test took: " + average + " milliseconds on average. (Used SLList's get())\n");
	}

	public static void testIteratorNext(BabyList list, int numOfTests) {
		double average;
		long start = System.currentTimeMillis();
		int element; // the current list element
		String[] anim = { " |", " /", " -", " \\" }; // to do something in constant
																									// time (rotating bar)
		for (int test = 0; test < numOfTests; test++) {
			// for each test, run next() for every list element
			Iterator itr = list.iterator();
			while (itr.hasNext()) {
				element = (Integer) itr.next();
//				System.out.print("\rRunning... " + anim[element] + "  " + element
//						+ " (each operation takes no more than some constant time)");
			}
		}
		long end = System.currentTimeMillis();
		average = ((double) (end - start)) / numOfTests;
		System.out.print("\rThis test took: " + average + " milliseconds on average. (Used Iterator next())");
	}
}
