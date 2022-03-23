
import java.util.*;
public class Main1 {
	public static void main(String[] args) {
		String[] str = new String[25];
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 25; i++) {
			str[i] = sc.nextLine();
		}
		
		int count = 0;
		for(int i = 0; i < 25; i++) {
			for(int j = 0; j < str[i].length(); j++) {
				if(str[i].charAt(j) == 'A') {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
