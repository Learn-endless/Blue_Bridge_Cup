import java.util.*;
public class Main1 {
	/**
	 * ��һ���ַ����в�����һ���ַ������ֵ���С����
	 * @param args
	 */
	private static int findString(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		
		int[][] board = new int[len1+1][len2+1];
		
		//��ʼ����F[i][0] = 1 , F[0][j]=0 && j>0
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
	 * ֻʹ��һλ����ÿ�ν�ǰһ�е����ݶ���
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static int findString1(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		
		int[] board = new int[len2+1];      //��¼�е���Ϣ
		
		//��ʼ����F[0] = 1
		board[0] = 1;
		
		for(int i = 1; i <= len1; i++) {
			for(int j = len2; j > 0; j--) {      //�Ӻ���ǰ�����������õ��Ĳ�����һ�е�ֵ
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
