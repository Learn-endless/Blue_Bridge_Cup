
public class TestDemo7 {
	/**
	 * 
          *   九数组分数
     * 1,2,3...9 这九个数字组成一个分数，其值恰好为1/3，如何组法？
	 * @param x
	 */
	public static void test(int[] x)
	{
		int a = x[0]*1000 + x[1]*100 + x[2]*10 + x[3];
		int b = x[4]*10000 + x[5]*1000 + x[6]*100 + x[7]*10 + x[8];		
		if(a*3==b) System.out.println(a + " " + b);
	}
	
	public static void f(int[] x, int k)
	{
		if(k>=x.length){
			test(x);
			return;
		}
		
		for(int i=k; i<x.length; i++){
			//回溯算法: 先试探
			{int t=x[k]; x[k]=x[i]; x[i]=t;}
			//递归进去
			f(x,k+1);
			//然后进行 逆操作(相当于这条路走不通,又走回来选另一条路来走)
			{int t=x[k]; x[k]=x[i]; x[i]=t;}       // 填空
		}
	}
	
	public static void main(String[] args)
	{
		int[] x = {1,2,3,4,5,6,7,8,9};		
		f(x,0);
	}
}
