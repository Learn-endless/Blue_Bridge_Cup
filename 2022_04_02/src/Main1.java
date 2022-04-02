/**
 * 分割字符串：
 * 给定一个字符串，然后求出最小分割次数，使它成为一个回文字符串
 * @author 19833
 *
 */
public class Main1 {
	
	private static boolean[][] board;
	
	private static int parString(String s) {
		
		//状态定义： s字符串的前 i 个字符使它成为回文字符串的分割次数
		int len = s.length();
		int[] F = new int[len+1];   //0下标也使用
		
		isPal2(s);
		
		//初始化：对于任何一个字符串，它的最大分割次数就是它的字符的个数-1
		for(int i = 0; i <= len; i++) {
			F[i] = i-1;
		}
		
		//状态转移方程： j < i && F[j] && F[j+1,i]+1(j+1下标到 i 下标的字符串要是一个回文字符串)
		for(int i = 2; i <= len; i++) {
			
//			if(isPal(s,0,i-1)) {   //判断整体是否为一个回文字符串
//				F[i] = 0;
//				continue;
//			}
			
			for(int j = 0; j < i; j++) {
//				if(isPal(s,j,i-1)) {
				if(board[j][i-1]) {
					F[i] = Math.min(F[i], F[j]+1);
				}
			}
		}
		return F[len];
	}
	
	private static boolean isPal(String s, int i, int j) {
		while(i < j) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	/**
	 * 动态规划思想：将每个子串的分割状态都放到 board 二维矩阵中
	 * @param s
	 */
	private static void isPal2(String s) {
		int n = s.length();
		board = new boolean[n][n];
		
		for(int i = n-1; i >= 0; i--) {
			for(int j = i; j < n; j++) {
				if(i == j) {
					board[i][j] = true;
				}else if(i+1 == j) {
					board[i][j] = s.charAt(i) == s.charAt(j);
				}else {
					board[i][j] = s.charAt(i) == s.charAt(j) && board[i+1][j-1];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String s = "google";
		int ret = parString(s);
		System.out.println(ret);
	}
}
