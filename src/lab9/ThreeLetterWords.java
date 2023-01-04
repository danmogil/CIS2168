package lab9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/*
 * ANSWERS
 * 
 * How many buckets are needed to map all three-letter words according to this scheme?
 * 26*3-2 = 76
 * 
 * How many buckets are needed to map all four-letter words according to this scheme?
 * 26*4-3 = 101
 * 
 */

public class ThreeLetterWords {
	private ArrayList<String> words = new ArrayList<>(); // all three-letter words
	private Map<Character, Integer> cMap = new HashMap<>(); // letter-number map
	public Map<String, Integer> wordMap = new TreeMap<>(); // word-number map
	// Constructor: builds the word - number dictionary. Each word is
	// associated with the sum of its letter values

	public ThreeLetterWords() {
		makeWords(); // Already implemented
		buildLetterMap(); // Implement this method below
		buildWordMap(); // Implement this method below
	}

	// Builds an ArrayList of all three-letter words
	private void makeWords() {
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVXYZ".toCharArray();
		StringBuilder sb = new StringBuilder("");
		for (char a : chars) {
			for (char b : chars) {
				for (char c : chars) {
					sb.append(a).append(b).append(c);
					words.add(sb.toString());
					sb.setLength(0);
				}
			}
		}
	}

	// Builds the letter-number map (A=1, B=2, ..., Z=26)
	private void buildLetterMap() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < alphabet.length(); i++) {
			cMap.put(alphabet.charAt(i), i + 1);
		}
	}

	// Builds the word-number (number = sum of letter values) map
	public void buildWordMap() {
		for (String s : words) {
			int sum = 0;
			for (char c : s.toCharArray())
				sum += cMap.get(c);
			wordMap.put(s, sum);
		}
	}

	// test the ThreeLetterWords data type (add your tests as needed)
	public static void main(String[] args) {
		ThreeLetterWords tlw = new ThreeLetterWords();
		Map<String, Integer> map = tlw.wordMap; //System.out.println(map);
		Map<String, Integer> result = new TreeMap<>();
		for (Entry<String, Integer> entry : map.entrySet())
			if (entry.getValue().equals(39)) result.put(entry.getKey(), entry.getValue());
		for (Entry<String, Integer> entry : result.entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue());
	}
}