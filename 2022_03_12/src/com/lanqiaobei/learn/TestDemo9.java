package com.lanqiaobei.learn;

public class TestDemo9 {
	/**
	  * 标题：方格计数
	 * @param args
	 */
	public static void main(String[] args) {
		//圆的半径
		int r = 1000;
		//统计次数
		int count = 0;
		//遍历每个格子
		for(int i = 1; i <= r; i++) {
			for(int j = 1; j <= r; j++) {
				//如果当前格子的右上角的点到原点的距离 <= r
				if(i*i+j*j <= r*r) {
					//进行统计
					count++;
				}
			}
		}
		//由于上面只求出了四分之一的方块,这里需要 *4
		System.out.println(count*4);
	}
}
