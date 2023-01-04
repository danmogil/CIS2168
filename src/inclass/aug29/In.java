package inclass.aug29;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

// In is a helper class written for CIS-2168 Labs. Its purpose is to help read
// a text file. In this version, the file is stored locally (the followup version
// will also read data from URL connections)
// The main() method shows an example of using the In class.
// You do not need to modify this file.
public final class In {
	private Scanner scanner;

	// Initializes an input stream from standard input.
	public In() {
		scanner = new Scanner(new BufferedInputStream(System.in));
	}

	// Constructor. Initializes an input stream from a local filename.
	public In(String name) {
		if (name == null)
			throw new IllegalArgumentException("please tell me which file to open. exiting for now...");
		try {
			File file = new File(name);
			if (file.exists()) {
				scanner = new Scanner(new BufferedInputStream(new FileInputStream(file)));
			}
		} catch (IOException ioe) {
			throw new IllegalArgumentException("Could not open " + name, ioe);
		}
	}

	// main() tests the In data type
	public static void main(String[] args) {
		In in = new In("movieinfo.txt");
		while (in.isEmpty()) {
			String text = in.readLine();
			System.out.println(text);
		}
	}

	// Reads all lines from this input stream and returns them as
	// an array of strings.
	public String[] readAllLines() {
		List<String> ls = new ArrayList<>();
		while (true) {
			String line = readLine();
			if (line == null)
				return ls.toArray(new String[0]);
			ls.add(line);
		}
	}

	// Closes this input stream.
	public void close() {
		scanner.close();
	}

	// Returns true if input stream is empty
	public boolean isEmpty() {
		return scanner.hasNext();
	}

	// Returns true if this input stream has a next line.
	public boolean hasNextLine() {
		return scanner.hasNextLine();
	}

	// Reads and returns the next line in this input stream
	public String readLine() {
		String line;
		try {
			line = scanner.nextLine();
		} catch (NoSuchElementException e) {
			line = null;
		}
		return line;
	}
}