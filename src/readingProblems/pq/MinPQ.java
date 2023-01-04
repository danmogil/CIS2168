package readingProblems.pq;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Heap implementation of a PQ
public class MinPQ<Key extends Comparable<Key>> implements Iterable<Key> {
	private static final int DEFAULT_CAP = 11;
	private Key[] heap;
	int n = 0;

	public MinPQ() { this(DEFAULT_CAP); }

	@SuppressWarnings("unchecked")
	public MinPQ(int capacity) {
		heap = (Key[]) new Comparable[capacity + 1];
		heap[0] = null;
	}

	public MinPQ(Key[] keys) {
		this(keys.length);
		while (n < keys.length)
			heap[n + 1] = keys[n++];
		for (int i = n / 2; i >= 1; i--)
			sink(i);
	}

	public void offer(Key item) {
		if (n + 1 == heap.length) resize(heap.length * 2);
		heap[++n] = item;
		swim(n);
	}

	public Key poll() {
		if (isEmpty()) throw new NoSuchElementException("PQ Underflow");
		Key min = heap[1];
		heap[1] = null; // GC
		exch(1, n--);
		sink(1);
		return min;
	}

	public Key peak() {
		if (isEmpty()) throw new NoSuchElementException("PQ Underflow");
		return heap[1];
	}

	public int size() { return n; }

	public boolean isEmpty() { return size() == 0; }

	@Override
	public Iterator<Key> iterator() { return new HeapIterator(); }

	private class HeapIterator implements Iterator<Key> {
		private MinPQ<Key> copy;

		public HeapIterator() {
			copy = new MinPQ<>(size());
			for (int i = 1; i < heap.length; i++)
				copy.offer(heap[i]);
		}

		@Override
		public boolean hasNext() { return !isEmpty(); }

		@Override
		public Key next() {
			if (!hasNext()) throw new NoSuchElementException();
			return copy.poll();
		}

	}

	// Helper Methods

	private void sink(int i) {
		while (2 * i <= n) {
			int k = 2 * i;
			if (k < n && greater(k, k + 1)) k++;
			if (!greater(i, k)) break;
			exch(i, k);
			i = k;
		}
	}

	private void swim(int i) {
		while (i > 1 && greater(i / 2, i)) {
			exch(i, i / 2);
			i /= 2;
		}
	}

	private boolean greater(int i, int j) { return heap[i].compareTo(heap[j]) > 0; }

	private void exch(int i, int j) {
		Key temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	private void resize(int s) { heap = Arrays.copyOf(heap, s); }

	public static void main(String[] args) {
		MinPQ<Integer> pq = new MinPQ<>();
		pq.offer(1);
		pq.offer(3);
		pq.offer(1);
		for (Integer x : pq)
			System.out.println(x);
	}
}
