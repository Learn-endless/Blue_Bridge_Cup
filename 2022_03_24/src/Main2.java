import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	public static String[] s;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();   //表示几组数据
		
		for(int i = 0; i < n; i++) {
			int m = sc.nextInt();   //表示 字符串的个数
			s = new String[m];
			for(int j = 0; j < m; j++) {
				s[j] = sc.next();
			}
			Arrays.sort(s,(o1,o2)->{
				String o1o2 = o1+o2;
				String o2o1 = o2+o1;
				return o1o2.compareTo(o2o1);
			});
			for(int j = 0; j < s.length; j++) {
				System.out.print(s[j]);
			}
			System.out.println();
		}	
	}
}
