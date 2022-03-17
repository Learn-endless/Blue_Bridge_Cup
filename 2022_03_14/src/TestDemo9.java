import java.util.*;
/**
 * BASIC-5	查找整数
 * @author 只爱吃土豆
 *
 */
public class TestDemo9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>(input);
		for(int i = 0; i < input; i++) {
			list.add(sc.nextInt());
		}
		int ret = sc.nextInt();
		int tmp = list.indexOf(ret);
		if(tmp == -1) {
			System.out.println(tmp);
		}else {
			System.out.println(tmp+1);
		}
	}
}
