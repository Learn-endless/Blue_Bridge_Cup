package 子串分值和;

import java.util.Scanner;
public class Main {
	
	private static int[][] array;
	private static void func(String s) {
		int len = s.length();
		array = new int[len][len];
		for(int i = len-1; i >= 0; i--) {
			for(int j = i; j < len; j++) {
				if(j == i) {
					array[i][j] = 1;
				}else if(i+1 == j){
					array[i][j] = s.charAt(i)==s.charAt(j)?1:2;
				}else {
					String s1 = s.substring(i, j);
					if(s1.contains(s.charAt(j)+"")) {
						array[i][j] = array[i][j-1];
					}else {
						array[i][j] = array[i][j-1]+1;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		int len = str.length();
		int[] board = new int[len+1];
		func(str);
		
		board[1] = 1;
		for(int i = 2; i <= len; i++) {
			board[i] = board[i-1]+1;
			for(int j = 0; j < i-1; j++) {
				board[i] += array[j][i-1];
			}
		}
		
//		for(int i = 0; i <= len; i++) {
//			System.out.print(board[i]+" ");
//		}
//		System.out.println();
		System.out.println(board[len]);
	}
}
