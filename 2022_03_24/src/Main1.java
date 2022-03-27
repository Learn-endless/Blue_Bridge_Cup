import java.util.Scanner;
/**
 * 试题 算法提高 约数个数
 * @author 19833
 *
 */
public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		
		int sum = 0;
		//只使用一个循环时，才不会  运行超时
		for(int i = 1; i <= n; i++) {
			sum += n/i % 1000000007;
		}
		System.out.println(sum%1000000007);
	}
}
