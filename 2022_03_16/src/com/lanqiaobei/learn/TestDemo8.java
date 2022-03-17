package com.lanqiaobei.learn;

import java.util.*;
public class TestDemo8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String s = sc.next();
		
		char[] ch = s.toCharArray();
		int count = 0;
		int w = n;
		boolean flg = false;
		for(int i = 0; i <= w/2 ;i++) {
			for(int j = n-1; j >= i; j--) {
				if(i == j) {
					if(flg == true || w % 2 == 0) {
						System.out.println("Impossible");
						return;
					}
					flg = true;
					count += w / 2 - i;
				}else if(ch[i] == ch[j]) {
					for(int k = j; k < n-1; k++) {
						swap(ch,k,k+1);
						count++;
					}
					n--;
					break;
				}
			}
		}
		System.out.println(count);
	}

	private static void swap(char[] ch, int k, int i) {
		char tmp = ch[k];
		ch[k] = ch[i];
		ch[i] = tmp;
	}
}
