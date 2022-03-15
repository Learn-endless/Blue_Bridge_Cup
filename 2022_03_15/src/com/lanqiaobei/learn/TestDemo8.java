package com.lanqiaobei.learn;

import java.util.*;
public class TestDemo8 {
	/**
	 * BASIC-29	VIP试题 高精度加法
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.next();
		String s2 = sc.next();
		
		int[] a = new int[105];
		int[] b = new int[105];
		int[] c = new int[105];
		
		int a1 = 0;
		int b1 = 0;
		for(int i = s1.length()-1; i >= 0; i--) {
			a[a1++] = s1.charAt(i)-'0';
		}
		for(int i = s2.length()-1; i >= 0; i--) {
			b[b1++] = s2.charAt(i)-'0';
		}
		int ret = 0;
		for(int i = 0; i < 105; i++) {
			int number = a[i] + b[i] + ret;
			c[i] = number % 10;
			ret = number / 10;
		}
		
		boolean flg = false;
		for(int i = 104; i >= 0; i--) {
			if(c[i] != 0) {
				flg = true;
			}
			if(flg) {
				System.out.print(c[i]);
			}
		}
	}
}
