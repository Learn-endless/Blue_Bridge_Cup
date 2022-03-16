package com.lanqiaobei.learn;

import java.util.*;
/**
 * BASIC-25	VIP试题 回形取数
 * @author 19833
 *
 */
public class TestDemo2 {
	
	public static int n;    //行
	public static int m;    //列
	
	public static int[][] array; 
	
	public static int minN = -1;
	public static int minM = -1;
	public static int maxN;
	public static int maxM;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		maxN = n;
		maxM = m;
		
		array = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		
		down(0,0);
	}

	private static void down(int row, int col) {
		minM = col; 
		if(minM >= maxM || row >= maxN) {
			return;
		}
		while(row < maxN) {
			System.out.print(array[row++][col]+" ");
		}
		right(maxN-1,minM+1);
	}

	private static void right(int row, int col) {
		maxN = row;
		if(minN >= maxN || col >= maxM) {
			return;
		}
		while(col < maxM) {
			System.out.print(array[row][col++]+" ");
		}
		up(maxN-1,maxM-1);
	}

	private static void up(int row, int col) {
		maxM = col;
		if(minM >= maxM || row <= minN) {
			return;
		}
		while(row > minN) {
			System.out.print(array[row--][col]+" ");
		}
		left(minN+1,maxM-1);
	}

	private static void left(int row, int col) {
		minN = row;
		if(minN >= maxN || col <= minM) {
			return;
		}
		while(col > minM) {
			System.out.print(array[row][col--]+" ");
		}
		down(minN+1,minM+1);
	}
}
