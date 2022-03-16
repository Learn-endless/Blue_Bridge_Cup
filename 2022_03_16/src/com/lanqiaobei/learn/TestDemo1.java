package com.lanqiaobei.learn;

import java.util.*;
public class TestDemo1 {
	/**
	 * BASIC-26	VIP试题 报时助手
	 */
	public static String[] hour = {"zero","one", "two", "three", "four", 
			"five", "six", "seven", "eight", "nine", "ten", "eleven",
			"twelve", "thirteen", "fourteen", "fifteen", "sixteen", 
			"seventeen", "eighteen", "nineteen", "twenty","1","1","1"
			,"1","1","1","1","1","1","thirty","1","1","1","1","1","1"
			,"1","1","1","forty","1","1","1","1","1","1","1","1","1","fifty"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		StringBuilder s = new StringBuilder();

		if(n > 20) {
			int ret = n % 10;
			s.append(hour[20]+" ");
			s.append(hour[ret]+" ");
		}else {
			s.append(hour[n]+" ");
		}
		
		if(m == 0) {
			s.append("o'clock");
		}else {
			if(m <= 20) {
				s.append(hour[m]);
			}else {
				
				int ret = m % 10;
				s.append(hour[m-ret]);
				if(ret != 0) {
					s.append(" "+hour[ret]);
				}
			}
		}
		System.out.println(s.toString());
	}
}
