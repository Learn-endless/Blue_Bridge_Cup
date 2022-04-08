package 斐波那契数列求最大公约数;

import java.math.BigInteger;

public class Main {
	
	private static BigInteger fibNumber(long n) {
		BigInteger a = new BigInteger("1",10);
		BigInteger b = new BigInteger("1",10);
		BigInteger c = new BigInteger("0",10);
		for(int i = 3; i <= n; i++) {
			c = a.add(b);
			a = b;
			b = c;
		}
		return c;
	}
	
	public static void main(String[] args) {
		BigInteger ret = fibNumber(2020).gcd(fibNumber(520));
		System.out.println(ret.toString());
	}
}
