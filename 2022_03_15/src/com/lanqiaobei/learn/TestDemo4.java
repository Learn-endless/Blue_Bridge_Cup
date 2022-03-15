package com.lanqiaobei.learn;

import java.util.*;
public class TestDemo4 {
	/**
	 * BASIC-04	FibonacciÊýÁÐ
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int a = 1;
		int b = 1;
		int c = 1;
		if(n != 1 || n != 2) {
			for(int i = 3; i <= n; i++) {
				c = (a + b) % 10007;
				a = b%10007;
				b = c;
			}
		}
		System.out.println(c);
	}
}
