package com.lanqiaobei.learn;

import java.util.*;
/**
 * BASIC-30	试题 阶乘计算
 * @author 只爱吃土豆
 */
public class TestDemo7 {
	public static int Max = 2600;             //需要2600位数字才能表示 1000!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] data = new int[Max];
		data[0] = 1;                         //第一个数初始化为 1
		for(int i = 2; i <= n; i++) {
			                                 //n的阶乘,循环n次
			int number = 0;        
			int ret = 0;
			for(int j = 0; j < Max; j++) {
				number = data[j] * i + ret;  //算出当前位乘以 i 的值(加上上一次的进位)
				data[j] = number % 10;       //number的个位放到当前下标
				ret = number / 10;           //并对下一次需要进位的值进行记录
			}
		}
		
		boolean flg = false;                //用来找到数组从后往前第一个不为 0 的数
		for(int i = Max-1; i >= 0; i--) {
			if(data[i] != 0) {
				flg = true;
			}
			if(flg) {
				//从后往前,第一个不为0的数开始打印
				System.out.print(data[i]);
			}
		}	
	}
}
