import java.util.Vector;

public class TestDemo6 {
	/**
	  * 循环节长度
	 * @param n  一个整数
	 * @param m  另一个整数
	 * @return   返回循环节的长度
	 */ 
	public static int f(int n, int m){
		n = n % m;	
		// 相当于一个动态数组(栈实现的)
		Vector v = new Vector();
		
		for(;;)
		{
			v.add(n);
			n *= 10;
			n = n % m;
			if(n==0) return 0;
			if(v.indexOf(n)>=0)  return v.size() ;  //填空
		}
	}
	public static void main(String[] args) {
		int n = 11;
		int m = 13;
		int count = f(n,m);
		System.out.println(count);
		
	}
}
