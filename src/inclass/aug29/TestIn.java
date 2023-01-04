package inclass.aug29;

public class TestIn {
	public static void main(String[] args) {
		In in = new In("movieInfo.txt");
		String line;
		while (in.hasNextLine()) {
			line = in.readLine();
			System.out.println(line);
		}
	}
}
