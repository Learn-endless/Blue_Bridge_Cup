package com.lanqiaobei.learn;

import java.util.*;
public class TestDemo6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = Sn(n);
		System.out.println(s);
	}
	
	private static String Sn(int n) {
		StringBuilder s = new StringBuilder();
		String t = An(1);
		if(n > 2) {
			s.append("((");
		}
		if(n == 2) {
			s.append("(");
		}
		for(int i = 0; i < n; i++) {
			String str = An(i+1);
			s.append(str+"+");
			s.append((char)('0'+n-i));
			if(i+1 != n) {
				s.append(")");
			}
		}
		return s.toString();
	}

	public static String An(int n) {
		StringBuilder s = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			s.append("sin(");
			s.append((char)('0'+ i));
			if(i == n) {
				s.append(")");
				int ret = i-1;
				while(ret > 0) {
					s.append(")");
					ret--;
				}
			}else {
				if(i % 2 == 1) {
					s.append("-");	
				}else {
					s.append("+");
				}
			}
		}
		return s.toString();
	}
}
