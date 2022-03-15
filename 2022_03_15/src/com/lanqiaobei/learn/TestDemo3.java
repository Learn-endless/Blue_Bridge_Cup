package com.lanqiaobei.learn;

import java.util.*;
public class TestDemo3 {
	/**
	 * BASIC-1	ÈòÄêÅĞ¶Ï
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		if(input % 400 == 0 || input % 4 == 0 && input % 100 != 0) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
		
	}
}
