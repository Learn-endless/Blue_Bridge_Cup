package com.lanqiaobei.learn;

/**
  * ����ʽ
 * @author ֻ��������
 *
 */
public class TestDemo4 {
	//����ͳ���м�����
	public static int count = 0;
	public static void main(String[] args) {
		//������� 1 - 9 �����Ƿ�ʹ��
		boolean[] flg = new boolean[10];
		//�������ÿһ���9������(�±�0�Ŀռ䲻ʹ��,��1�±꿪ʼ)
		int[] number = new int[10];
		//�ݹ����
		dfs(1, number, flg);
		System.out.println(count);
	}

	/**
	  *  �����㷨
	 * @param total
	 * @param number
	 * @param flg
	 */
	private static void dfs(int total, int[] number, boolean[] flg) {
		//�ݹ���ֹ����:ÿ�ҵ� 9 ����,���һ��
		if(total == 10) {
			if(checkNumber(number)) {
				//������ĿҪ��,ͳ��+1
				count++;
			}
			//������ǰ�ݹ�
			return;
		}
		//ѭ�����Է����� 1 - 9
		for(int i = 1; i <= 9; i++) {
			//�ȼ�鵱ǰ�����Ƿ��Ѿ�ʹ��
			if(flg[i] == false) {
				//û��ʹ��,����ѭ��,������ǰ����״̬���Ϊ ��ʹ��
				flg[i] = true;
				//�����ַŵ� number ����ȥ
				number[total] = i;
				//���еݹ� , ����һ������
				dfs(total+1,number,flg);
				//���л���,���Ϊ δʹ��
				flg[i] = false;
			}
		}
	}

	/**
	  * ��� ��ǰ���������Ƿ����� ��ĿҪ��
	 * @param number
	 * @return
	 */
	private static boolean checkNumber(int[] number) {
		// ��ĿҪ��: A+B/C+DEF/GHI == 10
		double a = number[1];                               //A
		double b = 1.0*number[2]/number[3];                 //B/C
		double x = number[4] * 100+number[5] * 10+number[6];//DEF
		double y = number[7] * 100+number[8] * 10+number[9];//GHI
		double c = x/y;                                     //DEF/GHI
		if(a+b+c == 10.0) {
			//�ж� A+B/C+DEF/GHI �Ƿ���� 10
			return true;
		}
		return false;
	}
}
