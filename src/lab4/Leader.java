package lab4;

import inclass.sep14.SLList;

public class Leader {

	// O(2n) -> O(n) runtime
	private static int solution(int n, int m) {
		SLList<Integer> ls = new SLList<>();
		for (int i = 1; i <= n; i++)
			ls.addLast(i);
		int p = 0;
		while (ls.size() > 1) {
			p = (p + m - 1) % ls.size();
			ls.remove(p);
		}
		return ls.get(0);
	}

	public static void main(String[] args) {
		System.out.println(solution(7, 2)); // 7 
		System.out.println(solution(9, 5)); // 8
		System.out.println(solution(11, 10)); // 7
	}
}
