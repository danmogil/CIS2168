package lab5;

import java.util.Iterator;

import inclass.sep14.SLList;

public class MyStack<E> implements Iterable<E> {
	SLList<E> ls = new SLList<>();

	public void push(E element) { ls.addFirst(element); }

	public E pop() {
		E temp = ls.get(0);
		ls.removeFirst();
		return temp;
	}

	public E peek() { return ls.get(0); }

	public boolean isEmpty() { return ls.isEmpty(); }

	public int size() { return ls.size(); }

	@Override
	public String toString() { return ls.toString(); }

	@Override
	public Iterator<E> iterator() { return new StackIterator(); }

	private class StackIterator implements Iterator<E> {
		int i = 0;

		@Override
		public boolean hasNext() { return i < ls.size(); }

		@Override
		public E next() {
			if (!hasNext()) throw new IndexOutOfBoundsException();
			return ls.get(i++);
		}
	}
}
