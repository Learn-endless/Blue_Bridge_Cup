package com.lanqiaobei.learn;

public class TestDemo5{
	/**
	 * ������� ����ȷ�� ������ ��������Ա
	 * @param a
	 * @return
	 */
	public static String remain(int[] a)
	{
		String s = "";
		for(int i=0; i<a.length; i++){
			if(a[i] == 0) s += (char)(i+'A');
		}	
		return s;  //����һ���ַ���
	}
	
	public static void f(String s, int[] a)
	{
		//��һ��for ȷ�� �ڶ��� ��һ����
		for(int i=0; i<a.length; i++){
			if(a[i]==1) continue;   //����Ƿ��ظ�
			a[i] = 1;
			//�ڶ���for ȷ�� �ڶ��� �ڶ�����
			for(int j=i+1; j<a.length; j++){
				if(a[j]==1) continue;   //ͬ��
				a[j]=1;
				//������for ȷ�� �ڶ��� ��������
				for(int k=j+1; k<a.length; k++){
					if(a[k]==1) continue;
					a[k]=1;
					//��������Ա��ӡ����
					System.out.println(s+" "+(char)('A'+i)+(char)('A'+j)+(char)('A'+k)+" "+remain(a));  //���λ��
					a[k]=0; //״̬����,����һ���ֿ�������
				}
				a[j]=0;   //ͬ��
			}
			a[i] = 0;   //ͬ��
		}
	}
	
	public static void main(String[] args)
	{
		int[] a = new int[9];		
		a[0] = 1;    //ȷ���ĵ�һ��ĵ�һ����Ա
		
		for(int b=1; b<a.length; b++){
			a[b] = 1; //���ѭ�� ȷ���� ��һ�� �ĵڶ�����Ա
			for(int c=b+1; c<a.length; c++){
				a[c] = 1; //���ȷ����һ���������Ա
				//����������Ա�����һ���ַ���
				String s = "A" + (char)(b+'A') + (char)(c+'A');
				f(s,a);    //�ݹ��Һ���ĳ�Ա
				a[c] = 0;  //������л���
			}
			a[b] = 0;
		}
	}
}