package com.lanqiaobei.learn;

import java.util.*;
/**
 * BASIC-30	���� �׳˼���
 * @author ֻ��������
 */
public class TestDemo7 {
	public static int Max = 2600;             //��Ҫ2600λ���ֲ��ܱ�ʾ 1000!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] data = new int[Max];
		data[0] = 1;                         //��һ������ʼ��Ϊ 1
		for(int i = 2; i <= n; i++) {
			                                 //n�Ľ׳�,ѭ��n��
			int number = 0;        
			int ret = 0;
			for(int j = 0; j < Max; j++) {
				number = data[j] * i + ret;  //�����ǰλ���� i ��ֵ(������һ�εĽ�λ)
				data[j] = number % 10;       //number�ĸ�λ�ŵ���ǰ�±�
				ret = number / 10;           //������һ����Ҫ��λ��ֵ���м�¼
			}
		}
		
		boolean flg = false;                //�����ҵ�����Ӻ���ǰ��һ����Ϊ 0 ����
		for(int i = Max-1; i >= 0; i--) {
			if(data[i] != 0) {
				flg = true;
			}
			if(flg) {
				//�Ӻ���ǰ,��һ����Ϊ0������ʼ��ӡ
				System.out.print(data[i]);
			}
		}	
	}
}
