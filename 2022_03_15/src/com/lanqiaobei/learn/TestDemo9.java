package com.lanqiaobei.learn;

import java.util.*;
public class TestDemo9 {
	/**
	 * BASIC-28	VIP ‘Ã‚ Huffuman ˜
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		PriorityQueue<Integer> p = new PriorityQueue<>();
		
		for(int i = 0; i < input; i++) {
			p.offer(sc.nextInt());
		}
		int sum = 0;
		while(p.size() > 1) {
			int a = p.poll();
			int b = p.poll();
			int ret = a+b;
			sum += ret;
			p.offer(ret);
		}
		System.out.println(sum);
	}
}
