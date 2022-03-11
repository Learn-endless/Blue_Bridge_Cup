package com.lanqiaobei.learn;

import java.util.Arrays;
import java.util.Scanner;

public class TestDemo4 {
	
	/**
	  * 标题：表格计算
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();   //行
		int m = sc.nextInt();   //列
		
		//用来存放输入的 字符串 二维数组
		String[][] s = new String[n+1][m+1];
		//用来记录 二维数组 中对应 位置 是否已经 计算完成
		boolean[][] rl = new boolean[n+1][m+1];
		//存放计算完成后的字符串数组
		double[][] data = new double[n+1][m+1];

		//循环输入 字符串 二维数组的具体内容
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < m+1;j++) {
				s[i][j] = sc.next();
			}
		}
		
		//遍历打印 字符串 数组中每个位置的值
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < m+1; j++) {
				System.out.printf("%.2f ",f(s,i,j,rl,data));
			}
			System.out.println();
		}
		
	}
	
	/**
	 * 字符串处理函数:将对应位置的字符串 处理成一个 double 类型的数字
	 * @param s     存放字符串的数组
	 * @param i     需要处理位置的行下标
	 * @param j     列下标
	 * @param rl    记录每个位置是否处理完成
	 * @param data  存放将字符串处理成 double 类型数字的数组
	 * @return      返回处理完成的数字
	 */
	private static double f(String[][] s, int i, int j,boolean[][] rl, double[][] data) {
		//如果该位置已经被处理过了,直接返回 data 数组对应下标的值
		if(rl[i][j] == true) {
			return data[i][j];
		}
		//如果当前位置的字符串是一个数字字符串
		if(s[i][j].length() == 1) {
			//处理成 double 类型的数字,并存放到 data 数组中
			data[i][j] = Double.parseDouble(s[i][j]);
			//记录一下,已被处理
			rl[i][j] = true;
			//返回该值
			return data[i][j];
		}
		//走到这里说明不是 数字字符,先记录下,已被处理
		rl[i][j] = true;
		//将这个位置的字符串分割开来
		String[] str = s[i][j].split(":|,|\\(|\\)");
		//拿到里面的坐标
		int a1 = Integer.parseInt(str[1]);
		int a2 = Integer.parseInt(str[2]);
		int b1 = Integer.parseInt(str[3]);
		int b2 = Integer.parseInt(str[4]);
		
		//计算上面坐标之间元素的 sum 与 avg
		double sum = 0;
		double avg = 0;
		int count = 0;   //统计坐标之间的元素个数
		for(int x = a1; x <= b1;x++) {
			for(int y = a2; y <= b2; y++) {
				//递归进行求每个位置的值
				sum += f(s,x,y,rl,data);
				count++;
			}
		}
		//算出 avg(平均值)
		avg = sum/count;
		//根据 SUM(和) , AVG(平均值), STD(标准差)
		if(str[0].equals("SUM")) {
		
			return data[i][j] = sum;
		}else if(str[0].equals("AVG")) {
			
			return data[i][j] = avg;
		}else {
			//先求方差: 每个数据与平均值的差的平方的平均值.
			double sumA = 0;
			for(int x = a1; x <= b1;x++) {
				for(int y = a2; y <= b2; y++) {
					sumA += Math.pow(avg-f(s,x,y,rl,data),2);
				}
			}
			//求出 标准差 : 方差的平方根
			return Math.sqrt(sumA/count);
		}
	}

	public static void main1(String[] args) {
		String[][] array = new String[3][3];
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < array[i].length; i++) {
			for(int j = 0; j < array.length; j++) {
				array[i][j] = sc.next();
			}
		}
		
		array[2][2] = "123";
		System.out.println(Arrays.deepToString(array));
		
		String s = "SUM(2,1:3,1)";
		String[] str = s.split("\\(|,|:|\\)");//每个参数之间用|隔开
		                                      //像？.(点)（（正括弧））（反括弧）*（星号）|（竖线）等特殊符号都要在其前面加上\\。
		for(String x:str) {
			System.out.println(x);
		}
	}
}
