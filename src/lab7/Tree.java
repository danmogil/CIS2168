package lab7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Tree<Key extends Comparable<Key>> {
	private Node<Key> root;

	public Tree() { root = null; }

	public void add(Key key) {
		if (root == null) root = new Node<>(key);
		else root.insert(key);
	}

	public void inorderTraversal() {
		System.out.print("Inorder Traversal: ");
		inorderTraversal(root);
		System.out.println();
	}

	public void preorderTraversal() {
		System.out.print("Preorder Traversal: ");
		preorderTraversal(root);
		System.out.println();
	}

	public void postorderTraversal() {
		System.out.print("Postorder Traversal: ");
		postorderTraversal(root);
		System.out.println();
	}

	public void levelorderTraversal() {
		Queue<Node<Key>> q = new LinkedList<>();
		q.add(root);

		while (q.size() > 0) {
			Node<Key> n = q.remove();
			System.out.print(n.data + " ");
			if (n.left != null) q.add(n.left);
			if (n.right != null) q.add(n.right);
		}
	}

	public int getDepth() { return getDepth(0, root); }

	public Key contains(Key k) { return contains(k, root); }

	public void outputTree() { outputTree(0, root); }

	// Client
	public static void main(String[] args) {

		Tree<Integer> ta = new Tree<>();
		for (Integer x : new int[] { 49, 28, 83, 18, 40, 71, 97, 11, 19, 32, 44, 69, 72, 92, 99 })
			ta.add(x);
		ta.inorderTraversal(); // 11, 18, 19, 28, 32, 40, 44, 49, 69, 71, 72, 83, 92, 97, 99
		ta.preorderTraversal(); // 49, 28, 18, 11, 19 ,40, 32, 44, 83, 71, 69, 72, 97, 92, 99
		ta.postorderTraversal(); // 11, 19, 18, 32, 44, 40, 28, 69, 71, 72, 83, 92, 97, 99
		System.out.println();

		Tree<Integer> tb = new Tree<>();
		Random r = new Random();
		for (int i = 0; i < 20; i++)
			tb.add(r.nextInt());
		System.out.println(tb.getDepth());

		System.out.println(ta.contains(99)); // 99
		System.out.println(ta.contains(100)); // null

		System.out.println();
		ta.outputTree();

		System.out.println();
		ta.levelorderTraversal();
	}

	private void inorderTraversal(Node<Key> n) {
		if (n == null) return;
		inorderTraversal(n.left);
		System.out.printf("%s ", n.data);
		inorderTraversal(n.right);
	}

	private void preorderTraversal(Node<Key> n) {
		if (n == null) return;
		System.out.printf("%s ", n.data);
		inorderTraversal(n.left);
		inorderTraversal(n.right);
	}

	private void postorderTraversal(Node<Key> n) {
		if (n == null) return;
		inorderTraversal(n.left);
		inorderTraversal(n.right);
		System.out.printf("%s ", n.data);
	}

	private int getDepth(int depth, Node<Key> n) {
		if (n != null && (n.left != null || n.right != null))
			return Math.max(getDepth(depth + 1, n.left), getDepth(depth + 1, n.right));
		else return depth;
	}

	private Key contains(Key k, Node<Key> n) {
		if (n == null) return null;

		int comp = k.compareTo(n.data);
		if (comp < 0) return contains(k, n.left);
		else if (comp > 0) return contains(k, n.right);
		else return n.data;
	}

	private void outputTree(int totalSpaces, Node<Key> n) {
		if (n != null) {
			outputTree(totalSpaces + 5, n.right);
			for (int i = 0; i < totalSpaces; i++)
				System.out.print(" ");
			System.out.println(n.data);
			outputTree(totalSpaces + 5, n.left);
		}
	}

	private static class Node<Key extends Comparable<Key>> {
		Key data;
		Node<Key> left, right;

		public Node(Key key) {
			data = key;
			left = right = null;
		}

		public void insert(Key key) {
			if (key.compareTo(data) <= 0) {
				if (left == null) left = new Node<>(key);
				else left.insert(key);
			} else {
				if (right == null) right = new Node<>(key);
				else right.insert(key);
			}
		}

		@Override
		public String toString() { return data.toString(); }
	}
}
