import java.util.Scanner;
public class Main6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c != ',') {
				str.append(c);
			}
		}
		System.out.println(str.toString());
	}
}