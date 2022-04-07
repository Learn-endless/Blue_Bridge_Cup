package 斐波那契数列求最大公约数;

import java.math.BigInteger;

public class Main {
	
	private static long fibNumber(long n) {
		int[] arr = new int[2025];
		BigInteger a = new BigInteger(arr);
		BigInteger b = 1;
		long c = -1;
		for(int i = 3; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
	
	public static void main(String[] args) {
		long n1 = fibNumber(2020);
		long n2 = fibNumber(520);
		System.out.println(n1+"   "+n2);
	}
}
