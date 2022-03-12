package com.lanqiaobei.learn;

public class TestDemo6 {
	/**
	 * dfs算法
	 * @param a 存放国家和每个国家派出最大人数的信息
	 * @param k 存放当前拜访到第几个国家了
	 * @param n 当前观察团还有几个人数空位
	 * @param s 存放每组观察团的人员
	 */
	public static void f(int[] a, int k, int n, String s)
	{
		//递归结束条件 : 每个国家都问过
		if(k==a.length){ 
			//考察团人数已满,打印这一组的人员
			if(n==0) System.out.println(s);
			return;
		}
		
		String s2 = s; //将当前已确定的人员存放到 s2 中
		for(int i=0; i<=a[k]; i++){
			f(a,k+1,n-i,s2);   //填空位置
			s2 += (char)(k+'A');
		}
	}
	
	public static void main(String[] args)
	{
		//有六个国家,对应数组的个数.
		//数组的内容对应每个国家所能 派出的最大人数
		int[] a = {4,2,2,1,1,3};
		
		//传5是因为 观察团 的组成人数 最多为 5 个
		f(a,0,5,"");
	}
}
