import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main7 {
	public static long a1 = 0;
	public static long b1 = 0;
	public static long c1 = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a2 = sc.nextLong();
		long b2 = sc.nextLong();
		long c2 = sc.nextLong();
		Map<Long,Long> map = new HashMap<>();
		
		for(long i = 1; i <= Math.sqrt(a2); i++) {
			if(a2 % i == 0) {
				if(map.containsKey(i)) {
					map.put((long) i, map.get(i)+1);
				}else {
					map.put(i, (long) 0);
				}
				long num = a2 / i;
				if(map.containsKey(num)) {
					map.put(num, map.get(num)+1);
				}else {
					map.put(num, (long) 0);
				}
			}
		}
		
		for(long i = 1; i <= Math.sqrt(b2); i++) {
			if(b2 % i == 0) {
				if(map.containsKey(i)) {
					map.put(i, map.get(i)+1);
				}else {
					map.put(i, (long) 0);
				}
				long num = b2 / i;
				if(map.containsKey(num)) {
					map.put(num, map.get(num)+1);
				}else {
					map.put(num, (long) 0);
				}
			}
		}
		
		for(long i = 1; i <= Math.sqrt(c2); i++) {
			if(c2 % i == 0) {
				if(map.containsKey(i)) {
					map.put(i, map.get(i)+1);
				}else {
					map.put(i, (long) 0);
				}
				long num = c2 / i;
				if(map.containsKey(num)) {
					map.put(num, map.get(num)+1);
				}else {
					map.put(num, (long) 0);
				}
			}
		}
		long count = 0;
		for(Entry<Long, Long> ent : map.entrySet()) {
			if(ent.getValue() != 0) {
				count++;
			}
		}
		System.out.println(count);
	}
}
