import java.util.*;
public class TestDemo5 {
	/**
	 * BASIC-9	���������
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
	 * ����Ƿ����
	 * @param i     ��Ҫ�жϵ�����
	 * @param data  ���������
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
	  * �ж��Ƿ��ǻ�����
	 * @param i   һ������
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
