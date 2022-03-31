import java.util.Scanner;

public class Main1 {
	
	public static void balanWeighing(int n, int[] weight, int sum){
		
		boolean[][] mat = new boolean[n+1][sum+1];
		mat[0][0] = true;
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= sum; j++) {
				
				if(mat[i-1][j] == true) {
					mat[i][j] = true;                //直接设置成true
					
					mat[i][j+weight[i-1]] = true;
					
					if(j > weight[i-1]) {
						mat[i][j-weight[i-1]] = true;
					}else {
						mat[i][weight[i-1]-j] = true;
					}
				}
			}
		}
		int ans = 0;
		for(int i = 1; i <= sum; i++) {
			if(mat[n][i]) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ret = new int[n];
		int sum = 0;
		for(int i = 0; i < n; i++) {
			ret[i] = sc.nextInt();
			sum += ret[i];
		}
		balanWeighing(n,ret,sum);
	}
}
