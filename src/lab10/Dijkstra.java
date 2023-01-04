package lab10;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {

	private static final int INFINITY = 10000;

	private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
		int[] costTo = new int[adj.length];
		for (int i = 0; i < costTo.length; i++)
			costTo[i] = INFINITY;
		costTo[s] = 0;

		bfs(adj, cost, s, costTo);
		return costTo[t] == INFINITY ? -1 : costTo[t];
	}

	private static void bfs(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int[] costTo) {
		boolean[] marked = new boolean[adj.length];
		marked[s] = true;

		Queue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, costTo[s]));

		while (!pq.isEmpty()) {
			int curr = pq.poll().getIndex();
			for (int i = 0; i < adj[curr].size() && !marked[adj[curr].get(i)]; i++) {
				if (costTo[adj[curr].get(i)] > costTo[curr] + cost[curr].get(i)) {
					costTo[adj[curr].get(i)] = costTo[curr] + cost[curr].get(i);
				}
			}

			marked[curr] = true;

			for (int i = 0; i < adj[curr].size(); i++) {
				if (!marked[i]) pq.add(new Node(i, costTo[i]));
			}

		}
	}

	private static class Node implements Comparable<Node> {
		private int i;
		private int c;

		public Node(int i, int c) {
			this.i = i;
			this.c = c;
		}

		public int getIndex() { return i; }

		@Override
		public int compareTo(Node e) { return this.c - e.c; }

	}

	public static void main(String[] args) {
		In in = new In("G4-1.txt");
		int n = in.readInt();
		int m = in.readInt();
		ArrayList<Integer>[] adj = new ArrayList[n];
		ArrayList<Integer>[] cost = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
			cost[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int x, y, w;
			x = in.readInt();
			y = in.readInt();
			w = in.readInt();
			adj[x - 1].add(y - 1);
			cost[x - 1].add(w);
		}
		int x = in.readInt() - 1;
		int y = in.readInt() - 1;
		System.out.println(distance(adj, cost, x, y));
	}
}
