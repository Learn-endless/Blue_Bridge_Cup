import java.util.Scanner;
/**
 * 垒骰子
 * @author 只爱吃土豆
 *
 */
public class TestDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextInt();       //表示筛子的个数
		int m = sc.nextInt();       //表示对立面的组数(两个对立面为一组)
		
		boolean[][] b = new boolean[7][7];   //用来存放对立面的信息
		int[] shaiZi = {0,4,5,6,1,2,3};      //根据题目来确定筛子 6 面的点数:
		                                     //shaiZi[i] = j: i的对立面是j
		                                     //1 的对面是 4，2 的对面是 5，3 的对面是 6。
		for(int i = 0;i < m; i++) {
			int x = sc.nextInt();   //a面
			int y = sc.nextInt();   //b面
			//将对立面的关系存放到 b 数组中
			b[x][y] = true; 
			b[y][x] = true;        //如果 1 和 2是对立面,那么 2 和 1也是对立面
		}
		
		int e = 0;               //一个指针指向 dp的行下标,用于在 dp[0]和dp[1]之间反转  
		
		//创建一个滚动数组,并将它的第一行都赋值成 1
		long[][] dp = new long[2][7];
		for(int i = 1; i < 7; i++) {
			dp[0][i] = 1;
		}
		int c = 4;
		//只有从两个筛子开始才能 垒起来
		for(long i = 2; i <= n; i++) {
			e = 1 - e;         //使它跟随 层数 反转(0,1)之间.
			c *= 4;
			for(int j = 1; j < 7; j++) {
				for(int k = 1; k < 7; k++) {
					//判断当前的两个面是否能紧贴在一起
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
		sum = (sum*c)%1000000007;
		System.out.println(sum);
	}

}
