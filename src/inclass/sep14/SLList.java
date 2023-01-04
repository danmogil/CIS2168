package inclass.sep14;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SLList<E> implements Iterable<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;

	public SLList() {
		size = 0;
		head = tail = null;
	}

	// Cannot addLast
	public boolean add(int i, E e) {
		if (isValidI(i)) {
			if (i == 0) addFirst(e);
			else {
				Node<E> prev = getNode(i - 1);
				Node<E> next = prev.next;
				prev.next = new Node<>(e, next);
				size++;
			}
			return true;
		}
		return false;
	}

	public boolean remove(int i) {
		if (isValidI(i)) {
			if (i == 0) removeFirst();
			else if (i == size - 1) removeLast();
			else {
				Node<E> prev = getNode(i - 1);
				prev.next.data = null; // GC
				prev.next = prev.next.next;
				size--;
			}
			return true;
		}
		return false;
	}

	public void addFirst(E e) {
		if (isEmpty()) {
			head = new Node<>(e);
			tail = head;
		} else {
			Node<E> oldFirst = head;
			head = new Node<>(e, oldFirst);
		}
		size++;
	}

	public void addLast(E e) {
		if (isEmpty()) addFirst(e);
		else {
			tail.next = new Node<>(e);
			tail = tail.next;
			size++;
		}
	}

	public E removeFirst() {
		if (isEmpty()) throw new NoSuchElementException("List already empty!");

		E data = head.data;
		head.data = null; // GC
		head = head.next;
		size--;

		return data;
	}

	public E removeLast() {
		if (size < 2) return removeFirst();
		else {
			Node<E> prevLast = head;
			while (prevLast.next.next != null)
				prevLast = prevLast.next;

			E data = prevLast.next.data;
			prevLast.next.data = null; // GC
			prevLast.next = null;
			tail = prevLast;
			size--;

			return data;
		}
	}

	public E get(int i) { return getNode(i).data; }

	public E set(int i, E e) {
		Node<E> n = getNode(i);
		E data = n.data;
		n.data = e;
		return data;
	}

	public boolean contains(E e) { return indexOf(e) != -1; }

	public int indexOf(E e) {
		Node<E> headCopy = head;
		for (int i = 0; i < size; i++) {
			if (headCopy.data == e) return i;
			headCopy = headCopy.next;
		}
		return -1;
	}

	public boolean isEmpty() { return size == 0; }

	public int size() { return size; }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (isEmpty()) return "This list is empty!";
		Node<E> headCopy = head;
		while (headCopy != null) {
			sb.append(headCopy.data);
			if (headCopy.next != null) sb.append(" -> ");
			headCopy = headCopy.next;
		}
		return sb.toString();
	}

	@Override
	public Iterator<E> iterator() { return new SLIterator(); }

	private static class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E e) { data = e; }

		public Node(E e, Node<E> next) {
			data = e;
			this.next = next;
		}
	}

	private Node<E> getNode(int i) {
		if (!isValidI(i)) throw new IndexOutOfBoundsException();
		Node<E> headCopy = head;
		while (i-- > 0)
			headCopy = headCopy.next;
		return headCopy;
	}

	private boolean isValidI(int i) { return i >= 0 && i < size; }

	private class SLIterator implements Iterator<E> {
		private Node<E> current = head;

		@Override
		public boolean hasNext() { return current != null; }

		@Override
		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			E data = current.data;
			current = current.next;
			return data;
		}
	}
}
