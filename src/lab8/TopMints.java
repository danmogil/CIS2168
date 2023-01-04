package lab8;

import java.util.Arrays;

public class TopMints {
	public static void main(String[] args) {
		System.out.print("\nTest 1\n------\n");
		System.out.println(" Uncomment lines 9 through 37 in TopMints.java to run this test.");
		//		In in = new In("10ints.txt");
		// Uncomment the following line when you are ready to read the file with 1 million integers
		In in = new In(
				"https://gist.githubusercontent.com/david-dobor/b9008e5116f1816675fa15e2256b5168/raw/9baebd0943e90e0f98932ea4d53d1f508fa59dff/1Mints1.txt");

		int m = 5; // keep only top m integers
		int n = in.readInt(); // the first input integer is the number of input lines that follow
		Integer[] ints1 = new Integer[n];

		MinPQ<Integer> pq = new MinPQ<>(m);

		Stopwatch timer1 = new Stopwatch();
		for (int i = 0; i < n; i++) {
			ints1[i] = in.readInt();
			pq.add(ints1[i]);
			if (pq.size() > m) pq.extractMin();
		}
		double time1 = timer1.elapsedTime();

		// print what's in the priority queue
		System.out.printf("\t\t\tTop %d integers are\n", m);
		for (Integer integer : pq) {
			System.out.println(integer);
		}

		// print the time it took to process the entire stream
		System.out.printf("\nIt took %.2f seconds to process %,d integers " + "using a priority queue.\n", time1, n);

		in.close();

		// Start Test 2 (this test sorts n integers and prints the largest m of them)
		System.out.print("\nTest 2\n------\n");

		// Test the time it takes to find m largest using sorting
		in = new In(
				"https://gist.githubusercontent.com/david-dobor/b9008e5116f1816675fa15e2256b5168/raw/9baebd0943e90e0f98932ea4d53d1f508fa59dff/1Mints1.txt");
		int M = 5;
		int N = in.readInt(); // the first input integer is the number of input lines that follow
		Integer[] ints2 = new Integer[N];

		Stopwatch timer2 = new Stopwatch();
		for (int i = 0; i < N; i++) {
			ints2[i] = in.readInt();
		}
		Arrays.sort(ints2);

		double time2 = timer2.elapsedTime();

		// print the largest m integers of the sorted array
		System.out.printf("\t\t\tTop %d integers are\n", M);
		for (int i = N - M; i < N; i++) {
			System.out.println(ints2[i]);
		}

		// print the time it took to process the entire stream
		System.out.printf("\nIt took %.2f seconds to process %,d integers " + "by sorting them.\n", time2, N);

		in.close();
		System.out.println("-------------------------------------------------------------------");

	}
}