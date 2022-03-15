package com.lanqiaobei.learn;

import java.util.*;
public class TestDemo10 {
	/**
	 * 2皇后问题
	 * @param args
	 */
	public static int n = 2;
	public static int[][] board = new int[n][n];
	public static int count = 0;
	
	public static void main(String[] args) {
		dfs(0);
	}

	private static void dfs(int row) {
		if(row == n) {
			count++;
			System.out.println("第"+count+"种:");
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			return;
		}
		for(int i = 0; i < n; i++) {
			if(isDanger(row,i)) {
				board[row][i] = 1;
				dfs(row+1);
				board[row][i] = 0;
			}
		}
	}

	private static boolean isDanger(int row, int col) {
		for(int i = 0; i < row; i++) {
			if(board[i][col] == 1) {
				return false;
			}
		}
		return true;
	}
}
