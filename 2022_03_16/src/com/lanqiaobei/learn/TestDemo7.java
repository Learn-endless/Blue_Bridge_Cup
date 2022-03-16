package com.lanqiaobei.learn;

import java.util.*;

public class TestDemo7 {
	
	public static String[] numbers ={"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
    public static String[] locations = {"","","shi","bai","qian","wan","shi","bai","qian","yi","shi"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		int len = s.length();
		for(int i = 0; i < len; i++) {
			int ret = s.charAt(i)-'0';
			
			if(ret == 0) {
				if(i+1 < len && s.charAt(i+1) != '0') {
					System.out.print("ling ");
				}
			}else if(ret == 1 && (len-i == 3 || len - i == 6 || len - i == 10)) {
				System.out.print("shi ");
			}else {
				System.out.print(numbers[ret]+" "+locations[len - i]+" ");
			}
		}
	}
}
