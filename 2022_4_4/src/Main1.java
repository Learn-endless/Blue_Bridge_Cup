import java.util.*;
public class Main1 {
	/**
	 * 在一个字符串中查找另一个字符串出现的最小次数
	 * @param args
	 */
	private static int findString(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		
		int[][] board = new int[len1+1][len2+1];
		
		//初始化：F[i][0] = 1 , F[0][j]=0 && j>0
		for(int i = 0; i <= len1; i++) {
			board[i][0] = 1;
		}	
		for(int i = 1; i <= len1; i++) {
			for(int j = 1; j <= len2; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					board[i][j] = board[i-1][j-1]+board[i-1][j];
				}else {
					board[i][j] = board[i-1][j];
				}
			}
		}
		return board[len1][len2];
	}
	
	/**
	 * 只使用一位数组每次将前一行的数据丢掉
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static int findString1(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		
		int[] board = new int[len2+1];      //记录行的信息
		
		//初始化：F[0] = 1
		board[0] = 1;
		
		for(int i = 1; i <= len1; i++) {
			for(int j = len2; j > 0; j--) {      //从后往前操作，避免拿到的不是上一行的值
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					board[j] = board[j-1]+board[j];
				}
			}
		}
		return board[len2];
	}
	public static void main(String[] args) {
		String s1 = "bitesbitesbitesbites";
		String s2 = "te";
		int ret = findString1(s1,s2);
		System.out.println(ret);
	}
}
