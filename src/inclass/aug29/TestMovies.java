package inclass.aug29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMovies {
	List<MovieInfo> movieList = new ArrayList<>();

	public static void main(String[] args) {
		new TestMovies().go();
	}

	public void go() {
		populateList();
		System.out.println("Movies, Unsorted:");
		System.out.println(movieList); // output as read from file

		Collections.sort(movieList);
		System.out.println("\nMovies, Sorted by Title:");
		System.out.println(movieList); // output as sorted by title

		Collections.sort(movieList, new MovieInfo.GenreComparator());
		System.out.println("\nMovies, Sorted by Genre:");
		System.out.println(movieList); // output as sorted by genre

		Collections.sort(movieList, new MovieInfo.ActorComparator());
		System.out.println("\nMovies, Sorted by Actor:");
		System.out.println(movieList); // output as sorted by actor
	}

	public void populateList() {
		// read the file, create MovieInfo instances, and
		// populate the ArrayList movieList with these instances
		In in = new In("movieInfo.txt");
		while (in.hasNextLine()) {
			String[] tk = in.readLine().split("/");
			movieList.add(new MovieInfo(tk[0], tk[1], tk[2]));
		}
	}

}
