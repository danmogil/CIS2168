package lab1c;

public class Reverser {
	// O(N/2) -> O(N)
	static int[] reverse(int[] nums) {
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int hiCopy = nums[hi];
			nums[hi--] = nums[lo];
			nums[lo++] = hiCopy;
		}
		return nums;
	}
}
