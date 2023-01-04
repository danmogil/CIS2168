package lab10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConnectedComponents {
	private static int numberOfComponents(ArrayList<Integer>[] adj) {
		int count = 0;
		List<Boolean> marked = new ArrayList<>(Collections.nCopies(adj.length, false));
		while (marked.contains(false)) {
			count++;
			dfs(adj, marked.indexOf(false), marked);
		}
		return count;
	}

	private static void dfs(ArrayList<Integer>[] adj, int v, List<Boolean> marked) {
		marked.set(v, true);
		for (int x : adj[v])
			if (!marked.get(x)) dfs(adj, x, marked);
	}

	// feel free to add a helper method to make your code cleaner & modular.

	public static void main(String[] args) {
		In in = new In("G2-1.txt");
		int n = in.readInt();
		int m = in.readInt();
		ArrayList<Integer>[] adj = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int x, y;
			x = in.readInt();
			y = in.readInt();
			adj[x - 1].add(y - 1);
			adj[y - 1].add(x - 1);
		}
		System.out.println(numberOfComponents(adj));
	}
}
