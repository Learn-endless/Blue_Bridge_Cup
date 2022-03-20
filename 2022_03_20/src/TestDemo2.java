
import java.util.*;
public class TestDemo2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();     //表示序列的长度
		int m = sc.nextInt();     //表示对序列的操作次数
		
		Integer[] array = new Integer[n+1];
		for(int i = 1; i <= n; i++) {
			array[i] = i;
		}
		
		int[][] tmp = new int[m][2];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < 2; j++) {
				tmp[i][j] = sc.nextInt();
			}
		}	
	
		Comparator<Integer> parator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		};
		
		for(int i = 0; i < m; i++) {
			if(tmp[i][0] == 0) {
				Arrays.sort(array, 1, tmp[i][1]+1,parator);
			}else {
				Arrays.sort(array,tmp[i][1],n+1);
			}
		}
		for(int i = 1; i <= n; i++) {
			System.out.print(array[i]+" ");
		}
	}
}
