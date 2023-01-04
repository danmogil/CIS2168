package lab3;

public class TestNode {
	public static void main(String[] args) {
		String[] arr = new String[] { "to", "be", "or", "not", "to", "be" };
		Node<String> head = new Node<String>(arr[0]), tail = head;

		for (int i = 1; i < arr.length; i++) {
			tail.next = new Node<String>(arr[i]);
			tail = tail.next;
		}

		while (head != null) {
			System.out.print(String.format("%s -> ", head.data));
			head = head.next;
		}

	}
}
