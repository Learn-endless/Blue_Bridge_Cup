
import java.util.*;
/**
 * BASIC-17	VIP���� ����˷�
 * @author ֻ��������
 *
 */
public class TestDemo2 {
	//�������ľ���
	public static int[][] board;
	//������ 0 ����ʱ,�������ɳ˷�
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
	
	/**
	  * ���������˵Ĵ���
	 * @param m  m����
	 * @param n  n�׾���
	 */
	private static void board_M(int m, int n) {
		for(int i = 1; i < m; i++) {
			//���� ԭ���� �� c�������
			handleArray(n);
		}
	}

	/**
	 * ����ÿ�����������
	 * @param n  n�׾���
	 */
	private static void handleArray(int n) {
		//����һ�� tmp ��ʱ�������� ����������˵Ľ��
		int[][] tmp = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				//���崦��������˵ľ��� ��Ӧλ���ϵ�ֵ
				func(tmp,i,j,n);
			}
		}
		
		//����˵Ľ�� ��ŵ� c ������
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				c[i][j] = tmp[i][j];
			}
		}
	}

	/**
	 * ���������������,ÿ��λ���ϵ�ֵ
	 * @param tmp   ������ʱ��� ��� �� ��ά����
	 * @param i     ����λ�õ� ������
	 * @param j     ����λ�õ� ������
	 * @param n     n�׾���
	 */
	private static void func(int[][] tmp, int i, int j, int n) {
		int sum = 0;
		for(int k = 0; k < n; k++) {
			//��Ӧλ�õ�ֵ = ����1ÿһ�е�ֵ * ����2ÿһ�е�ֵ�� ��
			sum += board[i][k] * c[k][j];
		}
		tmp[i][j] = sum;
	}

	/**
	 * ��ӡ array �����е�����
	 * @param array һ������
	 * @param n     n�׾���
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
	 * ������˷�Ϊ 0 ����ʱ,�������ĶԽ��߶�Ϊ 1 ,������λ��Ϊ 0
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
