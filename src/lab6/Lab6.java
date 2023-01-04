package lab6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Lab6<E> {

	public static void StackToQueue(Stack<Integer> s, Queue<Integer> q) {
		while (!s.isEmpty())
			q.add(s.pop());
	}

	/*	11.4)
	 *  	a) sum(queue) prints 15.
	 *  	b) queue prints [] because sum(queue) removed all of elements from the queue.
	 *  */

	public static class SumQueue {
		public static void main(String[] args) {
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 1; i <= 5; i++)
				queue.add(i);
			System.out.println(queue); // [1, 2, 3, 4, 5]
			System.out.println(sum(queue)); // 15
			System.out.println(queue); // [1, 2, 3, 4, 5]
		}

		public static int sum(Queue<Integer> q) {
			Queue<Integer> copy = new LinkedList<>(q);
			int sum = 0;
			for (int x : copy)
				sum += x;
			return sum;
		}
	}
}
