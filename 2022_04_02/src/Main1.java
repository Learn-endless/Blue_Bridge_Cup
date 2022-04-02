/**
 * �ָ��ַ�����
 * ����һ���ַ�����Ȼ�������С�ָ������ʹ����Ϊһ�������ַ���
 * @author 19833
 *
 */
public class Main1 {
	
	private static boolean[][] board;
	
	private static int parString(String s) {
		
		//״̬���壺 s�ַ�����ǰ i ���ַ�ʹ����Ϊ�����ַ����ķָ����
		int len = s.length();
		int[] F = new int[len+1];   //0�±�Ҳʹ��
		
		isPal2(s);
		
		//��ʼ���������κ�һ���ַ������������ָ�������������ַ��ĸ���-1
		for(int i = 0; i <= len; i++) {
			F[i] = i-1;
		}
		
		//״̬ת�Ʒ��̣� j < i && F[j] && F[j+1,i]+1(j+1�±굽 i �±���ַ���Ҫ��һ�������ַ���)
		for(int i = 2; i <= len; i++) {
			
//			if(isPal(s,0,i-1)) {   //�ж������Ƿ�Ϊһ�������ַ���
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
	 * ��̬�滮˼�룺��ÿ���Ӵ��ķָ�״̬���ŵ� board ��ά������
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
