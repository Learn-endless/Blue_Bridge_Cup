package com.lanqiaobei.learn;

import java.util.Arrays;
import java.util.Scanner;

public class TestDemo4 {
	
	/**
	  * ���⣺������
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();   //��
		int m = sc.nextInt();   //��
		
		//������������ �ַ��� ��ά����
		String[][] s = new String[n+1][m+1];
		//������¼ ��ά���� �ж�Ӧ λ�� �Ƿ��Ѿ� �������
		boolean[][] rl = new boolean[n+1][m+1];
		//��ż�����ɺ���ַ�������
		double[][] data = new double[n+1][m+1];

		//ѭ������ �ַ��� ��ά����ľ�������
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < m+1;j++) {
				s[i][j] = sc.next();
			}
		}
		
		//������ӡ �ַ��� ������ÿ��λ�õ�ֵ
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < m+1; j++) {
				System.out.printf("%.2f ",f(s,i,j,rl,data));
			}
			System.out.println();
		}
		
	}
	
	/**
	 * �ַ���������:����Ӧλ�õ��ַ��� �����һ�� double ���͵�����
	 * @param s     ����ַ���������
	 * @param i     ��Ҫ����λ�õ����±�
	 * @param j     ���±�
	 * @param rl    ��¼ÿ��λ���Ƿ������
	 * @param data  ��Ž��ַ�������� double �������ֵ�����
	 * @return      ���ش�����ɵ�����
	 */
	private static double f(String[][] s, int i, int j,boolean[][] rl, double[][] data) {
		//�����λ���Ѿ����������,ֱ�ӷ��� data �����Ӧ�±��ֵ
		if(rl[i][j] == true) {
			return data[i][j];
		}
		//�����ǰλ�õ��ַ�����һ�������ַ���
		if(s[i][j].length() == 1) {
			//����� double ���͵�����,����ŵ� data ������
			data[i][j] = Double.parseDouble(s[i][j]);
			//��¼һ��,�ѱ�����
			rl[i][j] = true;
			//���ظ�ֵ
			return data[i][j];
		}
		//�ߵ�����˵������ �����ַ�,�ȼ�¼��,�ѱ�����
		rl[i][j] = true;
		//�����λ�õ��ַ����ָ��
		String[] str = s[i][j].split(":|,|\\(|\\)");
		//�õ����������
		int a1 = Integer.parseInt(str[1]);
		int a2 = Integer.parseInt(str[2]);
		int b1 = Integer.parseInt(str[3]);
		int b2 = Integer.parseInt(str[4]);
		
		//������������֮��Ԫ�ص� sum �� avg
		double sum = 0;
		double avg = 0;
		int count = 0;   //ͳ������֮���Ԫ�ظ���
		for(int x = a1; x <= b1;x++) {
			for(int y = a2; y <= b2; y++) {
				//�ݹ������ÿ��λ�õ�ֵ
				sum += f(s,x,y,rl,data);
				count++;
			}
		}
		//��� avg(ƽ��ֵ)
		avg = sum/count;
		//���� SUM(��) , AVG(ƽ��ֵ), STD(��׼��)
		if(str[0].equals("SUM")) {
		
			return data[i][j] = sum;
		}else if(str[0].equals("AVG")) {
			
			return data[i][j] = avg;
		}else {
			//���󷽲�: ÿ��������ƽ��ֵ�Ĳ��ƽ����ƽ��ֵ.
			double sumA = 0;
			for(int x = a1; x <= b1;x++) {
				for(int y = a2; y <= b2; y++) {
					sumA += Math.pow(avg-f(s,x,y,rl,data),2);
				}
			}
			//��� ��׼�� : �����ƽ����
			return Math.sqrt(sumA/count);
		}
	}

	public static void main1(String[] args) {
		String[][] array = new String[3][3];
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < array[i].length; i++) {
			for(int j = 0; j < array.length; j++) {
				array[i][j] = sc.next();
			}
		}
		
		array[2][2] = "123";
		System.out.println(Arrays.deepToString(array));
		
		String s = "SUM(2,1:3,1)";
		String[] str = s.split("\\(|,|:|\\)");//ÿ������֮����|����
		                                      //��.(��)������������������������*���Ǻţ�|�����ߣ���������Ŷ�Ҫ����ǰ�����\\��
		for(String x:str) {
			System.out.println(x);
		}
	}
}
