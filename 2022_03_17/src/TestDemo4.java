
import java.util.*;
/**
 * BASIC-14	VIP���� ʱ��ת��
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
			//ȡ�� ʱ
			int time = timeTotal / 3600;
			//ȡ�� ��
			int minute = timeTotal % 3600 / 60;
			//ȡ�� ��
			int second = timeTotal % 60;
			System.out.println(time+":"+minute+":"+second);
		}
	}
}
