package timecomplexity;

public class NFinder {
	
	public static void main(String[] args) {
		//assuming n*n & 8 log n.
		int n = 4;
		while (8 * n*n < 64 * Math.log(n)) {
			System.out.println("8 n square: " + 8*n*n + ", 64 log(n): " + 64 * Math.log(n));
			n++;
		}
		System.out.println("8 n square: " + 8*n*n + ", 64 log(n): " + 64 * Math.log(n));
		System.out.println(n);
	}

}
