package com.lanqiaobei.learn;

import java.util.Scanner;

/**
  * 标题：穿越雷区
 * @author 只爱吃土豆
 *
 */
public class TestDemo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();                   //辐射区大小 n 行 n列
		char[][] array = new char[n+2][n+2];    //存放辐射区字符,需要多出两行两列来设置边界
		boolean[][] roadState = new boolean[n+2][n+2];  //存放当前字符是否被使用的状态
		int[][] count = new int[n+2][n+2];
		
		int a1 = -1;   //用来记录 A 的下标
		int a2 = -1;
		
		//循环输入一个 二维 数组
		for(int i = 1; i <= n ; i++) {
			for(int j = 1; j <= n; j++) {
				String s = sc.next();
				char tmp = s.charAt(0);
				if(tmp == 'A') {
					array[i][j] = 'A';   //将 A 放进数组
					//记录初始点 A 的下标
					a1 = i;
					a2 = j;
				}else if(tmp == '+') {
					array[i][j] = '+';
				}else if(tmp == '-') {
					array[i][j] = '-';
				}else if(tmp == 'B') {
					array[i][j] = 'B';
				}
			}
		}
		//对 roadState 数组进行初始化 (true表示不能通过或者已经走过)
		for(int i = 0; i < n+2; i++) {
			roadState[0][i] = true;    //上边界
			roadState[n+1][i] = true;  //下边界
			roadState[i][0] = true;    //左边界
			roadState[i][n+1] = true;  //右边界
		}
		
		//打印最小步数
		System.out.println(dfs(a1,a2,array,roadState,count));
	}

	private static int dfs(int a1, int a2, char[][] array, boolean[][] roadState,int[][] count) {
		//如果当前下标的值就是 'B',说明走完了.
		if(array[a1][a2] == 'B')  return 0;
		
		//如果当前位置 的最小步数 已经被 计算过,直接返回.
		if(count[a1][a2] != 0) {
			return count[a1][a2];
		}
		
		//改变一下当前位置的 状态,说明已经被走过了
		roadState[a1][a2] = true;
		
//		System.out.println(a1+"-->"+a2);
		
		//统计当前位置从四个方向走到达 'B' 所要的 步数.
		int l1 = Integer.MAX_VALUE-1;
		int l2,l3,l4;               //
		l2 = l3 = l4 = l1;          //因为等下要求最小步数,所以这里用一个大的数来初始化
		
		if(!roadState[a1][a2+1] && array[a1][a2] != array[a1][a2+1]) {
			//说明可以往 右走
			l1 = dfs(a1,a2+1,array,roadState,count);   //统计步数到 l1 里面
		}
		if(!roadState[a1][a2-1] && array[a1][a2] != array[a1][a2-1]) {
			//说明可以往 左走
			l2 = dfs(a1,a2-1,array,roadState,count);   //统计步数到 l2 里面
		}
		if(!roadState[a1+1][a2] && array[a1][a2] != array[a1+1][a2]) {
			//说明可以往 上走
			l3 = dfs(a1+1,a2,array,roadState,count);   //统计步数到 l3 里面
		}
		if(!roadState[a1-1][a2] && array[a1][a2] != array[a1-1][a2]) {
			//说明可以往 下走
			l4 = dfs(a1-1,a2,array,roadState,count);   //统计步数到 l4 里面
		}
		
		//运行到这里,需要进行 回溯 ,重新将 当前的位置设置为 false(没走过的状态)
		roadState[a1][a2] = false;
		//返回最小步数 l1 l2 l3 l4 中的最小值+1 (当前算一步) 到 count数组对应的位置
		return count[a1][a2] = Math.min(Math.min(l1, l2), Math.min(l3, l4))+1;
	}
}
