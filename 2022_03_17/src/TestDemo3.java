
import java.util.*;
/**
 * BASIC-15	VIPÊÔÌâ ×Ö·û´®¶Ô±È
 * @author 19833
 *
 */
public class TestDemo3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.next();
		String s2 = sc.next();
		
		if(s1.equals(s2)) {
			System.out.println("2");		
		}else if(s1.toUpperCase().equals(s2.toUpperCase())) {
			System.out.println("3");
		}else if(s1.length() == s2.length()) {
			System.out.println("4");
		}else {
			System.out.println("1");
		}
		
	}
}
