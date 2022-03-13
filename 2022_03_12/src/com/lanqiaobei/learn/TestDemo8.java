package com.lanqiaobei.learn;

/**
  * ����Ʊ
 * @author ֻ��������
 *
 */
public class TestDemo8 {
	//�������ÿһ�μ��µ�������Ʊ
	public static int[] tmp = new int[5];
	//���ԭ����������Ʊ
	public static int[][] stamp = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
	
	//��¼ÿһ��Ҫ���µ� ������Ʊ��״̬ (1��-12��)��Ʊ
	public static boolean[] t = new boolean[13];	
	//ÿ����һ��,���� w �����¼��ǰ ��Ʊ ��״̬(�Ƿ��Ѽ�)
	public static boolean[] w = new boolean[13];
	
	//ͳ�Ƽ��Ĵ���
	public static int depth = 0;
	//����һ�����(ÿ����Ʊ����Ҫ�󷵻� true,��֮���� false)
	public static boolean label = false;
	
	public static void main(String[] args) {
		//ͳ�Ʒ�������
		int count = 0;
		//��ö���оٳ� a b c d e ������Ʊ���������
		int a,b,c,d,e;
		for(a = 1; a <= 12 ;a++) {
			for(b = a+1; b <= 12 ;b++) {
				for(c = b+1; c <= 12 ;c++) {
					for(d = c+1; d <= 12 ;d++) {
						for(e = d+1; e <= 12 ;e++) {
							//����ǰѡ�е���Ʊ���δ�ŵ� tmp ������
							tmp[0] = a;
							tmp[1] = b;
							tmp[2] = c;
							tmp[3] = d;
							tmp[4] = e;
							//�� t �����н� ��ǰ��������Ʊ��״̬����(��Ϊtrue)
							changeStatusT();
							//�����������Ʊ�Ƿ���������һ��
							if(check()) {
								//����
								count++;
							}
							//�� t ������г�ʼ��Ϊ false,׼����һ����Ʊ�ļ��
							initT();
						}
					}
				}
			}
		}
		System.out.println(count);
	}
	
	/**
	  * ������ǰ �� ����Ʊ��״̬
	 */
	private static void changeStatusT() {
		for(int i = 0; i < 5; i++) {
			t[tmp[i]] = true;
		}
	}

	/**
	  * �� t ������Ϊ��ʼ״̬.
	 */
	private static void initT() {
		for(int i = 0; i < 5; i++) {
			t[tmp[i]] = false;
		}
	}

	/**
	  * ��ʼ�� w ����(w:ÿ��һ��,��¼����Ʊ��״̬)
	 */
	private static void initW() {
		for(int i = 0; i < 13;i++) {
			w[i] = false;
		}
	}

	/**
	  * ��鵱ǰ���� ��Ʊ �Ƿ�����������һ��
	 * @return
	 */
	private static boolean check() {
		//��ʼ��һ�±��
		label = false;  
		//��ʼ����ǰ���Ĵ���
		depth = 0;
		//��ʼ�� w ����(��Ϊfalse,��ʾ���е���Ʊ��û������)
		initW();
		
		//����ѭ��������
		boolean flg = false;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				//����� stamp ���ҵ���һ����Ʊ,���±괫�� dfs,�����ݹ���.
				if(stamp[i][j] == tmp[0]) {
					//��dfs�����ȷ��������Ҫ��,�ͻὫ label ��Ϊ true.
					dfs(i,j);
					flg = true;
					break;
				}
			}
			if(flg) break;
		}
		//�����жϽ��
		return label;	
	}
	
	/**
	  * �ӵ�ǰ�±������ܿ�ʼ����Ʊ
	 * @param x  ��
	 * @param y  ��
	 */
	private static void dfs(int x, int y) {
		//�ݹ��������,�������,˵��ÿ�Ŷ�����������
		if(depth == 5) {
			//���Ϊ ����Ҫ��
			label = true;
			return;
		}
		
		//�жϵ�ǰ������Ʊ�Ƿ��� ��ǰ������Ʊ��,���� ��û�б�����
		if(t[stamp[x][y]] == true && w[stamp[x][y]] == false) {
			//���Ϊ ������ ״̬
			w[stamp[x][y]] = true;
			//����Ʊ�Ĵ��� +1
			depth++;
			//�ж������ܲ��ܼ�
			if(x-1 >= 0) {
				dfs(x-1,y);
			}
			//�����ܲ��ܼ�
			if(x+1 <= 2) {
				dfs(x+1,y);
			}
			//����ܲ��ܼ�
			if(y-1 >= 0) {
				dfs(x,y-1);
			}
			//�ұ��ܲ��ܼ�
			if(y+1 <= 3) {
				dfs(x,y+1);
			}
		}
	}
}
