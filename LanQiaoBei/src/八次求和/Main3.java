package �˴����;

import java.util.Scanner;

public class Main3 {
	
	public static void main(String[] args)
	{
		/*
		 * Ϊʲô�����е��������Ͷ��ĳ�long������?
		 * ��Ϊ����������ģ��Լ���ж�����������������1��n��1000000��
		 * �����int���͵Ļ�,n*n��n=1000000��ʱ������
		 */
		Scanner in = new Scanner(System.in);
		long n=in.nextLong();
		in.close();
		int mod=123456789;
		long result=0;
		long temp=1;
		
		//forѭ������1��n��ÿһ�����İ˴η�
		for(long x=1;x<=n;x++)
		{
			//����һ��forѭ�����ǵõ�x�İ˴η���ֵ,ÿһ�ζ���ʼ��temp��ֵ
			temp=1;
			for(int y=1;y<=4;y++)
			{
				//�����Ĵ�ѭ��,ÿһ�ζ���x��ƽ��,����ÿһ��ƽ����ȡģ
				//������֤���������
				temp =(temp*((x*x) %mod))%mod; 
			}
			//��x�İ˴η�������,������һ��x�İ˴η�
			result =(result+temp)%mod;
		}
		System.out.println(result);
	}
}
