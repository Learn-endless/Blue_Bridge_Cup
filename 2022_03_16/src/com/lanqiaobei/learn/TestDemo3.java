package com.lanqiaobei.learn;

import java.util.*;
public class TestDemo3 {
	/**
	 * BASIC-24	VIP ‘Ã‚ πÍÕ√»¸≈‹‘§≤‚
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();
		
		int t = sc.nextInt();
		int s = sc.nextInt();
		int l = sc.nextInt();
		
		int tmp = s;
		
		int count = 0;
		int l1 = 0;
		int l2 = 0;
		boolean flg = false;
		while(l1 < l && l2 < l) {
			count++;
			if(l1 - l2 >= t) {
				flg = true;
			}
			l2 += v2;
			if(flg && s != 0) {
				s--;
				continue;
			}
			if(s == 0) {
				flg = false;
				s = tmp;
			}
			l1 += v1;
		}
		if(l1 >= l && l2 >= l) {
			System.out.println("D");
		}else if(l1 >= l) {
			System.out.println("R");
		}else if(l2 >= l) {
			System.out.println("T");
		}
		
		System.out.println(count);
	}
}
