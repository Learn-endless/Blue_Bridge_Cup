package 砝码称重;

import java.util.Scanner;

public class Main1 {
	
	private static int func(int n, int[] weight) {
		//首先求出最大能称出的重量
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += weight[i];
		}
		
		boolean[][] flg = new boolean[n+1][sum+1];
		flg[0][0] = true;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= sum; j++) {
				//表示当前这个重量可以被称出来
				if(flg[i-1][j]) {
					//直接退化上一个状态
					flg[i][j] = true;
					//说明当前的可以称出的重量 j + 第i件砝码的重量 也可以被称出来
					flg[i][j+weight[i-1]] = true;
					
					//上面只是进行的加的操作，然后进行减的操作
					//这里为了防止减出负数的重量，所以先进行比较，然后相减
					if(j > weight[i-1]) {
						flg[i][j-weight[i-1]] = true;
					}else {
						flg[i][weight[i-1]-j] = true;
					}
				}
			}
		}
		//统计最后一行为 true 的值(由于第0列是一个辅助状态，所以不会统计它是否为 true)
		int ans = 0;
		for(int i = 1; i <= sum; i++) {
			if(flg[n][i]) {
				ans++;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] weight = new int[n];
		for(int i = 0; i < n; i++) {
			weight[i] = sc.nextInt();
		}
		
		int ans = func(n,weight);
		System.out.println(ans);
	}
}
