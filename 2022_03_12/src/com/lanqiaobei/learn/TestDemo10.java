package com.lanqiaobei.learn;

import java.util.Arrays;
import java.util.Scanner;

/**
  * ��ƽ����
 * @author 19833
 *
 */
public class TestDemo10 {
	//��� ��ƽ���͵�����
	public static int[] tmp = new int[4];
	//�ҵ���һ����,��ʶһ��
	public static boolean flg;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//ѭ������
		while(sc.hasNextInt()) {
			int input = sc.nextInt();
			//������� ����ƽ����
			int n = (int) Math.sqrt(input);
			//���� flg �Ǹ���̬��Ա����,�����������ʼ����
			flg = false;
			//��ʼ �ݹ�Ѱ�� ����
			dfs(0,input,n);
			System.out.println(tmp[0]+" "+tmp[1]+" "+tmp[2]+" "+tmp[3]);
		}
		
	}

	/**
	  * ����Ѱ��ƽ��������
	 * @param depth   ��¼Ѱ�ҵ�������
	 * @param input   �������
	 * @param n       ����ܹ����Ե�����
	 */
	private static void dfs(int depth, int input, int n) {
		//�ҵ��� 4 ����
		if(depth == 4) {
			//��� ��ƽ�� �� �ǲ��� ���� input
			if(check(input)) {
				//������
				Arrays.sort(tmp);
				//�����
				flg = true;
			}
			return;
		}
		//�����һ�εݹ��������� true,��ʾ�Ѿ��ҵ���,ֱ�ӷ���
		if(flg == true) {
			return;
		}
		//ѭ������ 0 - n ������
		for(int i = 0; i <= n; i++) {
			//�ж��ҵ���һ��û��
			if(flg == true) {
				return;
			}else {
				//��������� �ŵ� tmp ��ȥ
				tmp[depth] = i;
				//�ݹ�Ѱ����һ������
				dfs(depth+1,input,n);
			}
		}
	}

	/**
	  * ��鵱ǰ�� �ĸ����� �ܲ������� ��ƽ���� == input
	 * @param input  ���������
	 * @return       ���� true �� false
	 */
	private static boolean check(int input) {
		int ret = (int) (Math.pow(tmp[0], 2)+Math.pow(tmp[1], 2)+Math.pow(tmp[2], 2)+Math.pow(tmp[3], 2));
		if(ret == input) {
			return true;
		}
		return false;
	}
}
