import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += n/i % 1000000007;
		}
		System.out.println(sum%1000000007);
	}
}
