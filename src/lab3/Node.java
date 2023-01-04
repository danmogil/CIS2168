package lab3;

public class Node<E> {
	E data;
	Node<E> next;

	public Node(E e) {
		data = e;
	}

	public Node(E e, Node<E> next) {
		data = e;
		this.next = next;
	}
}
