import java.util.*;
public class TestDemo6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int[][] array = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++) {
			double count = 0;
			for(int j = 0; j < m; j++) {
				if(array[i][j] < 6) {
					count++;
				}
			}
			if(count/m > 0.6) {
				System.out.println("What The Hell");
			}else {
				System.out.println("tada!");
			}
		}
	}
}
