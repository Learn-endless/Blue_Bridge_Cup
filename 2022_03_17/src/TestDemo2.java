
import java.util.*;
/**
 * BASIC-17	VIP试题 矩阵乘法
 * @author 只爱吃土豆
 *
 */
public class TestDemo2 {
	//存放输入的矩阵
	public static int[][] board;
	//当不是 0 次幂时,用来过渡乘法
	public static int[][] c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();    //表示矩阵的阶数
		int m = sc.nextInt();    //表示矩阵相乘的幂数
		
		board = new int[n][n];
		c = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
				c[i][j] = board[i][j];
			}
		}
		
		if(m == 0) {
			//0次幂
			board_0(n);
			print(board, n);
		}else {
			//非0次幂
			board_M(m,n);
			print(c,n);
		}
	}
	
	/**
	  * 处理矩阵相乘的次数
	 * @param m  m次幂
	 * @param n  n阶矩阵
	 */
	private static void board_M(int m, int n) {
		for(int i = 1; i < m; i++) {
			//处理 原矩阵 与 c矩阵相乘
			handleArray(n);
		}
	}

	/**
	 * 处理每两个矩阵相乘
	 * @param n  n阶矩阵
	 */
	private static void handleArray(int n) {
		//创建一个 tmp 暂时用来接收 两个矩阵相乘的结果
		int[][] tmp = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				//具体处理两个相乘的矩阵 对应位置上的值
				func(tmp,i,j,n);
			}
		}
		
		//将相乘的结果 存放到 c 数组中
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				c[i][j] = tmp[i][j];
			}
		}
	}

	/**
	 * 处理两个矩阵相乘,每个位置上的值
	 * @param tmp   用来暂时存放 结果 的 二维数组
	 * @param i     处理位置的 行坐标
	 * @param j     处理位置的 列坐标
	 * @param n     n阶矩阵
	 */
	private static void func(int[][] tmp, int i, int j, int n) {
		int sum = 0;
		for(int k = 0; k < n; k++) {
			//对应位置的值 = 矩阵1每一行的值 * 矩阵2每一行的值的 和
			sum += board[i][k] * c[k][j];
		}
		tmp[i][j] = sum;
	}

	/**
	 * 打印 array 矩阵中的内容
	 * @param array 一个矩阵
	 * @param n     n阶矩阵
	 */
	private static void print(int[][] array, int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}

	/**
	 * 当矩阵乘法为 0 次幂时,这个矩阵的对角线都为 1 ,其他的位置为 0
	 * @param n
	 */
	private static void board_0(int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == j) {
					board[i][j] = 1;
				}else {
					board[i][j] = 0;
				}
			}
		}
	}
}
