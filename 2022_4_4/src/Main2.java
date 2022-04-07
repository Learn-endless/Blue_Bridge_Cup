import java.util.ArrayList;

public class Main2 {
	public static void main(String[] args) {
		long n = 2021041820210418L;
		
		ArrayList<Long> list = new ArrayList<>();
		for(long i = 1; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				list.add(i);
				list.add(n / i);
			}
		}
		
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.size(); j++) {
				for(int z = 0; z < list.size(); z++) {
					if(list.get(i) * list.get(j) * list.get(z) == n) {
						sum++;
					}
				}
			}
		}
		System.out.println(sum);
	}
}
