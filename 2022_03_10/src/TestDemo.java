import java.util.Scanner;
/**
 * 垒骰子
 * @author 只爱吃土豆
 *
 */
public class TestDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextInt();       //表示骰子的个数
		int m = sc.nextInt();        //表示互斥面的组数(两个互斥面为一组)
		
		boolean[][] b = new boolean[7][7];   //用来存放互斥面的信息
		int[] shaiZi = {0,4,5,6,1,2,3};      //根据题目来确定骰子 6 面的点数:
		                                     //shaiZi[i] == j : i的对面是j
		                                     //1 的对面是 4，2 的对面是 5，3 的对面是 6。
		for(int i = 0;i < m; i++) {
			int x = sc.nextInt();   //a面
			int y = sc.nextInt();   //b面
			//将互斥面的关系存放到 b 数组中
			b[x][y] = true; 
			b[y][x] = true;        //如果 1 和 2是互斥面,那么 2 和 1也是互斥面
		}
		
		int e = 0;               //一个指针指向 dp的行下标,用于在 dp[0]和dp[1]之间反转  
		
		//创建一个滚动数组,当骰子的高度为 1 时,每个面的方案数为 1 ,(旋转的4个面是最后再乘上去的)
		long[][] dp = new long[2][7];
		for(int i = 1; i < 7; i++) {
			dp[0][i] = 1;
		}

		//只有从两个骰子开始才能 垒起来
		for(long i = 2; i <= n; i++) {       //几个骰子,几个循环
			e = 1 - e;         //使它跟随 层数 反转(0,1)之间.

			for(int j = 1; j < 7; j++) {     //遍历当前骰子的6个面
				for(int k = 1; k < 7; k++) { //遍历上一个骰子的6个面
					//判断当前的两个面是否是互斥面
					if(b[shaiZi[j]][k] == false) {
						dp[e][j] = dp[e][j] + dp[1-e][k];
					}
				}
			}
		}
		
		long sum = 0;    //统计总数
		for(int i = 1; i < 7; i++) {
			sum = (sum+dp[e][i])%1000000007;
		}
		int c = (int) Math.pow(4, n);   //由于每个面朝上,都能旋转中间的四个面,所以这里需要 * 4^n
		sum = (sum*c)%1000000007;
		System.out.println(sum);
	}

}
