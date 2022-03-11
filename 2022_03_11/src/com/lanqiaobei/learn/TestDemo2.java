package com.lanqiaobei.learn;

/**
 * ���⣺��������
 * @author 19833
 *
 */
public class TestDemo2 {
	public static int count = 0;
	public static void main(String[] args) {
		//���������Щ���ֿ���ʹ��
		boolean[] tmp = new boolean[13];
		tmp[7] = true;       //7��11����ʹ��
		tmp[11] = true;
		
		//�������ÿһ��� 11 ������
		int[] array = new int[11];
		//ʹ�� dfs�����㷨
		dfs(0,tmp,array);
		
		System.out.println(count/10);  //��Ϊ������ת 5 ��,ÿ����ת���� һ�� ���� ,�����ܵĴ��� /10
		
	}

	/**
	 * dfs �����㷨
	 * @param depth  ���
	 * @param tmp    ��� 1 - 12�����Ƿ�ʹ�õ����
	 * @param array  ���ÿ�������ĿҪ�������
	 */
	private static void dfs(int depth, boolean[] tmp, int[] array) {
		if(depth == 10) {
			//�������(ÿһ���ն���ֵ��),����������Ƿ����Ҫ��
			if(check(array)) {
				//����
				count++;
			}
			return;
		}
		//����λ���� �յ� ,�������µݹ�
		for(int i = 1 ; i <=12 ; i++ ) {
			//�鿴��ǰ��Ҫ��ŵ���,�Ƿ��Ѿ���ʹ��
			if(tmp[i] == false) {
				//�Ž�ȥ
				array[depth] = i;
				//����ѱ�ʹ��
				tmp[i] = true;
				//�ݹ���һ��,׼���������
				dfs(depth+1,tmp,array);
				//���л���,��ԭ
				array[depth] = 0;
				tmp[i] = false;
			}
		}
	}

	/**
	 * ��鵱ǰ�������Ƿ������ĿҪ��
	 * @param a  һ������
	 * @return   ���� true �� false
	 */
	private static boolean check(int[] a) {
		int a1 = a[0]+a[2]+a[5]+a[8];
		int a2 = a[0]+a[3]+a[6]+a[9];
		int a3 = a[1]+a[2]+a[3]+a[4];
		int a4 = a[1]+a[5]+a[7]+a[9];
		int a5 = a[4]+a[6]+a[7]+a[8];
		if(a1 == a2 && a2 == a3 && a3 == a4 && a4 == a5) {
			return true;
		}
		return false;
	}
}
