package com.lanqiaobei.learn;

public class TestDemo6 {
	/**
	 * dfs�㷨
	 * @param a ��Ź��Һ�ÿ�������ɳ������������Ϣ
	 * @param k ��ŵ�ǰ�ݷõ��ڼ���������
	 * @param n ��ǰ�۲��Ż��м���������λ
	 * @param s ���ÿ��۲��ŵ���Ա
	 */
	public static void f(int[] a, int k, int n, String s)
	{
		//�ݹ�������� : ÿ�����Ҷ��ʹ�
		if(k==a.length){ 
			//��������������,��ӡ��һ�����Ա
			if(n==0) System.out.println(s);
			return;
		}
		
		String s2 = s; //����ǰ��ȷ������Ա��ŵ� s2 ��
		for(int i=0; i<=a[k]; i++){
			f(a,k+1,n-i,s2);   //���λ��
			s2 += (char)(k+'A');
		}
	}
	
	public static void main(String[] args)
	{
		//����������,��Ӧ����ĸ���.
		//��������ݶ�Ӧÿ���������� �ɳ����������
		int[] a = {4,2,2,1,1,3};
		
		//��5����Ϊ �۲��� ��������� ���Ϊ 5 ��
		f(a,0,5,"");
	}
}
