import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		
		ArrayList<Long> aNumber = new ArrayList<>();
		ArrayList<Long> bNumber = new ArrayList<>();
		ArrayList<Long> cNumber = new ArrayList<>();
		
		for(long i = 1; i <= Math.sqrt(a); i++) {
			if(a % i == 0) {
				aNumber.add(i);
				aNumber.add(a / i);
			}
		}
		for(long i = 1; i <= Math.sqrt(b); i++) {
			if(b % i == 0) {
				bNumber.add(i);
				bNumber.add(b / i);
			}
		}
		for(long i = 1; i <= Math.sqrt(c); i++) {
			if(c % i == 0) {
				cNumber.add(i);
				cNumber.add(c / i);
			}
		}
		Set<Long> set = new HashSet<>();
		for(int i = 0; i < aNumber.size(); i++) {
			for(int j = 0; j < bNumber.size(); j++) {
				for(int k = 0; k < cNumber.size(); k++) {
					if(aNumber.get(i) == bNumber.get(j)) {
						set.add(aNumber.get(i));
					}
					if(aNumber.get(i) == cNumber.get(k)) {
						set.add(aNumber.get(i));
					}
					if(bNumber.get(j) == cNumber.get(k)) {
						set.add(bNumber.get(j));
					}
				}
			}
		}
		System.out.println(set.size());
	}
}
