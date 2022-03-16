package com.lanqiaobei.learn;

/**
 * BASIC-22	VIP试题 FJ的字符串
 * 
 * 　FJ在沙盘上写了这样一些字符串：
　　A1 = “A”
　　A2 = “ABA”
　　A3 = “ABACABA”
　　A4 = “ABACABADABACABA”
 * @author 19833
 *
 */
import java.util.*;
public class TestDemo5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		StringBuilder s = new StringBuilder();
		s.append("A");
		
		for(int i = 2; i <= n; i++) {
			StringBuilder str = new StringBuilder(s);
			s.append((char)('A'+ i-1));
			s.append(str);
		}
		
		System.out.println(s.toString());
	}
}
