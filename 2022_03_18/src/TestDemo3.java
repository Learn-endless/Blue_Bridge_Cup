import java.util.*;
public class TestDemo3 {
	
	public static int[][] board; 
	public static int n;
	public static int m;
	public static int count = 0;
	public static PriorityQueue<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		list = new PriorityQueue<>();
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		board = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		if(n < 3 || m < 3) {
			System.out.println("0");
		}else {
			InitHeap();
			func();
			System.out.println(count);
		}
	}
	
	
	
	private static void func() {
		for(int i = 1; i < n-1; i++) {
			for(int j = 1; j < m-1; j++) {
				if(board[i][j] < list.peek()) {
					count += (list.peek() - board[i][j]);
				}else {
					list.offer(board[i][j]);
				}
			}
		}
	}



	private static void InitHeap() {
		for(int i = 0; i < m; i++) {
			list.offer(board[0][i]);
			list.offer(board[n-1][i]);
		}
		for(int i = 0; i < n; i++) {
			list.offer(board[i][0]);
			list.offer(board[i][m-1]);
		}
	}
}
