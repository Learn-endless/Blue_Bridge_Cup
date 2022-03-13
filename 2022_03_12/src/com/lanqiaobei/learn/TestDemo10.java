package com.lanqiaobei.learn;

import java.util.Arrays;
import java.util.Scanner;

/**
  * 四平方和
 * @author 19833
 *
 */
public class TestDemo10 {
	//存放 四平方和的数字
	public static int[] tmp = new int[4];
	//找到第一个后,标识一下
	public static boolean flg;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//循环输入
		while(sc.hasNextInt()) {
			int input = sc.nextInt();
			//求出它的 算术平方根
			int n = (int) Math.sqrt(input);
			//由于 flg 是个静态成员变量,所以在这里初始化下
			flg = false;
			//开始 递归寻找 数字
			dfs(0,input,n);
			System.out.println(tmp[0]+" "+tmp[1]+" "+tmp[2]+" "+tmp[3]);
		}
		
	}

	/**
	  * 用来寻找平方和数字
	 * @param depth   记录寻找到的数字
	 * @param input   输入的数
	 * @param n       最大能够尝试的数字
	 */
	private static void dfs(int depth, int input, int n) {
		//找到了 4 个数
		if(depth == 4) {
			//检查 四平方 和 是不是 等于 input
			if(check(input)) {
				//排升序
				Arrays.sort(tmp);
				//标记下
				flg = true;
			}
			return;
		}
		//如果有一次递归进来标记是 true,表示已经找到了,直接返回
		if(flg == true) {
			return;
		}
		//循环尝试 0 - n 的数字
		for(int i = 0; i <= n; i++) {
			//判断找到第一组没有
			if(flg == true) {
				return;
			}else {
				//将这个数字 放到 tmp 中去
				tmp[depth] = i;
				//递归寻找下一个数字
				dfs(depth+1,input,n);
			}
		}
	}

	/**
	  * 检查当前的 四个数字 能不能满足 四平发和 == input
	 * @param input  输入的数字
	 * @return       返回 true 和 false
	 */
	private static boolean check(int input) {
		int ret = (int) (Math.pow(tmp[0], 2)+Math.pow(tmp[1], 2)+Math.pow(tmp[2], 2)+Math.pow(tmp[3], 2));
		if(ret == input) {
			return true;
		}
		return false;
	}
}
