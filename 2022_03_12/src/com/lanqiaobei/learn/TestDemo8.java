package com.lanqiaobei.learn;

/**
  * 剪邮票
 * @author 只爱吃土豆
 *
 */
public class TestDemo8 {
	//用来存放每一次剪下的五张邮票
	public static int[] tmp = new int[5];
	//存放原来的整张邮票
	public static int[][] stamp = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
	
	//记录每一组要剪下的 五张邮票的状态 (1号-12号)邮票
	public static boolean[] t = new boolean[13];	
	//每剪下一张,就用 w 数组记录当前 邮票 的状态(是否已剪)
	public static boolean[] w = new boolean[13];
	
	//统计剪的次数
	public static int depth = 0;
	//这是一个标记(每组邮票符合要求返回 true,反之返回 false)
	public static boolean label = false;
	
	public static void main(String[] args) {
		//统计方案次数
		int count = 0;
		//用枚举列举出 a b c d e 五张邮票的所有组合
		int a,b,c,d,e;
		for(a = 1; a <= 12 ;a++) {
			for(b = a+1; b <= 12 ;b++) {
				for(c = b+1; c <= 12 ;c++) {
					for(d = c+1; d <= 12 ;d++) {
						for(e = d+1; e <= 12 ;e++) {
							//将当前选中的邮票依次存放到 tmp 数组中
							tmp[0] = a;
							tmp[1] = b;
							tmp[2] = c;
							tmp[3] = d;
							tmp[4] = e;
							//在 t 数组中将 当前这五张邮票的状态锁定(置为true)
							changeStatusT();
							//检查这五张邮票是否能连接在一起
							if(check()) {
								//计数
								count++;
							}
							//对 t 数组进行初始化为 false,准备下一组邮票的检查
							initT();
						}
					}
				}
			}
		}
		System.out.println(count);
	}
	
	/**
	  * 锁定当前 五 张邮票的状态
	 */
	private static void changeStatusT() {
		for(int i = 0; i < 5; i++) {
			t[tmp[i]] = true;
		}
	}

	/**
	  * 将 t 数组置为初始状态.
	 */
	private static void initT() {
		for(int i = 0; i < 5; i++) {
			t[tmp[i]] = false;
		}
	}

	/**
	  * 初始化 w 数组(w:每剪一张,记录下邮票的状态)
	 */
	private static void initW() {
		for(int i = 0; i < 13;i++) {
			w[i] = false;
		}
	}

	/**
	  * 检查当前这组 邮票 是否相邻连接在一起
	 * @return
	 */
	private static boolean check() {
		//初始化一下标记
		label = false;  
		//初始化当前剪的次数
		depth = 0;
		//初始化 w 数组(置为false,表示所有的邮票都没被剪过)
		initW();
		
		//结束循环的条件
		boolean flg = false;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				//如果在 stamp 中找到第一张邮票,将下标传给 dfs,让它递归检测.
				if(stamp[i][j] == tmp[0]) {
					//在dfs中如果确定了满足要求,就会将 label 置为 true.
					dfs(i,j);
					flg = true;
					break;
				}
			}
			if(flg) break;
		}
		//返回判断结果
		return label;	
	}
	
	/**
	  * 从当前下标往四周开始剪邮票
	 * @param x  行
	 * @param y  列
	 */
	private static void dfs(int x, int y) {
		//递归结束条件,剪了五次,说明每张都被剪出来了
		if(depth == 5) {
			//标记为 满足要求
			label = true;
			return;
		}
		
		//判断当前剪的邮票是否在 当前这组邮票里,并且 还没有被剪过
		if(t[stamp[x][y]] == true && w[stamp[x][y]] == false) {
			//标记为 被剪了 状态
			w[stamp[x][y]] = true;
			//剪邮票的次数 +1
			depth++;
			//判断上面能不能剪
			if(x-1 >= 0) {
				dfs(x-1,y);
			}
			//下面能不能剪
			if(x+1 <= 2) {
				dfs(x+1,y);
			}
			//左边能不能剪
			if(y-1 >= 0) {
				dfs(x,y-1);
			}
			//右边能不能剪
			if(y+1 <= 3) {
				dfs(x,y+1);
			}
		}
	}
}
