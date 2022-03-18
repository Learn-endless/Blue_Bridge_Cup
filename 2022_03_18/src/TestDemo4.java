import java.util.*;
public class TestDemo4 {
	public static boolean[][] flg;
	public static int[][] board;
	public static int n;
	public static int m;
	
	public static int[][] count;
	
	public static int[] tmp = new int[2];
	
	public static PriorityQueue<Integer> list = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		flg = new boolean[n][m];
		board = new int[n][m];
		count = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m ; j++) {
				board[i][j] = sc.nextInt();
				if(i == 0 || i == n-1 || j == 0 || j == m-1) {
					flg[i][j] = true;
					list.offer(board[i][j]);
				}
			}
		}
		
		while(list.size() != 0) {
			int ret = list.poll();
			findN(ret);
			dfs(tmp[0],tmp[1],ret);
		}
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				sum += count[i][j];
				System.out.print(count[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(sum);
		
	}
	
	private static void dfs(int i, int j, int ret) {
		if(i+1 < n-1 && flg[i+1][j] == false) {
			flg[i+1][j] = true;
			if(board[i+1][j] < ret) {
				count[i+1][j] = ret-board[i+1][j];
			}else {
				list.offer(board[i+1][j]);
			}
		}
			
		if(i-1 > 0 && flg[i-1][j] == false) {
			flg[i-1][j] = true;
			if(board[i-1][j] < ret) {
				count[i-1][j] = ret-board[i-1][j];
			}else {
				list.offer(board[i-1][j]);
			}
		}
			
		if(j-1 > 0 && flg[i][j-1] == false) {
			flg[i][j-1] = true;
			if(board[i][j-1] < ret) {
				count[i][j-1] = ret-board[i][j-1];
			}else {
				list.offer(board[i][j-1]);
			}
		}
		if(j+1 < m-1 && flg[i][j+1] == false) {
			flg[i][j+1] = true;
			if(board[i][j+1] < ret) {
				count[i][j+1] = ret-board[i][j+1];
			}else {
				list.offer(board[i][j+1]);
			}
		}
	}
	private static void findN(int poll) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(board[i][j] == poll) {
					tmp[0] = i;
					tmp[1] = j;
					board[i][j] = -1;
					return;
				}
			}
		}
	}
}
