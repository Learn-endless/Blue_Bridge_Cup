package com.lanqiaobei.learn;

public class TestDemo2 {
	/**
	 * BASIC-2	01×Ö´®
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i = 0; i < 32; i++) {
			StringBuilder s = new StringBuilder();
			int n = i;
			while(n != 0) {
				s.insert(0, n % 2);
				n /= 2;
			}
			while(s.length() < 5) {
				s.insert(0, 0);
			}
			System.out.println(s.toString());
		}
	}
}
