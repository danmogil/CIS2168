package lab9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hand {
	/*************************** Public static field ***************************/
	// the name of this hand
	public static Map<Integer, String> nameMap = Map.of(8, "straight flush", 7, "four of a kind", 6, "full house", 5,
			"flush", 4, "straight", 3, "three of a kind", 2, "two pair", 1, "pair", 0, "nothing");

	/****************************** Private fields ******************************/
	// A list of cards in this hand. E.g., [8C, TS, KC, 9H, 4S] is a list of cards.
	private ArrayList<Card> hand = new ArrayList<>();

	// A map of each card's rank to the number of times it occurs in the hand. E.g,
	// "7D 7S 5D 7C 5H" has two 5s and three 7s, so its frequency map is {5=2, 7=3}.
	public Map<Integer, Integer> rankFrequency = new HashMap<>();

	// Ranks of the cards in this hand in reverse-sorted order. E.g., the hand
	// "8H KC 2S 3S QD" has ranks [13, 12, 8, 3, 2].
	private Integer[] cardRanks = new Integer[5];

	// The integer value of this poker hand in the range from 0 to 8. 8 corresponds
	// to a straight flush and 0 to a nothing hand.
	// (See the instructions or the Wikipedia article for poker hand rankings.)
	private int handValue;

	/********************************
	 * Constructor
	 ********************************/
	// Creates a Hand object from an input string representing a hand.
	public Hand(String cards) {
		// hand.removeAll(hand); // clear this hand to create a new one
		for (String token : cards.split("\\s+")) {
			Card card = new Card(token);
			hand.add(card);
		}
		check(); // make sure this is a valid 5-card hand
		buildRankArray(); // generate a card-rank array in reverse-sorted order
		buildRankFrequencyMap(); // generate a map of card-rank frequencies
		determineHandRank(); // the rank of this hand on the scale 0 to 8
	}

	/*******************************
	 * Private Methods
	 *******************************/
	// How many times does each rank repeat in this hand? Maps each rank to the number
	// of times it occurs in this hand and returns the map. E.g., "KD KS 9H JC 9S" has
	// two Ks, two 9s, and one J, so its map is {13=2, 11=1, 9=2}.
	private void buildRankFrequencyMap() {
		for (int x : cardRanks) {
			if (rankFrequency.containsKey(x)) rankFrequency.replace(x, rankFrequency.get(x) + 1);
			else rankFrequency.put(x, 1);
		}
	}

	// generate a list of ranks in decreasing order (the highest rank first, the lowest last).
	private void buildRankArray() {
		int i = 0;
		for (Card c : hand) {
			cardRanks[i] = c.getRank();
			i++;
		}
		Arrays.sort(cardRanks, Collections.reverseOrder());

		// the only exception is a low straight (called a wheel) where Ace
		// counts as 1, not as 14. So if the hand is "Ace, 5, 4, 3, 2"
		// we want to return "5, 4, 3, 2, 1" instead of "14, 5, 4, 3, 2"
		if (Arrays.equals(cardRanks, new Integer[] { 14, 5, 4, 3, 2 })) cardRanks = new Integer[] { 5, 4, 3, 2, 1 };
	}

	// determine the ranking of this hand
	private void determineHandRank() {
		if (this.isStraightFlush()) handValue = 8;
		else if (this.isFourOfaKind()) handValue = 7;
		else if (this.isFullHouse()) handValue = 6;
		else if (this.isFlush()) handValue = 5;
		else if (this.isStraight()) handValue = 4;
		else if (this.isThreeOfaKind()) handValue = 3;
		else if (this.isTwoPair()) handValue = 2;
		else if (this.isPair()) handValue = 1;
		else handValue = 0;
	}

	// Check if the hand has 5 cards and if each card is in the correct format.
	private void check() {
		if (hand.size() != 5) throw new RuntimeException("Not a 5-card hand. Try again.");
		Set<String> cardSet = new HashSet<>();
		for (Card c : hand)
			cardSet.add(c.toString()); // (card validity itself is checked in Card.java)
		if (cardSet.size() != 5) throw new RuntimeException("Duplicate card! Try again.");
	}

	/***********************************
	 * Getters
	 ***********************************/
	// returns and Integer array of the card ranks in this hand in descending order
	public Integer[] getCardRanks() { return cardRanks; }

	// returns the frequency map for this hand
	public Map<Integer, Integer> getRankFrequency() { return rankFrequency; }

	// returns the list of Cards in this hand
	public ArrayList<Card> getHand() { return hand; }

	// return the rank of this hand
	public int getHandValue() { return handValue; }

	/*********************************************************************************
	 * Methods that check for the hand categories
	 ********************************************************************************/

	// Compare hands accounting for ties
	public int compareHands(Hand h2) {
		if (getHandValue() > h2.getHandValue()) return 1;
		else if (getHandValue() < h2.getHandValue()) return -1;
		else { // same rank
			if (isStraightFlush() || isStraight()) {
				if (cardRanks[0] > h2.cardRanks[0]) return 1;
				else if (cardRanks[0] < h2.cardRanks[0]) return -1;
			} else if (isNothing() || isFlush()) {
				for (int i = 0; i < cardRanks.length; i++) {
					if (cardRanks[i] == h2.cardRanks[i]) continue;
					else return cardRanks[i] > h2.cardRanks[i] ? 1 : -1;
				}
			} else {

				Set<Integer> r1 = new HashSet<>(Arrays.asList(cardRanks));
				Set<Integer> r2 = new HashSet<>(Arrays.asList(h2.cardRanks));

				if (isThreeOfaKind() || isFourOfaKind() || isFullHouse()) {
					if (cardRanks[2] > h2.cardRanks[2]) return 1;
					else if (cardRanks[2] < h2.cardRanks[2]) return -1;
					else {

						r1.remove(cardRanks[2]);
						r2.remove(cardRanks[2]);

						if (Collections.max(r1) > Collections.max(r2)) return 1;
						else if (Collections.max(r1) < Collections.max(r2)) return -1;
						else if (isThreeOfaKind()) {
							if (Collections.min(r1) > Collections.min(r2)) return 1;
							else if (Collections.min(r1) < Collections.min(r2)) return -1;
						}
					}
				} else if (isTwoPair()) {
					if (cardRanks[1] > h2.cardRanks[1]) return 1;
					else if (cardRanks[1] < h2.cardRanks[1]) return -1;
					else {
						if (cardRanks[3] > h2.cardRanks[3]) return 1;
						else if (cardRanks[3] < h2.cardRanks[3]) return -1;
						else {

							r1.remove(cardRanks[1]);
							r1.remove(cardRanks[3]);
							r2.remove(cardRanks[1]);
							r2.remove(cardRanks[3]);

							if (Collections.max(r1) > Collections.max(r2)) return 1;
							else if (Collections.max(r1) < Collections.max(r2));
						}
					}
				} else {

					Set<Integer> s1 = new HashSet<>();
					Set<Integer> s2 = new HashSet<>();

					for (int x : cardRanks) {
						if (!s1.contains(x)) {
							s1.add(x);
							r1.remove(x);
						}
					}

					for (int x : h2.cardRanks) {
						if (!s2.contains(x)) {
							s2.add(x);
							r2.remove(x);
						}
					}

					while (r1.size() > 0) {
						System.out.println(r1);
						System.out.println(r2);
						if (Collections.max(r1) > Collections.max(r2)) return 1;
						else if (Collections.max(r1) < Collections.max(r2)) return -1;
						r1.remove(Collections.max(r1));
						r2.remove(Collections.max(r2));
					}

				}
			}
		}
		return 0; // tie

	}

	// Is this hand a straight flush?
	public boolean isStraightFlush() { return isFlush() && isStraight(); }

	// Is this hand four of a kind?
	public boolean isFourOfaKind() { return rankFrequency.containsValue(4); }

	// Is this hand a full house (3 cards of the same rank & 2 cards of the same rank)?
	public boolean isFullHouse() { return rankFrequency.containsValue(3) && rankFrequency.containsValue(2); }

	// Is this hand a flush? (Can also be a straight.)
	public boolean isFlush() {
		char s = hand.get(0).getSuit();
		for (int i = 1; i < hand.size(); i++)
			if (hand.get(i).getSuit() != s) return false;
		return true;
	}

	// Is this hand a straight? (Can also be a flush.)
	public boolean isStraight() {
		for (int i = 1; i < cardRanks.length; i++)
			if (cardRanks[i] != cardRanks[i - 1] - 1) return false;
		return true;
	}

	// Is this hand three of a kind (also called a set or trips in poker)?
	public boolean isThreeOfaKind() { return rankFrequency.containsValue(3) && !rankFrequency.containsValue(2); }

	// Does this hand contain exactly two pairs?
	public boolean isTwoPair() {
		int numPairs = 0;
		for (int x : rankFrequency.values())
			if (x == 2) numPairs++;
		return numPairs == 2;
	}

	// Does this hand contain exactly one pair?
	public boolean isPair() {
		boolean isPair = false;
		for (int x : rankFrequency.values())
			if (x == 2) isPair = !isPair;
		return isPair;
	}

	// A nothing hand
	public boolean isNothing() {
		return !(isFlush() || isStraight() || isFullHouse() || isFourOfaKind() || isThreeOfaKind() || isPair()
				|| isTwoPair());
	}

	@Override
	public String toString() { return hand.toString(); }
}
