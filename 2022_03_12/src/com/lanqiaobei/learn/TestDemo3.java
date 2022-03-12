package com.lanqiaobei.learn;

public class TestDemo3 {
	/** 
          *  生日蜡烛
	 * @param args
	 */
	public static void main(String[] args) {
		// 从 0 岁开始尝试,假设最大是从 100岁开始吹蜡烛的
		for(int i = 0; i <= 100; i++) {
			int total = 0;   //统计总共吹的蜡烛
			//总数小于 236 时,继续往后 统计
			for(int j = i; total < 236; j++) {	
				total += j;
			}
			//判断 total 是不是刚刚好 是 236
			if(total == 236) {
				//答案就是它
				System.out.println("answer:::"+i);
				break;
			}
		}
	}
}
