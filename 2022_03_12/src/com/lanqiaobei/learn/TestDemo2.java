package com.lanqiaobei.learn;

public class TestDemo2 {
	/**
	  * ú����Ŀ
	 * ����:
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
			//ͳ��ÿһ�������
			sum += i;
			//ͳ���ܹ� 100 �������
			total += sum;
		}
		System.out.println(total);
	}
}

