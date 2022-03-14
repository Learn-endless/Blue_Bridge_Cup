
/**
 * BASIC-8	回文数
 * @author 只爱吃土豆
 *
 */
public class TestDemo6 {
	public static void main(String[] args) {
		for(int i = 1000; i < 10000; i++) {
			if(checkHuiWen(i)) {
				System.out.println(i);
			}
		}
	}

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
