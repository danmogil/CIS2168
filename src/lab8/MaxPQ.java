package lab8;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxPQ<Key extends Comparable<Key>> implements Iterable<Key> {
	private Key[] pq; // a min-heap in pq[1...n] with pq[0] unused
	private int n; // number of items on this priority queue

	/* Constructor: creates a MaxPQ of size 1 */
	public MaxPQ() { this(1); }

	/* Constructor: creates a MaxPQ of capacity size */
	public MaxPQ(int capacity) { pq = (Key[]) new Comparable[capacity + 1]; }

	/* Constructor: builds a MaxPQ from an array of Comparable items */
	public MaxPQ(Key[] keys) {
		n = keys.length;
		pq = (Key[]) new Comparable[n + 1];
		for (int i = 0; i < n; i++)
			pq[i + 1] = keys[i];
		for (int k = n / 2; k >= 1; k--)
			sink(k);
	}

	// Adds a new key to this priority queue.
	public void add(Key x) {
		// double size of array if necessary
		if (n == pq.length - 1) resize(2 * pq.length);

		// add x, and percolate it up to maintain heap invariant
		pq[++n] = x;
		swim(n);
	}

	// Removes and returns the largest key on this priority queue.
	public Key extractMax() {
		if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
		Key max = pq[1];
		exch(1, n--);
		sink(1);
		pq[n + 1] = null; // to avoid loitering and help with garbage collection
		if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
		return max;
	}

	// Returns the largest key on this priority queue without removing it
	public Key max() {
		if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
		return pq[1];
	}

	// Is this priority queue empty?
	public boolean isEmpty() { return n == 0; }

	// How many items are in this priority queue?
	public int size() { return n; }

	/* Helper methods to restore the heap invariant */
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && less(j, j + 1)) j++;
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}

	/* Helper methods swaps and comparisons */
	private void exch(int i, int j) {
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}

	private boolean less(int i, int j) { return pq[i].compareTo(pq[j]) < 0; }

	/* A helper method for resizing an array (used when pq[] is full) */
	private void resize(int capacity) {
		assert capacity > n;
		Key[] temp = (Key[]) new Comparable[capacity];
		for (int i = 1; i <= n; i++)
			temp[i] = pq[i];
		pq = temp;
	}

	@Override
	public Iterator<Key> iterator() { return new HeapIterator(); }

	private class HeapIterator implements Iterator<Key> {
		// create a new pq
		private MinPQ<Key> copy;

		// add all items to copy of heap
		// takes linear time since already in heap order so no keys move
		public HeapIterator() {
			copy = new MinPQ<Key>(size());
			for (int i = 1; i <= n; i++)
				copy.add(pq[i]);
		}

		@Override
		public boolean hasNext() { return !copy.isEmpty(); }

		@Override
		public void remove() { throw new UnsupportedOperationException(); }

		@Override
		public Key next() {
			if (!hasNext()) throw new NoSuchElementException();
			return copy.extractMin();
		}
	}

	/* Unit tests the MaxPQ data type. */
	public static void main(String[] args) {
		MaxPQ<Character> pq = new MaxPQ<>();
		Character[] items = { 'P', 'Q', 'E', '-', 'X', 'A', 'M', '-', 'P', 'L', 'E', '-' };
		for (Character item : items) {
			if (!item.equals('-')) pq.add(item);
			else if (!pq.isEmpty()) System.out.print(pq.extractMax() + " ");
		}
		System.out.println("(" + pq.size() + " left on pq)");
	}
}
