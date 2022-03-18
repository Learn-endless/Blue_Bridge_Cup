
import java.util.*;
public class TestDemo5 {
	/**
	 * 试题 基础练习 分解质因数
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//输入一个范围[a,b]
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		//遍历这个范围中的每个数
		for(int i = a; i <= b; i++) {
			//首先判断是不是一个素数
			if(isPrime(i)) {
				//是素数直接输出
				System.out.println(i+"="+i);
			}else {
				//是合数 就从小到大找出它的质因数   - 返回的是一个字符串
				String ret = handleComposite(i); 
				//打印出来
				System.out.println(i+"="+ret);
			}
		}
	}

	/**
	  * 用来处理 每一个合数的质因数
	 * @param n 一个合数
	 * @return  返回质因数组成的字符串
	 */
	private static String handleComposite(int n) {
		StringBuilder s = new StringBuilder();
		//一直循环到当前这个合数,整除到 1 为止
		while(n != 1) {
			//从2开始循环除以当前的合数
			for(int i = 2; i <= n; i++) {
				//判断能否 被当前的 i 给整除,并且被整除的数是不是素数
				if(n % i == 0 && isPrime(i)) {
					//到这里,说明当前的 i 是 n 的一个质因数
					s.append(i+"*");
					//n整除掉i
					n /= i;
					//跳出去寻找下一个质因数
					break;
				}
			}
		}
		//删除掉 s 字符串中最后的一个 * 号
		s.delete(s.length()-1, s.length());
		return s.toString();
	}

	/**
	 * 判断一个数是不是一个素数
	 * @param data 一个数
	 * @return     返回一个 boolean值
	 */
	private static boolean isPrime(int data) {
		//遍历 2 - data的平方根,如果这个之间没有能够整除 data 的数据,说明data就是一个素数
		for(int i = 2; i <= Math.sqrt(data); i++) {
			if(data % i == 0) {
				return false;
			}
		}
		return true;
	}
}
