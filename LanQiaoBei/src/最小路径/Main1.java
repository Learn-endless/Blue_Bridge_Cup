package 最小路径;
/**
 * 小蓝学习了最短路径之后特别高兴，他定义了一个特别的图，希望找到图 中的最短路径。

小蓝的图由 2021 个结点组成，依次编号 1 至 2021。

对于两个不同的结点 a, b，如果 a 和 b 的差的绝对值大于 21，则两个结点 之间没有边相连；如果 a 和 b 的差的绝对值小于等于 21，则两个点之间有一条 长度为 a 和 b 的最小公倍数的无向边相连。

例如：结点 1 和结点 23 之间没有边相连；结点 3 和结点 24 之间有一条无 向边，长度为 24；结点 15 和结点 25 之间有一条无向边，长度为 75。

请计算，结点 1 和结点 2021 之间的最短路径长度是多少。
 */
public class Main1 {
	public static int INF = Integer.MAX_VALUE/2;
	
	public static void main(String[] args) {
		
	}
	

	/**
	  * 对 dist 数组进行初始化
	 * @param dist
	 */
	private static void initDist(int[] dist) {
		for(int i = 0; i < dist.length; i++) {
			dist[i] = INF;
		}
	}
	
	
	/**
	  * 初始化图
	 * @param board
	 */
	public static void createBoard(int[][] board) {
		for(int i = 1; i <= 2021; i++) {
			for(int j = 1; j <= 2021; j++) {			
				if(i == j) {
					board[i][j] = 0;
				}else if(Math.abs(i-j) > 21) {
					board[i][j] = INF;
				}else {
					board[i][j] = lcm(i,j);
				}
			}
		}
	}
		
	/**
	  * 求出两个整数的最大公约数
	 * @param a
	 * @param b
	 * @return
	 */
	public static int gcd(int a,int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b,a%b);
	}
	
	/**
	  * 求出两个数的最小公倍数
	 * @param a
	 * @param b
	 * @return
	 */
	public static int lcm(int a,int b) {
		return a*b/gcd(a,b);
	}
}
