package °Ë´ÎÇóºÍ;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		BigInteger sum=new BigInteger("0",10);
	
	
		for(int i=1;i<=n;i++) {
			String s=Integer.toString(i);
			BigInteger x=new BigInteger(s,10);
			sum=sum.add(x.pow(8)).mod(new BigInteger("123456789",10));
		}
		
		System.out.println(sum.toString());
	}
}
