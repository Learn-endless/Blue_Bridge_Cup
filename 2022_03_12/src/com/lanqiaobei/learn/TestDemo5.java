package com.lanqiaobei.learn;

public class TestDemo5{
	/**
	 * 这个方法 用来确定 第三组 的三个成员
	 * @param a
	 * @return
	 */
	public static String remain(int[] a)
	{
		String s = "";
		for(int i=0; i<a.length; i++){
			if(a[i] == 0) s += (char)(i+'A');
		}	
		return s;  //返回一个字符串
	}
	
	public static void f(String s, int[] a)
	{
		//第一个for 确定 第二组 第一个人
		for(int i=0; i<a.length; i++){
			if(a[i]==1) continue;   //检查是否重复
			a[i] = 1;
			//第二个for 确定 第二组 第二个人
			for(int j=i+1; j<a.length; j++){
				if(a[j]==1) continue;   //同上
				a[j]=1;
				//第三个for 确定 第二组 第三个人
				for(int k=j+1; k<a.length; k++){
					if(a[k]==1) continue;
					a[k]=1;
					//将各个成员打印出来
					System.out.println(s+" "+(char)('A'+i)+(char)('A'+j)+(char)('A'+k)+" "+remain(a));  //填空位置
					a[k]=0; //状态清零,好下一次又可以派他
				}
				a[j]=0;   //同上
			}
			a[i] = 0;   //同上
		}
	}
	
	public static void main(String[] args)
	{
		int[] a = new int[9];		
		a[0] = 1;    //确定的第一组的第一个成员
		
		for(int b=1; b<a.length; b++){
			a[b] = 1; //这层循环 确定了 第一组 的第二个成员
			for(int c=b+1; c<a.length; c++){
				a[c] = 1; //这层确定第一组第三个成员
				//将这三个成员处理成一个字符串
				String s = "A" + (char)(b+'A') + (char)(c+'A');
				f(s,a);    //递归找后面的成员
				a[c] = 0;  //这里进行回溯
			}
			a[b] = 0;
		}
	}
}