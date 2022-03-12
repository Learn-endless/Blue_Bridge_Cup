package com.lanqiaobei.learn;

public class TestDemo2 {
	/**
	  * 煤球数目
	 * 规律:
	 * 1
	 * 1+2
	 * 1+2+3
	 * 1+2+3+4
	 * ...
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		int total = 0;
		for(int i = 1; i <= 100; i++) {
			//统计每一层的数量
			sum += i;
			//统计总共 100 层的数量
			total += sum;
		}
		System.out.println(total);
	}
}

