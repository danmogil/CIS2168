package lab4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
  Class BabyList is a watered-down version of a list. It has
  an add() method that allows clients to add an element at
  the end of the list. It also has the usual isEmpty() and
  size() methods.

  BabyList is Iterable, though. Once clients create a BabyList,
  they can iterate through it using an Iterator object returned
  by BabyList's iterator() method. In particular, clients can
  use the usual for-each construct to iterate through BabyLists.
 */
public class BabyList<E> implements Iterable<E> {
	private int n; // size of the list
	private Node first; // reference to the first node of the list
	private Node last; // reference to the last node of the list

	// Private helper Node data type
	private static class Node<E> {
		E data;
		Node next;
	}

	// appends an element to the list (to the end)
	public void add(E value) {
		Node<E> oldlast = last;
		last = new Node<E>();
		last.data = value;
		last.next = null;
		if (isEmpty()) first = last;
		else oldlast.next = last;
		n++;
	}

	// returns the value at index, null if index out of bounds
	public E get(int index) {
		if (index < 0 || index >= n) {
			System.out.println("Index out of bounds. Returning null.");
			return null;
		}
		Node current = first;
		for (int i = 0; i < index; i++)
			current = current.next;
		return (E) current.data;
	}

	/*   ---- MAKING THE LIST ITERABLE ---  */
	// returns an iterator to this list that iterates from the first to the last
	// item in the list
	@Override
	public Iterator<E> iterator() { return new LinkedIterator(); }

	// an iterator (does not implement remove - implementing it is optional)
	private class LinkedIterator implements Iterator<E> {
		private Node current = first;

		@Override
		public boolean hasNext() { return current != null; }

		@Override
		public void remove() { throw new UnsupportedOperationException(); }

		@Override
		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			E value = (E) current.data;
			current = current.next;
			return value;
		}
	}

	// is this list empty?
	public boolean isEmpty() { return n == 0; }

	// the size of this list (the number of nodes in it)
	public int size() { return n; }

	public static void main(String[] args) {
		BabyList<Integer> list = new BabyList<>();
		for (int i = 0; i < 10; i++)
			list.add(i);

		System.out.print("Printing the list using for-each:        ");
		for (Integer integer : list)
			System.out.print(integer + " ");
		System.out.println();

		System.out.print("Printing the list using an Iterator:     ");
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer k = iterator.next();
			System.out.print(k + " ");
		}
		System.out.println();

		System.out.print("\nPrinting each element using list.get():  ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}

}
