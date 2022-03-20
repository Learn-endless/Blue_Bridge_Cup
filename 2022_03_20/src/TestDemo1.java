

public class TestDemo1 {
	/**
	 * 
	 */
	public static int INF = Integer.MAX_VALUE/2;
	
	public static void main(String[] args) {
		//存放图的二维矩阵
		int[][] board = new int[2100][2100];
		//标记每个节点的访问状态
		boolean[] flg = new boolean[2100];
		//保存一个点到其他点的最短距离
		int[] dist = new int[2100];
		
		createBoard(board);     //对board和dist进行初始化
		initDist(dist);
		
		dijkstra(1,board,flg,dist);    //传一个1,表示求编号 1 的点到 其它点的最短距离
		
		System.out.println(dist[2021]);//dist数组中所保存的就是 原点到所有点的最短距离
	}

	/**
	 * dijkstra
	 * @param base    原点
	 * @param board   存放着图的信息
	 * @param flg     存放每个节点的状态(是否被访问过)
	 * @param dist    存放原点到每个点的最短距离
	 */
	private static void dijkstra(int base, int[][] board, boolean[] flg, int[] dist) {
		//将原点到自生的距离初始化为 0;
		dist[base] = 0;
		//遍历除原点的其它所有的点
		for(int i = 2; i <= 2021; i++) {
			
			int ret = -1;   //记录 : 中间点的下标
			
			//这个for循环用来寻找当前节点到所用节点中,距离最短的那个点(已访问的除外)
			for(int j = 1; j <= 2021 ; j++) {
				//查看是否访问过,并且是不是第一次进入循环
				if(flg[j] == false && (ret == -1 || dist[j] < dist[ret])) {
					//记录下标
					ret = j;
				}
			}
			//更改当前寻找到的最短距离的点的状态
			flg[ret] = true;
			
			//这个循环用来更新 dist 中的最短距离(与所有的点都进行判断一下,找出最小距离)
			for(int j = 1; j <= 2021; j++) {
				//找到的最小距离 更新 到 dist 中
				dist[j] = Math.min(dist[j], dist[ret] + board[ret][j]);
			}
		}
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
