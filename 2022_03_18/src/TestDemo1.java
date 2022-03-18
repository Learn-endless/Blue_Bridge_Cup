
import java.util.*;
public class TestDemo1 {
	/**
	 * 已知n和m，打印n^1，n^2，...，n^m。
	 * 要求用静态变量实现。n^m表示n的m次方。
	 * 已知n和m，打印n^1，n^2，...，n^m。要求用静态变量实现。
	 * n^m表示n的m次方。（每行显示5个数，每个数宽为12，右对齐）
	 * @param args
	 */
	public static int n;
	public static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 1; i <= m; i++) {
			System.out.printf("%12.0f",Math.pow(n, i));
			if(i % 5 == 0) {
				System.out.println();
			}
		}
	}
}
