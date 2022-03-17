
import java.util.*;
public class TestDemo2 {
	
	public static int[][] board;
	public static int[][] c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();    //��ʾ����Ľ���
		int m = sc.nextInt();    //��ʾ������˵�����
		
		board = new int[n][n];
		c = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
				c[i][j] = board[i][j];
			}
		}
		
		if(m == 0) {
			//0����
			board_0(n);
			print(board, n);
		}else {
			//��0����
			board_M(m,n);
			print(c,n);
		}
	}
	
	private static void board_M(int m, int n) {
		for(int i = 1; i < m; i++) {
			//���� ԭ���� �� c�������
			handleArray(n);
		}
	}

	private static void handleArray(int n) {
		int[][] tmp = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				func(tmp,i,j,n);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				c[i][j] = tmp[i][j];
			}
		}
	}

	private static void func(int[][] tmp, int i, int j, int n) {
		int sum = 0;
		for(int k = 0; k < n; k++) {
			sum += board[i][k] * c[k][j];
		}
		tmp[i][j] = sum;
	}

	private static void print(int[][] array, int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}

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
