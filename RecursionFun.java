/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Penghui Han
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (n == k) {
			return 1;
		} else if (k == 1) {
			return n;
		} else if (k == 0) {
			return 1;
		} else {
			int temp = n - 1;
			return combinations(temp, k - 1) + combinations(temp, k);
		}
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		// TODO: Implement this method using recursion. Do not use a loop
		String strNumber = "" + n;
		String result = "";
		return inWithCommmas(strNumber, result);
	}

	private String inWithCommmas(String n, String result) {
		// TODO Auto-generated method stub
		if (n.length() <= 3) {
			return result + n;
		}
		if ((n.length() - 1) % 3 == 0)
			return result + n.charAt(0) + "," + inWithCommmas(n.substring(1), result);
		else
			return result + n.charAt(0) + inWithCommmas(n.substring(1), result);
	}

// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length - 1);
	}

	private void reverseArray(int[] x, int index, int len) {
		// TODO: Complete this method with a recursive algorithm.
		// Do NOT use a loop.
		if (index >= len) {
			return;
		} else {
			int temp = x[index];
			x[index] = x[len];
			x[len] = temp;
			reverseArray(x, index + 1, len - 1);
		}

	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		int checkMax = Integer.MIN_VALUE;
		int checkMin = Integer.MAX_VALUE;
		int maxNumber = firstArray(a, a.length - 1, checkMax);
		int minNumber = secondArray(a, a.length - 1, checkMin);
		return maxNumber - minNumber;
	}

	private int secondArray(int[] a, int i, int checkMin) {
		if (i < 0)
			return checkMin;
		if (a[i] < checkMin)
			checkMin = a[i];
		return secondArray(a, i - 1, checkMin);
	}

	private int firstArray(int[] a, int i, int check) {
		if (i < 0)
			return check;
		if (a[i] > check)
			check = a[i];
		return firstArray(a, i - 1, check);
	}

// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		// Need to send down 0 to keep track of the index
		return isSorted(nums, nums.length - 1);
	}

	private boolean isSorted(int[] nums, int i) {
		if (i <= 0)
			return true;
		if (nums[i - 1] > nums[i])
			return false;
		return isSorted(nums, i - 1);
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		return found(search, strs, strs.length - 1);
	}

	private boolean found(String search, String[] strs, int i) {
		// TODO Auto-generated method stub
		if (i < 0)
			return false;
		if (strs[i].equals(search))
			return true;
		return found(search, strs, i - 1);
	}
}
