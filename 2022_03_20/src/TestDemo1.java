

public class TestDemo1 {
	/**
	 * 
	 */
	public static int INF = Integer.MAX_VALUE/2;
	
	public static void main(String[] args) {
		//���ͼ�Ķ�ά����
		int[][] board = new int[2100][2100];
		//���ÿ���ڵ�ķ���״̬
		boolean[] flg = new boolean[2100];
		//����һ���㵽���������̾���
		int[] dist = new int[2100];
		
		createBoard(board);     //��board��dist���г�ʼ��
		initDist(dist);
		
		dijkstra(1,board,flg,dist);    //��һ��1,��ʾ���� 1 �ĵ㵽 ���������̾���
		
		System.out.println(dist[2021]);//dist������������ľ��� ԭ�㵽���е����̾���
	}

	/**
	 * dijkstra
	 * @param base    ԭ��
	 * @param board   �����ͼ����Ϣ
	 * @param flg     ���ÿ���ڵ��״̬(�Ƿ񱻷��ʹ�)
	 * @param dist    ���ԭ�㵽ÿ�������̾���
	 */
	private static void dijkstra(int base, int[][] board, boolean[] flg, int[] dist) {
		//��ԭ�㵽�����ľ����ʼ��Ϊ 0;
		dist[base] = 0;
		//������ԭ����������еĵ�
		for(int i = 2; i <= 2021; i++) {
			
			int ret = -1;   //��¼ : �м����±�
			
			//���forѭ������Ѱ�ҵ�ǰ�ڵ㵽���ýڵ���,������̵��Ǹ���(�ѷ��ʵĳ���)
			for(int j = 1; j <= 2021 ; j++) {
				//�鿴�Ƿ���ʹ�,�����ǲ��ǵ�һ�ν���ѭ��
				if(flg[j] == false && (ret == -1 || dist[j] < dist[ret])) {
					//��¼�±�
					ret = j;
				}
			}
			//���ĵ�ǰѰ�ҵ�����̾���ĵ��״̬
			flg[ret] = true;
			
			//���ѭ���������� dist �е���̾���(�����еĵ㶼�����ж�һ��,�ҳ���С����)
			for(int j = 1; j <= 2021; j++) {
				//�ҵ�����С���� ���� �� dist ��
				dist[j] = Math.min(dist[j], dist[ret] + board[ret][j]);
			}
		}
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
