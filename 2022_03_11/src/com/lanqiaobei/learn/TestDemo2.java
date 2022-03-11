package com.lanqiaobei.learn;

/**
 * 标题：五星填数
 * @author 19833
 *
 */
public class TestDemo2 {
	public static int count = 0;
	public static void main(String[] args) {
		//用来标记哪些数字可以使用
		boolean[] tmp = new boolean[13];
		tmp[7] = true;       //7和11不能使用
		tmp[11] = true;
		
		//用来存放每一组的 11 个数字
		int[] array = new int[11];
		//使用 dfs回溯算法
		dfs(0,tmp,array);
		
		System.out.println(count/10);  //因为可以旋转 5 次,每次旋转后还有 一个 镜像 ,所以总的次数 /10
		
	}

	/**
	 * dfs 回溯算法
	 * @param depth  深度
	 * @param tmp    存放 1 - 12数字是否使用的情况
	 * @param array  存放每组符合题目要求的数组
	 */
	private static void dfs(int depth, boolean[] tmp, int[] array) {
		if(depth == 10) {
			//深度满足(每一个空都赋值了),检查这组数是否符合要求
			if(check(array)) {
				//计数
				count++;
			}
			return;
		}
		//还有位子是 空的 ,继续向下递归
		for(int i = 1 ; i <=12 ; i++ ) {
			//查看当前想要存放的数,是否已经被使用
			if(tmp[i] == false) {
				//放进去
				array[depth] = i;
				//标记已被使用
				tmp[i] = true;
				//递归下一空,准备填放数字
				dfs(depth+1,tmp,array);
				//进行回溯,还原
				array[depth] = 0;
				tmp[i] = false;
			}
		}
	}

	/**
	 * 检查当前这组数是否符合题目要求
	 * @param a  一组数字
	 * @return   返回 true 和 false
	 */
	private static boolean check(int[] a) {
		int a1 = a[0]+a[2]+a[5]+a[8];
		int a2 = a[0]+a[3]+a[6]+a[9];
		int a3 = a[1]+a[2]+a[3]+a[4];
		int a4 = a[1]+a[5]+a[7]+a[9];
		int a5 = a[4]+a[6]+a[7]+a[8];
		if(a1 == a2 && a2 == a3 && a3 == a4 && a4 == a5) {
			return true;
		}
		return false;
	}
}
