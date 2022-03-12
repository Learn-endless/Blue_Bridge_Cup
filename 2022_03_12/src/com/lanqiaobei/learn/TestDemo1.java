package com.lanqiaobei.learn;

import java.util.Scanner;

/**
  * ���⣺��Խ����
 * @author ֻ��������
 *
 */
public class TestDemo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();                   //��������С n �� n��
		char[][] array = new char[n+2][n+2];    //��ŷ������ַ�,��Ҫ����������������ñ߽�
		boolean[][] roadState = new boolean[n+2][n+2];  //��ŵ�ǰ�ַ��Ƿ�ʹ�õ�״̬
		int[][] count = new int[n+2][n+2];
		
		int a1 = -1;   //������¼ A ���±�
		int a2 = -1;
		
		//ѭ������һ�� ��ά ����
		for(int i = 1; i <= n ; i++) {
			for(int j = 1; j <= n; j++) {
				String s = sc.next();
				char tmp = s.charAt(0);
				if(tmp == 'A') {
					array[i][j] = 'A';   //�� A �Ž�����
					//��¼��ʼ�� A ���±�
					a1 = i;
					a2 = j;
				}else if(tmp == '+') {
					array[i][j] = '+';
				}else if(tmp == '-') {
					array[i][j] = '-';
				}else if(tmp == 'B') {
					array[i][j] = 'B';
				}
			}
		}
		//�� roadState ������г�ʼ�� (true��ʾ����ͨ�������Ѿ��߹�)
		for(int i = 0; i < n+2; i++) {
			roadState[0][i] = true;    //�ϱ߽�
			roadState[n+1][i] = true;  //�±߽�
			roadState[i][0] = true;    //��߽�
			roadState[i][n+1] = true;  //�ұ߽�
		}
		
		//��ӡ��С����
		System.out.println(dfs(a1,a2,array,roadState,count));
	}

	private static int dfs(int a1, int a2, char[][] array, boolean[][] roadState,int[][] count) {
		//�����ǰ�±��ֵ���� 'B',˵��������.
		if(array[a1][a2] == 'B')  return 0;
		
		//�����ǰλ�� ����С���� �Ѿ��� �����,ֱ�ӷ���.
		if(count[a1][a2] != 0) {
			return count[a1][a2];
		}
		
		//�ı�һ�µ�ǰλ�õ� ״̬,˵���Ѿ����߹���
		roadState[a1][a2] = true;
		
//		System.out.println(a1+"-->"+a2);
		
		//ͳ�Ƶ�ǰλ�ô��ĸ������ߵ��� 'B' ��Ҫ�� ����.
		int l1 = Integer.MAX_VALUE-1;
		int l2,l3,l4;               //
		l2 = l3 = l4 = l1;          //��Ϊ����Ҫ����С����,����������һ�����������ʼ��
		
		if(!roadState[a1][a2+1] && array[a1][a2] != array[a1][a2+1]) {
			//˵�������� ����
			l1 = dfs(a1,a2+1,array,roadState,count);   //ͳ�Ʋ����� l1 ����
		}
		if(!roadState[a1][a2-1] && array[a1][a2] != array[a1][a2-1]) {
			//˵�������� ����
			l2 = dfs(a1,a2-1,array,roadState,count);   //ͳ�Ʋ����� l2 ����
		}
		if(!roadState[a1+1][a2] && array[a1][a2] != array[a1+1][a2]) {
			//˵�������� ����
			l3 = dfs(a1+1,a2,array,roadState,count);   //ͳ�Ʋ����� l3 ����
		}
		if(!roadState[a1-1][a2] && array[a1][a2] != array[a1-1][a2]) {
			//˵�������� ����
			l4 = dfs(a1-1,a2,array,roadState,count);   //ͳ�Ʋ����� l4 ����
		}
		
		//���е�����,��Ҫ���� ���� ,���½� ��ǰ��λ������Ϊ false(û�߹���״̬)
		roadState[a1][a2] = false;
		//������С���� l1 l2 l3 l4 �е���Сֵ+1 (��ǰ��һ��) �� count�����Ӧ��λ��
		return count[a1][a2] = Math.min(Math.min(l1, l2), Math.min(l3, l4))+1;
	}
}
