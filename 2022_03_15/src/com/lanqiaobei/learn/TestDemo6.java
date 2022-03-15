package com.lanqiaobei.learn;

import java.util.*;
public class TestDemo6 {
	/**
	 * BASIC-02	–Ú¡–«Û∫Õ
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long sum = 0l;
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println(String.valueOf(sum));
	}
}
