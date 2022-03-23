import java.util.PriorityQueue;
import java.util.Scanner;
public class TestDemo5 {
	
	public static int[][] board;
	public static int n;
	public static int m;
	
	public static int[][] count;
	
	public static PriorityQueue<Integer> list = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		board = new int[n][m];
		count = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m ; j++) {
				board[i][j] = sc.nextInt();
				if(i == 0 || i == n-1 || j == 0 || j == m-1) {
					list.offer(board[i][j]);
				}
			}
		}
		
		int ret = list.poll();
		for(int i = 1; i < n-1; i++) {
			for(int j = 1; j < m-1; j++) {
				if(board[i][j] < ret) {
					count[i][j] = ret - board[i][j];
				}
			}
		}
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				sum += count[i][j];
			}
		}
		System.out.println(sum);
	}
}
