package ��С·��;
/**
 * С��ѧϰ�����·��֮���ر���ˣ���������һ���ر��ͼ��ϣ���ҵ�ͼ �е����·����

С����ͼ�� 2021 �������ɣ����α�� 1 �� 2021��

����������ͬ�Ľ�� a, b����� a �� b �Ĳ�ľ���ֵ���� 21����������� ֮��û�б���������� a �� b �Ĳ�ľ���ֵС�ڵ��� 21����������֮����һ�� ����Ϊ a �� b ����С�������������������

���磺��� 1 �ͽ�� 23 ֮��û�б���������� 3 �ͽ�� 24 ֮����һ���� ��ߣ�����Ϊ 24����� 15 �ͽ�� 25 ֮����һ������ߣ�����Ϊ 75��

����㣬��� 1 �ͽ�� 2021 ֮������·�������Ƕ��١�
 */
public class Main1 {
	public static int INF = Integer.MAX_VALUE/2;
	
	public static void main(String[] args) {
		
	}
	

	/**
	  * �� dist ������г�ʼ��
	 * @param dist
	 */
	private static void initDist(int[] dist) {
		for(int i = 0; i < dist.length; i++) {
			dist[i] = INF;
		}
	}
	
	
	/**
	  * ��ʼ��ͼ
	 * @param board
	 */
	public static void createBoard(int[][] board) {
		for(int i = 1; i <= 2021; i++) {
			for(int j = 1; j <= 2021; j++) {			
				if(i == j) {
					board[i][j] = 0;
				}else if(Math.abs(i-j) > 21) {
					board[i][j] = INF;
				}else {
					board[i][j] = lcm(i,j);
				}
			}
		}
	}
		
	/**
	  * ����������������Լ��
	 * @param a
	 * @param b
	 * @return
	 */
	public static int gcd(int a,int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b,a%b);
	}
	
	/**
	  * �������������С������
	 * @param a
	 * @param b
	 * @return
	 */
	public static int lcm(int a,int b) {
		return a*b/gcd(a,b);
	}
}
