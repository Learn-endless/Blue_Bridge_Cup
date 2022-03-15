package com.lanqiaobei.learn;

import java.util.*;
public class TestDemo5 {
	/**
	 * BASIC-03	Ô²µÄÃæ»ý
	 */
	public static double PI = 3.14159265358979323;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		double circular_s = PI * Math.pow(n,2);
		System.out.printf("%.7f\n",circular_s);
	}
}
