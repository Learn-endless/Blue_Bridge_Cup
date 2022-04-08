package 八次求和;

import java.util.Scanner;

public class Main3 {
	
	public static void main(String[] args)
	{
		/*
		 * 为什么将所有的数据类型都改成long类型呢?
		 * 因为评测用例规模与约定中对于所有评测用例，1≤n≤1000000。
		 * 如果是int类型的话,n*n在n=1000000的时候会溢出
		 */
		Scanner in = new Scanner(System.in);
		long n=in.nextLong();
		in.close();
		int mod=123456789;
		long result=0;
		long temp=1;
		
		//for循环遍历1到n的每一个数的八次方
		for(long x=1;x<=n;x++)
		{
			//下面一个for循环就是得到x的八次方的值,每一次都初始化temp的值
			temp=1;
			for(int y=1;y<=4;y++)
			{
				//进行四次循环,每一次都是x的平方,而且每一次平方后都取模
				//这样保证它不会溢出
				temp =(temp*((x*x) %mod))%mod; 
			}
			//将x的八次方加起来,进入下一个x的八次方
			result =(result+temp)%mod;
		}
		System.out.println(result);
	}
}
