package readingProblems.arrayLists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayList<E> implements Iterable<E> {

	private static final int INIT_CAPACITY = 10;

	private E[] elements;
	private int n = 0;

	@SuppressWarnings("unchecked")
	public ResizingArrayList() { elements = (E[]) new Object[INIT_CAPACITY]; }

	@SuppressWarnings("unchecked")
	public ResizingArrayList(int initCapacity) { elements = (E[]) new Object[initCapacity]; }

	// O(n)
	public void add(int index, E element) {
		if (index < 0 || index >= n) throw new ArrayIndexOutOfBoundsException();
		if (n == elements.length) resize(n * 2);
		for (int i = n; i < index; i--)
			elements[i] = elements[i - 1];
		elements[index] = element;
		n++;
	}

	// O(n), Amortized O(1)
	public void add(E element) {
		if (n == elements.length) resize(n * 2);
		elements[n++] = element;
	}

	// O(n)
	public int indexOf(E element) {
		for (int i = 0; i < n; i++) {
			if (elements[i] == element) return i;
		}
		return -1;
	}

	// O(n)
	public void remove(int index) {
		if (index < 0 || index >= n) throw new ArrayIndexOutOfBoundsException();
		for (int i = index + 1; i < n; i++)
			elements[i - 1] = elements[i];
		n--;
	}

	// O(1)
	public void set(int index, E element) {
		if (index < 0 || index >= n) throw new ArrayIndexOutOfBoundsException();
		elements[index] = element;
	}

	// O(1)
	public E get(int index) {
		if (index < 0 || index >= n) throw new ArrayIndexOutOfBoundsException();
		return elements[index];
	}

	// O(1)
	public int size() { return n; }

	@Override
	public String toString() { return Arrays.toString(elements); }

	@Override
	public Iterator<E> iterator() { return new ListIterator(); }

	private class ListIterator implements Iterator<E> {
		private int i = 0;

		@Override
		public boolean hasNext() { return i < n; }

		@Override
		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			return elements[i++];
		}
	}

	// O(n)
	private void resize(int capacity) {
		assert capacity >= n;
		elements = Arrays.copyOf(elements, capacity);
	}
}
