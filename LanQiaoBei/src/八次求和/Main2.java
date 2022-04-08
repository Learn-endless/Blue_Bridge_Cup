package °Ë´ÎÇóºÍ;

import java.util.Scanner;
public class Main2 {
	private static final int PI = 123456789;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long sum = 0;
		for(int i = 1; i <= n; i++) {
			long tmp = i;
			for(int j = 2; j <= 8; j++) {
				tmp = tmp * i % PI;
			}
			sum = (sum+tmp) % PI;
		}
		System.out.println(sum%PI);
	}
}
