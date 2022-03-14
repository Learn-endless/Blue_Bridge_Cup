import java.util.*;
public class TestDemo5 {
	/**
	 * BASIC-9	特殊回文数
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 10000; i < 1000000; i++) {
			if(checkXiangDeng(i,n) && checkHuiWen(i)) {
				System.out.println(i);
			}
		}
	}

	/**
	 * 检查是否相等
	 * @param i     需要判断的数据
	 * @param data  输入的数据
	 * @return
	 */
	private static boolean checkXiangDeng(int i,int data) {
		int sum = 0;
		while(i != 0) {
			sum += i % 10;
			i /= 10;
		}
		if(data == sum) {
			return true;
		}
		return false;
	}

	/**
	  * 判断是否是回文数
	 * @param i   一个整数
	 * @return
	 */
	private static boolean checkHuiWen(int i) {
		StringBuilder s = new StringBuilder(i+"");
		int left = 0;
		int right = s.length()-1;
		while(left < right) {
			if(s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
