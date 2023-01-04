package readingProblems.linkedLists;

import java.util.ArrayList;
import java.util.List;

public class Solutions {

	public static LinkedList deDup(LinkedList first) {
		LinkedList tail = first;
		while (tail != null) {
			while (tail.next != null && tail.value == tail.next.value)
				tail.next = tail.next.next;
			tail = tail.next;
		}
		return first;
	}

	public static LinkedList rmLast(LinkedList first) {
		LinkedList prevLast = first;
		while (prevLast.next.next != null)
			prevLast = prevLast.next;
		prevLast.next = null;
		return first;
	}

	public static LinkedList delete(LinkedList first, int k) {
		if (k < 0) throw new IllegalArgumentException("Index must be > -1");
		if (k == 0) return first.next;
		LinkedList tail = first;
		while (k-- > 0) {
			if (tail != null) tail = tail.next;
			else throw new IllegalArgumentException("Index out of bounds");
		}
		tail.next = tail.next == null ? null : tail.next.next;
		return first;
	}

	public static boolean find(LinkedList first, int key) {
		LinkedList tail = first;
		while (tail != null) {
			if (tail.value == key) return true;
			tail = tail.next;
		}
		return false;
	}

	public static class LinkedList {
		private int value;
		private LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}

		// Test helper
		public LinkedList(int[] vals) {
			this(vals[0]);
			LinkedList tail = this;
			for (int i = 1; i < vals.length; i++) {
				tail.next = new LinkedList(vals[i]);
				tail = tail.next;
			}
		}

		// Test helper
		public Integer[] toArray() {
			List<Integer> ls = new ArrayList<>();
			LinkedList tail = this;
			while (tail != null) {
				ls.add(tail.value);
				tail = tail.next;
			}
			return ls.toArray(new Integer[0]);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			LinkedList head = this;
			while (head != null) {
				sb.append(head.value);
				if (head.next != null) sb.append(" -> ");
				head = head.next;
			}
			return sb.toString();
		}
	}
}