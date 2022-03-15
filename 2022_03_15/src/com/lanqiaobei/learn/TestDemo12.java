package com.lanqiaobei.learn;

import java.util.Scanner;

public class TestDemo12 {
	/**
	 * 2n»Êºó
	 * @param args
	 */
	public static int n;
	public static int[][] board;
	public static int[][] check;
	public static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		board = new int[n][n];
		check = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				check[i][j] = sc.nextInt();
			}
		}
		
		dfs(0);
		System.out.println(count);
	}


	private static void dfs(int row) {
		if(row == n) {
			dfs1(0);
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


	private static void dfs1(int row) {
		if(row == n) {
			count++;
//			System.out.println("µÚ"+count+"ÖÖ>>>");
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < n; j++) {
//					System.out.print(board[i][j]+" ");
//				}
//				System.out.println();
//			}
			return;
		}
		for(int i = 0; i < n; i++) {
			if(isDanger1(row,i)) {
				board[row][i] = 2;
				dfs1(row+1);
				board[row][i] = 0;
			}
		}
	}


	private static boolean isDanger1(int row, int col) {
		if(board[row][col] == 1) {
			return false;
		}
		if(check[row][col] == 0) {
			return false;
		}
		for(int i = 0; i < row; i++) {
			if(board[i][col] == 2) {
				return false;
			}
			for(int j = 0; j < n; j++) {
				if(((row+col) == (i+j) || (row-col)==(i-j))&&board[i][j] == 2) {
					return false;
				}
			}
		}
		return true;
	}


	private static boolean isDanger(int row, int col) {
		if(check[row][col] == 0) {
			return false;
		}
		for(int i = 0; i < row; i++) {
			if(board[i][col] == 1) {
				return false;
			}
			for(int j = 0; j < n; j++) {
				if(((row+col)==(i+j)||(row-col)==(i-j))&&board[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
