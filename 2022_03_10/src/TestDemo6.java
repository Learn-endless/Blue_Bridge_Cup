import java.util.Vector;

public class TestDemo6 {
	/**
	  * ѭ���ڳ���
	 * @param n  һ������
	 * @param m  ��һ������
	 * @return   ����ѭ���ڵĳ���
	 */ 
	public static int f(int n, int m){
		n = n % m;	
		// �൱��һ����̬����(ջʵ�ֵ�)
		Vector v = new Vector();
		
		for(;;)
		{
			v.add(n);
			n *= 10;
			n = n % m;
			if(n==0) return 0;
			if(v.indexOf(n)>=0)  return v.size() ;  //���
		}
	}
	public static void main(String[] args) {
		int n = 11;
		int m = 13;
		int count = f(n,m);
		System.out.println(count);
		
	}
}
