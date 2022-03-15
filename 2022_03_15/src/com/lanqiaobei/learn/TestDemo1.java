package com.lanqiaobei.learn;

import java.util.*;
public class TestDemo1 {
	/**
	 * BASIC-3	×ÖÄ¸Í¼ÐÎ
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] ch = new char[n][m];
		for(int i = 0; i < m; i++) {
			ch[0][i] = (char) ('A'+i);
		}
		
		for(int i = 1; i < n; i++) {
			ch[i][0] = (char) ('A'+ i);
			for(int j = 1; j < m; j++) {
				ch[i][j] = ch[i-1][j-1];
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(ch[i][j]);
			}
			System.out.println();
		}
	}
}
