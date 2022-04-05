package n皇后问题;
import java.util.*;
/**
 * 在N*N的方格棋盘放置了N个皇后，
 * 使得它们不相互攻击（即任意2个皇后不允许处在同一排，同一列，
 * 也不允许处在与棋盘边框成45角的斜线上。
 * 你的任务是，对于给定的N，求出有多少种合法的放置方法?
 */
public class Main1 {
	
	private static int count = 0;    //用来统计合法的放置方法
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//接收 n 的值
		int n = sc.nextInt();
		
		//创建一个 n * n的二维矩阵棋盘
		int[][] board = new int[n][n];
		
		//使用回溯算法
		dfs(0,board,n);
		
		//将count中的种树输出出来
		System.out.println(count);
	}

	/**
	 * 用dfs求n皇后的放置种数
	 * @param i       //递归的深度，也就是放了几个皇后了
	 * @param board   //棋盘
	 */
	private static void dfs(int depth, int[][] board,int n) {
		//统计次数的条件
		if(depth == n) {
			count++;
			return;
		}
		//遍历每一行的每个位置，尝试的往该位置放皇后
		for(int i = 0; i < n; i++) {
			//先检查这个位置能否放皇后
			if(isDanger(depth,i,board, n)) {
				//放皇后
				board[depth][i] = 1;   //1表示将一个皇后放到了board棋盘的该位置上
				//下一行
				dfs(depth+1,board,n);
				//进行回溯
				board[depth][i] = 0;   //0表示右把该位置上的皇后给拿走了
			}
		}
	}
	/**
	 * 检查当前位置是否能放皇后
	 * @param row   行坐标
	 * @param col       列坐标
	 * @return
	 */
	private static boolean isDanger(int row, int col,int[][] board,int n) {
		//如果当前位置已经有了皇后，那么就返回 false
		if(board[row][col] == 1) {
			return false;
		}
		
		//循环判断同一行，同一列 ，45度的正对角线，-45度的反对角线
		for(int i = 0; i < row; i++) {
			if(board[i][col] == 1) {
				return false;
			}
			
			for(int j = 0; j < n; j++) {
				if((row+col == i+j || row-col == i-j) && board[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
