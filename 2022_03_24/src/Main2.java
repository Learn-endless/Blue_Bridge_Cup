import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
	public static String[] s;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();   //表示几组数据
		
		for(int i = 0; i < n; i++) {
			int m = sc.nextInt();   //表示 字符串的个数
			s = new String[m];
			PriorityQueue<Character> pr = new PriorityQueue<>();
			for(int j = 0; j < m; j++) {
				s[j] = sc.next();
				for(int k = 0; k < s[j].length(); k++) {
					char ch = s[j].charAt(k);
					if(ch != ' ') {
						pr.offer(ch);
					}
				}
			}
			StringBuilder str = new StringBuilder();
			while(pr.size() != 0) {
				str.append(pr.poll());
			}
			System.out.println(str.toString());
		}	
	}
}
