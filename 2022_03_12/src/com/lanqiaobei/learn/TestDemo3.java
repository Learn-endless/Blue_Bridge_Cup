package com.lanqiaobei.learn;

public class TestDemo3 {
	/** 
          *  ��������
	 * @param args
	 */
	public static void main(String[] args) {
		// �� 0 �꿪ʼ����,��������Ǵ� 100�꿪ʼ�������
		for(int i = 0; i <= 100; i++) {
			int total = 0;   //ͳ���ܹ���������
			//����С�� 236 ʱ,�������� ͳ��
			for(int j = i; total < 236; j++) {	
				total += j;
			}
			//�ж� total �ǲ��Ǹոպ� �� 236
			if(total == 236) {
				//�𰸾�����
				System.out.println("answer:::"+i);
				break;
			}
		}
	}
}
