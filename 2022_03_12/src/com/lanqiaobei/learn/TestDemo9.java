package com.lanqiaobei.learn;

public class TestDemo9 {
	/**
	  * ���⣺�������
	 * @param args
	 */
	public static void main(String[] args) {
		//Բ�İ뾶
		int r = 1000;
		//ͳ�ƴ���
		int count = 0;
		//����ÿ������
		for(int i = 1; i <= r; i++) {
			for(int j = 1; j <= r; j++) {
				//�����ǰ���ӵ����Ͻǵĵ㵽ԭ��ľ��� <= r
				if(i*i+j*j <= r*r) {
					//����ͳ��
					count++;
				}
			}
		}
		//��������ֻ������ķ�֮һ�ķ���,������Ҫ *4
		System.out.println(count*4);
	}
}
