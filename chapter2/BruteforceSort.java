package chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * Bruteforce solving the sorting problem solution.
 * i.e. a parmutation of given numbers <a1, a2, a3, a4, a5>
 * so that a2 >= a1, a3 >= a2, a4 >=a3...
 * @author satyaprakashdwibedi
 *
 */
public class BruteforceSort {
	
	private static Map<Integer, Integer> factorialMap = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		int[] elements = {10, 7, 6, 9};
		System.out.println("starting.....");
		//total n! possibilities.
		int[][] perms = getAllPermutations(elements);
		for (int i = 0; i < perms.length; i++) {
			if (isSorted(perms[i])) {
				for (int j = 0; j < perms[0].length; j++) {
					System.out.print(perms[i][j] + ",");
				}
				break;
			}
		}
	}
	
	private static boolean isSorted(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			if (i == 0) {
				continue;
			}
			if (arr[i] < arr[i - 1]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * a[0], permutation(a[1]..a[n])
	 * @param a
	 * @return
	 */
	private static int[][] getAllPermutations(int[] a) {
		int possibilities = factorial(a.length);
		int[][] perms = new int[possibilities][a.length];
		if (a.length == 2) {
			perms[0] = new int[] {a[0], a[1]};
			perms[1] = new int[] {a[1], a[0]};
			return perms;
		}
		int aCntr = 0;
		for (int i = 0; i < possibilities; ) {
			int[] subElems = new int[a.length - 1];
			int subElemsCntr = 0;
			for (int j = 0; j < a.length; j++) {
				if (j == aCntr) {
					continue;
				}
				subElems[subElemsCntr++] = a[j];
			}
			int[][] subPerms = getAllPermutations(subElems);
			for (int k = 0; k < subPerms.length; k++) {
				perms[i][0] = a[aCntr];
				for (int p = 0; p < subPerms[0].length; p++) {
					perms[i][p+1] = subPerms[k][p];
				}
				i++;
			}
			aCntr++;
		}
		return perms;
	}
	
	private static int factorial(int n) {
		if (factorialMap.containsKey(n)) {
			return factorialMap.get(n);
		}
		int res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}
		factorialMap.put(n, res);
		return res;
	}
	
}
