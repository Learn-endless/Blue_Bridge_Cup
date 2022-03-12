package com.lanqiaobei.learn;

/*
 * 方格填数
 */
public class TestDemo7 {
	
	public static int count = 0;   //用来统计次数
	public static int N = 3;       //行
	public static int M = 4;       //列
	
	public static boolean[] ret = new boolean[10];    //记录每个数字是否使用过	
	public static int[][] number = new int[N+2][M+2]; //用来存放数字
	
	
	public static void main(String[] args) {
		//将 number 数组进行初始化成 -20(随便一个负数就行)
		for(int i = 0; i < N+2; i++) {
			for(int j = 0; j < M+2; j++) {
				number[i][j] = -20;
			}
		}	
		//递归遍历所有的方案
		dfs(0,1,2);
		//打印方案的次数
		System.out.println(count);
		
	}

	/**
	 * 回溯算法
	 * @param depth   深度(也就是当前已经放了多少个数)
	 * @param n       当前所放位置的 - 行
	 * @param m       当前所放位置的 - 列
	 */
	private static void dfs(int depth, int n,int m) {
		//如果有了 10 个数
		if(depth == 10) {
			//统计一次
			count++;
			return;
		}
		//判断当前的下标是否需要进行 number 的下一行
		if(m > M) {
			n += 1;
			m = 1;
		}
		//循环的尝试放数字
		for(int i = 0; i <= 9 ;i++) {
			//先判断当前想要放的数字是否已经被使用了
			//检查当前想要放的 数字 是否符合题目要求:不是相邻的连续数字
			if(!ret[i]  &&  checkNumber(n,m,i)) {
				//放进 number 中
				number[n][m] = i;
				//更改 数字 的状态
				ret[i] = true;
				//递归下一个位置
				dfs(depth+1,n,m+1);
				//回溯
				number[n][m] = -20;
				ret[i] = false;
			}
		}
	}

	/**
	 * 用来检查是否符合要求  :  不是相邻的连续数字
	 * @param n     行
	 * @param m     列
	 * @param data  填充的数字
	 * @return      一个boolean值
	 */
	private static boolean checkNumber(int n, int m, int data) {
		if(
			//相邻并连续的两个数字,它们差的绝对值 一定等于 1
			Math.abs(data-number[n-1][m]) == 1   || Math.abs(data-number[n+1][m]) == 1   ||
			Math.abs(data-number[n][m+1]) == 1   || Math.abs(data-number[n][m-1]) == 1   ||
			Math.abs(data-number[n-1][m-1]) == 1 || Math.abs(data-number[n-1][m+1]) == 1 ||
			Math.abs(data-number[n+1][m-1]) == 1 || Math.abs(data-number[n+1][m+1]) == 1 
				) {
			return false;
		}
		return true;
	}
}
