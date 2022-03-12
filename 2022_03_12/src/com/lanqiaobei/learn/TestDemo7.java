package com.lanqiaobei.learn;

/*
 * ��������
 */
public class TestDemo7 {
	
	public static int count = 0;   //����ͳ�ƴ���
	public static int N = 3;       //��
	public static int M = 4;       //��
	
	public static boolean[] ret = new boolean[10];    //��¼ÿ�������Ƿ�ʹ�ù�	
	public static int[][] number = new int[N+2][M+2]; //�����������
	
	
	public static void main(String[] args) {
		//�� number ������г�ʼ���� -20(���һ����������)
		for(int i = 0; i < N+2; i++) {
			for(int j = 0; j < M+2; j++) {
				number[i][j] = -20;
			}
		}	
		//�ݹ�������еķ���
		dfs(0,1,2);
		//��ӡ�����Ĵ���
		System.out.println(count);
		
	}

	/**
	 * �����㷨
	 * @param depth   ���(Ҳ���ǵ�ǰ�Ѿ����˶��ٸ���)
	 * @param n       ��ǰ����λ�õ� - ��
	 * @param m       ��ǰ����λ�õ� - ��
	 */
	private static void dfs(int depth, int n,int m) {
		//������� 10 ����
		if(depth == 10) {
			//ͳ��һ��
			count++;
			return;
		}
		//�жϵ�ǰ���±��Ƿ���Ҫ���� number ����һ��
		if(m > M) {
			n += 1;
			m = 1;
		}
		//ѭ���ĳ��Է�����
		for(int i = 0; i <= 9 ;i++) {
			//���жϵ�ǰ��Ҫ�ŵ������Ƿ��Ѿ���ʹ����
			//��鵱ǰ��Ҫ�ŵ� ���� �Ƿ������ĿҪ��:�������ڵ���������
			if(!ret[i]  &&  checkNumber(n,m,i)) {
				//�Ž� number ��
				number[n][m] = i;
				//���� ���� ��״̬
				ret[i] = true;
				//�ݹ���һ��λ��
				dfs(depth+1,n,m+1);
				//����
				number[n][m] = -20;
				ret[i] = false;
			}
		}
	}

	/**
	 * ��������Ƿ����Ҫ��  :  �������ڵ���������
	 * @param n     ��
	 * @param m     ��
	 * @param data  ��������
	 * @return      һ��booleanֵ
	 */
	private static boolean checkNumber(int n, int m, int data) {
		if(
			//���ڲ���������������,���ǲ�ľ���ֵ һ������ 1
			Math.abs(data-number[n-1][m]) == 1   || Math.abs(data-number[n+1][m]) == 1   ||
			Math.abs(data-number[n][m+1]) == 1   || Math.abs(data-number[n][m-1]) == 1   ||
			Math.abs(data-number[n-1][m-1]) == 1 || Math.abs(data-number[n-1][m+1]) == 1 ||
			Math.abs(data-number[n+1][m-1]) == 1 || Math.abs(data-number[n+1][m+1]) == 1 
				) {
			return false;
		}
		return true;
	}
}
