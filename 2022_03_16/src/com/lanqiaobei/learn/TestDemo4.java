package com.lanqiaobei.learn;

import java.util.*;
public class TestDemo4 {
	/**
	 * BASIC-23	VIP ‘Ã‚ –æ∆¨≤‚ ‘
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] tmp = new int[n];
		int[][] array = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				array[i][j] = sc.nextInt();
				if(array[i][j] == 1) {
					tmp[j]++;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(tmp[i] > n/2) {
				System.out.print(i+1+" ");
			}
		}	
	}
}
