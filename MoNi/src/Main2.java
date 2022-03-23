import java.util.*;
public class Main2 {
	public static void main(String[] args) {
		int count = 0;
		for(int i = 1; i <= 2021; i++) {
			int n = i;
			while(n != 0) {
				int ret = n % 10;
				if(ret == 2) {
					count++;
					break;
				}
				n /= 10;
			}
		}
		System.out.println(count);
	}
}
