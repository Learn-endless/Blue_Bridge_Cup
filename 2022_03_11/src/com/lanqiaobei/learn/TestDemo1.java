package com.lanqiaobei.learn;

/**
  * ���⣺�ֻ���
 * @author 19833
 *
 */
public class TestDemo1 {
	public static int count = 0;
	public static void main(String[] args) {
		int[] array = {9,8,7,6,5,4,3,2,1,0};
		int[] tmp = new int[3];
		dfs(array,0,tmp);
		System.out.println(count);
	}

	/**
	  * ���ݷ�
	 * @param array ��� 0-9 �����ֵ�����
	 * @param depth λ��
	 * @param tmp   ���λ��������
	 */
	private static void dfs(int[] array, int depth,int[] tmp) {
		//������ �ﵽ ��3
		if(depth == 3) {
			//����Ƿ����Ҫ��
			if(checkNumber(tmp)) {
				count++;
			}
			return;
		}
		//�����ݹ��ȥ,�������
		for(int i = 9;i >= 0; i--) {
			tmp[depth] = i;
			dfs(array,depth+1,tmp);
			//������Ҫ����
			tmp[depth] = 0;
		}
	}

	/**
	  *  ��鵱ǰ tmp  �е������Ƿ� ��һ������Ҫ��� 3Ϊ��
	 * @param tmp  ����� һ�� 3λ����
	 * @return     ���� һ�� boolean ֵ
	 */
	private static boolean checkNumber(int[] tmp) {
		//��һλ����� 0 ,��˵������һ����λ��
		if(tmp[0] == 0) {
			return false;
		}
		//�����ǲ��� ����,������û���ظ�
		for(int i = 0; i < 2; i++) {
			if(tmp[i] <= tmp[i+1]) {
				return false;
			}
		}
		return true;
	}
}
