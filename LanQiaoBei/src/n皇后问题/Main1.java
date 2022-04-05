package n�ʺ�����;
import java.util.*;
/**
 * ��N*N�ķ������̷�����N���ʺ�
 * ʹ�����ǲ��໥������������2���ʺ�������ͬһ�ţ�ͬһ�У�
 * Ҳ�������������̱߿��45�ǵ�б���ϡ�
 * ��������ǣ����ڸ�����N������ж����ֺϷ��ķ��÷���?
 */
public class Main1 {
	
	private static int count = 0;    //����ͳ�ƺϷ��ķ��÷���
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//���� n ��ֵ
		int n = sc.nextInt();
		
		//����һ�� n * n�Ķ�ά��������
		int[][] board = new int[n][n];
		
		//ʹ�û����㷨
		dfs(0,board,n);
		
		//��count�е������������
		System.out.println(count);
	}

	/**
	 * ��dfs��n�ʺ�ķ�������
	 * @param i       //�ݹ����ȣ�Ҳ���Ƿ��˼����ʺ���
	 * @param board   //����
	 */
	private static void dfs(int depth, int[][] board,int n) {
		//ͳ�ƴ���������
		if(depth == n) {
			count++;
			return;
		}
		//����ÿһ�е�ÿ��λ�ã����Ե�����λ�÷Żʺ�
		for(int i = 0; i < n; i++) {
			//�ȼ�����λ���ܷ�Żʺ�
			if(isDanger(depth,i,board, n)) {
				//�Żʺ�
				board[depth][i] = 1;   //1��ʾ��һ���ʺ�ŵ���board���̵ĸ�λ����
				//��һ��
				dfs(depth+1,board,n);
				//���л���
				board[depth][i] = 0;   //0��ʾ�ҰѸ�λ���ϵĻʺ��������
			}
		}
	}
	/**
	 * ��鵱ǰλ���Ƿ��ܷŻʺ�
	 * @param row   ������
	 * @param col       ������
	 * @return
	 */
	private static boolean isDanger(int row, int col,int[][] board,int n) {
		//�����ǰλ���Ѿ����˻ʺ���ô�ͷ��� false
		if(board[row][col] == 1) {
			return false;
		}
		
		//ѭ���ж�ͬһ�У�ͬһ�� ��45�ȵ����Խ��ߣ�-45�ȵķ��Խ���
		for(int i = 0; i < row; i++) {
			if(board[i][col] == 1) {
				return false;
			}
			
			for(int j = 0; j < n; j++) {
				if((row+col == i+j || row-col == i-j) && board[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
