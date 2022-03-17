
import java.util.*;
public class TestDemo5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		for(int i = a; i <= b; i++) {
			if(isPrime(i)) {
				System.out.println(i+"="+i);
			}else {
				String ret = handleComposite(i); 
				System.out.println(i+"="+ret);
			}
		}
	}

	private static String handleComposite(int n) {
		StringBuilder s = new StringBuilder();
		while(n != 1) {
			for(int i = 2; i <= n; i++) {
				if(n % i == 0 && isPrime(i)) {
					s.append(i+"*");
					n /= i;
					break;
				}
			}
		}
		s.delete(s.length()-1, s.length());
		return s.toString();
	}

	private static boolean isPrime(int data) {
		for(int i = 2; i <= Math.sqrt(data); i++) {
			if(data % i == 0) {
				return false;
			}
		}
		return true;
	}
}
