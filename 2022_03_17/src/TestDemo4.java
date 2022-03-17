
import java.util.*;
public class TestDemo4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int timeTotal = sc.nextInt();
		if(timeTotal == 0) {
			System.out.println("0:0:0");
		}else {
			int time = timeTotal / 3600;
			int minute = timeTotal % 3600 / 60;
			int second = timeTotal % 60;
			System.out.println(time+":"+minute+":"+second);
		}
	}
}
