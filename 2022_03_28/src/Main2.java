import java.util.*;
public class Main2 {
	/**
	  * 给一个二维矩阵，求从左上角到右下角的最小路径和
	  * 规定：只能往右走，或者往下走
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		  * 状态定义：从上往下，从左往右依次比较到达F[i][j]的点的路径和中的最小的一个，然后加上 F[i][j]
		  * 状态转移方程：F[i][j] = Math.min(F[i-1][j],F[i][j-1])+F[i][j]
		  *         注意还有其他情况：
		  *                         当 i = 0 时，F[0][j] = F[0][j-1]+F[0][j]
		  *                         当 j = 0 时，F[i][0] = F[i-1][j]+F[i][0]
		  * 初始化：F[0][0] = 0
		  * 返回结果：F[row-1][col-1]
		 */
		
		int[][] F = {{0,2,5,7},{1,2,7,5},{9,1,2,4}};   //随便给一个二维矩阵，里面存放着各自的距离
		
		F[0][0] = 0;     //初始状态：自己到自己的距离为 0
		
		int n = F.length;
		int m = F[0].length;
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < m; j++) {
				if(i == 0) {
					F[i][j] = F[i][j-1]+F[i][j];
				}else if(j == 0) {
					F[i][j] = F[i-1][j]+F[i][j];
				}else {
					F[i][j] = Math.min(F[i-1][j],F[i][j-1])+F[i][j];
				}
			}
		}
		System.out.println(F[n-1][m-1]);
	}
	
	/**
	  * 给一个二维矩阵，求从左上角到右下角的路径总数
	  * 规定：只能往右走，或者往下走
	 * @param args
	 */
	public static void main6(String[] args) {
		/*
		  * 状态定义：从上往下，从左往右依次统计到达F[i][j]的点的路径总数
		  * 状态转移方程：F[i][j] = F[i-1][j]+F[i][j-1]
		  * 初始化：F[0][j] = 1 , F[i][0] = 1;
		  * 返回结果：F[row-1][cul-1]
		 */
		
		int[][] F = new int[3][4];
		int n = F.length;
		int m = F[0].length;
		for(int i = 0; i < m; i++) {
			F[0][i] = 1;
		}
		for(int i = 1; i < n; i++) {
			F[i][0] = 1;
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < m; j++) {
				
				F[i][j] = F[i-1][j]+F[i][j-1];
			}
		}
		
		System.out.println(F[n-1][m-1]);
	}
	
	/*
	 *     2
	 *     3  4
	 *     6  5  7
	 *     4  1  8  3
	  *     求三角形从顶部到底部的最短路径和
	 */
	public static void main5(String[] args) {
		int[][] F = {{2},{3,4},{6,5,7},{4,1,8,3}};	
		/*
		  * 自底向上
		  * 分析：求整个三角形从顶到底的最小路径和
		  * 状态定义：求第F[i][j]到 F[i+1][j]的最小路径之和
		  * 状态转移方程：F[i][j] = Min(F[i+1][j],F[i+1][j])+F[i][j]    (没有其他情况)
		  * 状态初始化：最后一行的元素为已知条件
		  * 返回结果：    顶端元素的值就是结果
		 */
		
		int n = F.length;
		for(int i = n-2; i >= 0; i--) {
			for(int j = 0; j <= i; j++) {
				F[i][j] = Math.min(F[i+1][j], F[i+1][j+1])+F[i][j];
			}
		}
		System.out.println(F[0][0]);
	}
	/*
	 *     2
	 *     3  4
	 *     6  5  7
	 *     4  1  8  3
	  *     求三角形从顶部到底部的最短路径和
	 */
	public static void main4(String[] args) {
		int[][] F = {{2},{3,4},{6,5,7},{4,1,8,3}};
		/*
		  * 自定向下
		  * 分析：求整个三角形从顶到底的最小路径和
		  * 状态定义：求第F[i][j]到 F[i+1][j]的最小路径之和
		  * 状态转移方程：F(i) = Min(F[i-1][j],F[i-1][j-1])+F[i][j];
		  * 注意：这个状态转移方程有其他的情况 ：
		  *     当  j = 0  时：F[i][j] = F[i-1][j]+F[i][j]
		  *     当  j = i 时：F[i][j] = F[i-1][j-1]+F[i][j]
		  * 状态初始化：顶端元素为已知条件
		  * 返回结果：最后一行中的最小值
		 */	
		int n = F.length;
		for(int i = 1; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0) {
					F[i][j] = F[i-1][j] + F[i][j];
					
				}else if(j == i) {
					F[i][j] = F[i-1][j-1] + F[i][j];
					
				}else {
					F[i][j] = Math.min(F[i-1][j], F[i-1][j-1]) + F[i][j];
				}
			}
		}
		int min = F[n-1][0];
		for(int i = 1; i < F[n-1].length; i++) {
			min = Math.min(F[n-1][i], min);
		}
		System.out.println(min);
	}
	
	/**
	  * 判断一个字符串能不能用 dict 中的单词分割
	 * @param s      待分割的字符串
	 * @param dict   存放单词的字典
	 * @return       返回一个boolean值
	 */
	public static boolean wordBreak(String s, Set<String> dict) {
		//状态的定义：求前 i 个字符能不能被 分割
		boolean[] F = new boolean[s.length()+1];     //F(0)是一个辅助状态，所以需要创建一个  s.length()+1 大小的数组
		
		//初始化值
		F[0] = true;
		
		//循环解决前 i 个字符能否被分割的问题
		for(int i = 1; i <= s.length(); i++) {
			//状态转移方程 ： j < i && F(j) && F(j+1,i)来判断前i个字符能不能被分割
			for(int j = 0; j < i; j++) {
				if(F[j] && dict.contains(s.substring(j, i))) {   //为什么是 j ，而不是 j+1，因为F(0)只是一个
					//辅助状态，用来帮助我们 使转移方程 能递推下去，本质上 j = 0 指向的就是 第一个 字符(辅助状态就在这个字符的前面)。                          
					F[i] = true;
					//只要有一种分割方案，就结束本次循环
					break;
				}
			}
		}
		return F[s.length()];
	}
	
	public static void main3(String[] args) {
		String s = "leetcode";
		Set<String> set = new HashSet<>();
		set.add("leet");
		set.add("code");
		boolean flg = wordBreak(s,set);
		System.out.println(flg);
	}
	
	public static void main2(String[] args) {
		//对下面的求斐波那契数列第n的程序进行 空间上的优化
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int fn = -1;
		int f0 = 0;
		int f1 = 1;
		
		for(int i = 2; i <= n; i++) {
			fn = f0+f1;
			f0 = f1;
			f1 = fn;
		}
		System.out.println(fn);
	}
	
	public static void main1(String[] args) {
		/*
		  * 使用动态规划来分析 斐波那契数列 第n项
		 * 1.状态定义：求出F(n-1)项的斐波那契数？
		 * 2.转移方程：F(n) = F(n-1) + F(n-2)
		 * 3.初始化 ：   F(0) = 0;  F(1) = 1;
		 * 4.返回结果：F(n); 
		 */
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] F = new int[n+1];     //从第0项开始
		
		F[0] = 0;
		F[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			F[i] = F[i-1]+F[i-2];
		}
		System.out.println(F[n]);
	}
}
