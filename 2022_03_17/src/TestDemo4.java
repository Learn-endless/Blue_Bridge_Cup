
import java.util.*;
/**
 * BASIC-14	VIP试题 时间转换
 * @author 19833
 *
 */
public class TestDemo4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int timeTotal = sc.nextInt();
		if(timeTotal == 0) {
			System.out.println("0:0:0");
		}else {
			//取出 时
			int time = timeTotal / 3600;
			//取出 分
			int minute = timeTotal % 3600 / 60;
			//取出 秒
			int second = timeTotal % 60;
			System.out.println(time+":"+minute+":"+second);
		}
	}
}
