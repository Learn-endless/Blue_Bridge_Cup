/**
 * BASIC-7	特殊的数字
 * @author 只爱吃土豆
 *
 */
public class TestDemo7 {
	public static void main(String[] args) {
		for(int i = 100; i < 1000; i++) {
			if(checkNumber(i)) {
				System.out.println(i);
			}
		}
	}

	private static boolean checkNumber(int i) {
		int n = i;
		int sum = 0;
		while(i != 0) {
			sum += Math.pow((i%10), 3);
			i /= 10;
		}
		if(sum == n) {
			return true;
		}
		return false;
	}
}
