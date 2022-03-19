
import java.util.*;
public class TestDemo2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		StringBuilder str = new StringBuilder(s);
		str.delete(s.length()-3, s.length());
		str.reverse();
		s = str.toString();
		char[] ch = s.toCharArray();
		
	}
}
