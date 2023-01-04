package readingProblems.linkedLists;

import java.util.NoSuchElementException;

public class CircularQueue<E> {
	private Node last;
	private int n;

	public void enqueue(E e) {
		if (n == 0) {
			last = new Node();
			last.next = last;
		} else {
			Node head = last.next;
			last.next = new Node();
			last = last.next;
			last.next = head;
		}
		last.data = e;
		n++;
	}

	public E dequeue() {
		if (n == 0) throw new NoSuchElementException();
		E data;
		if (n == 1) {
			data = last.data;
			last.data = null; // GC
			last = null;
		} else {
			data = last.next.data;
			last.next.data = null; // GC
			last = last.next.next;
		}
		n--;
		return data;
	}

	public boolean isEmpty() { return n == 0; }

	public int size() { return n; }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node lastC = last;
		for (int i = 0; i < n; i++) {
			sb.append(lastC.data);
			if (i < n - 1) sb.append(" -> ");
			lastC = lastC.next;
		}
		return sb.toString();
	}

	private class Node {
		E data;
		Node next;
	}

	public static void main(String[] args) {
		CircularQueue<Integer> cq = new CircularQueue<>();
		cq.enqueue(1);
		cq.enqueue(2);
		System.out.println(cq);
		System.out.println(cq.dequeue()); // 1
		System.out.println(cq.dequeue()); // 2
	}
}
