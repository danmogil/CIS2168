package inclass.aug29;

import java.util.Comparator;

public class MovieInfo implements Comparable<MovieInfo> {
	private String title;
	private String genre;
	private String leadActor;

	MovieInfo(String t, String g, String a) {
		title = t;
		genre = g;
		leadActor = a;
	}

	@Override
	public String toString() {
		return title + " " + genre + " " + leadActor + "\n";
	}

	// getters
	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public String getActor() {
		return leadActor;
	}

	@Override
	public int compareTo(MovieInfo other) {
		return title.compareTo(other.getTitle());
	}

	public static class GenreComparator implements Comparator<MovieInfo> {
		@Override
		public int compare(MovieInfo o1, MovieInfo o2) {
			return o1.getGenre().compareTo(o2.getGenre());
		}
	}

	public static class ActorComparator implements Comparator<MovieInfo> {
		@Override
		public int compare(MovieInfo o1, MovieInfo o2) {
			return o1.getActor().compareTo(o2.getActor());
		}
	}

}
