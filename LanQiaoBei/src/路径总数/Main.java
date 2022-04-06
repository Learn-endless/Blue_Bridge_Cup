package Â·¾¶×ÜÊı;

public class Main {
	
	private static int func(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		
		for(int i = 0; i < n; i++) {
			board[0][i] = 1;
		}
		for(int i = 0; i < m; i++) {
			board[i][0] = 1;
		}
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				board[i][j] = board[i][j-1]+board[i-1][j];
			}
		}
		return board[m-1][n-1];
	}
	
	public static void main(String[] args) {
		int[][] array = new int[3][7];
		int ans = func(array);
		System.out.println(ans);
	}
}
