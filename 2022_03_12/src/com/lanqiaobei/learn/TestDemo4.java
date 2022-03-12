package com.lanqiaobei.learn;

/**
  * 凑算式
 * @author 只爱吃土豆
 *
 */
public class TestDemo4 {
	//用来统计有几组数
	public static int count = 0;
	public static void main(String[] args) {
		//用来标记 1 - 9 数字是否被使用
		boolean[] flg = new boolean[10];
		//用来存放每一组的9个数字(下标0的空间不使用,从1下标开始)
		int[] number = new int[10];
		//递归求解
		dfs(1, number, flg);
		System.out.println(count);
	}

	/**
	  *  回溯算法
	 * @param total
	 * @param number
	 * @param flg
	 */
	private static void dfs(int total, int[] number, boolean[] flg) {
		//递归终止条件:每找到 9 个数,检查一下
		if(total == 10) {
			if(checkNumber(number)) {
				//满足题目要求,统计+1
				count++;
			}
			//结束当前递归
			return;
		}
		//循环尝试放数字 1 - 9
		for(int i = 1; i <= 9; i++) {
			//先检查当前数字是否已经使用
			if(flg[i] == false) {
				//没有使用,进入循环,并将当前数字状态标记为 已使用
				flg[i] = true;
				//将数字放到 number 里面去
				number[total] = i;
				//进行递归 , 找下一个数字
				dfs(total+1,number,flg);
				//进行回溯,标记为 未使用
				flg[i] = false;
			}
		}
	}

	/**
	  * 检查 当前这组数字是否满足 题目要求
	 * @param number
	 * @return
	 */
	private static boolean checkNumber(int[] number) {
		// 题目要求: A+B/C+DEF/GHI == 10
		double a = number[1];                               //A
		double b = 1.0*number[2]/number[3];                 //B/C
		double x = number[4] * 100+number[5] * 10+number[6];//DEF
		double y = number[7] * 100+number[8] * 10+number[9];//GHI
		double c = x/y;                                     //DEF/GHI
		if(a+b+c == 10.0) {
			//判断 A+B/C+DEF/GHI 是否等于 10
			return true;
		}
		return false;
	}
}
