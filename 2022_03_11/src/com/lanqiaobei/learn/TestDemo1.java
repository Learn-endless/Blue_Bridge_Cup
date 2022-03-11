package com.lanqiaobei.learn;

/**
  * 标题：分机号
 * @author 19833
 *
 */
public class TestDemo1 {
	public static int count = 0;
	public static void main(String[] args) {
		int[] array = {9,8,7,6,5,4,3,2,1,0};
		int[] tmp = new int[3];
		dfs(array,0,tmp);
		System.out.println(count);
	}

	/**
	  * 回溯法
	 * @param array 存放 0-9 个数字的数组
	 * @param depth 位数
	 * @param tmp   存放位数的数组
	 */
	private static void dfs(int[] array, int depth,int[] tmp) {
		//如果深度 达到 了3
		if(depth == 3) {
			//检查是否符合要求
			if(checkNumber(tmp)) {
				count++;
			}
			return;
		}
		//遍历递归进去,进行组合
		for(int i = 9;i >= 0; i--) {
			tmp[depth] = i;
			dfs(array,depth+1,tmp);
			//这里需要回溯
			tmp[depth] = 0;
		}
	}

	/**
	  *  检查当前 tmp  中的数组是否 是一个符合要求的 3为数
	 * @param tmp  存放了 一个 3位数的
	 * @return     返回 一个 boolean 值
	 */
	private static boolean checkNumber(int[] tmp) {
		//第一位如果是 0 ,就说明不是一个三位数
		if(tmp[0] == 0) {
			return false;
		}
		//看看是不是 降序,并且有没有重复
		for(int i = 0; i < 2; i++) {
			if(tmp[i] <= tmp[i+1]) {
				return false;
			}
		}
		return true;
	}
}
