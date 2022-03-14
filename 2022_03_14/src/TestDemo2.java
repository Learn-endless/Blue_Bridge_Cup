import java.util.*;
public class TestDemo2{
	/**
	 * BASIC-10	十进制转十六进制
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(num == 0) {
			System.out.println(0);
			return;
		}
		
		StringBuilder s = new StringBuilder();
		while(num != 0) {
			int ret = num % 16;
			switch(ret) {
				case 0:  s.insert(0, "0"); break;
				case 1:  s.insert(0, "1"); break;
				case 2:  s.insert(0, "2"); break;
				case 3:  s.insert(0, "3"); break;
				case 4:  s.insert(0, "4"); break;
				case 5:  s.insert(0, "5"); break;
				case 6:  s.insert(0, "6"); break;
				case 7:  s.insert(0, "7"); break;
				case 8:  s.insert(0, "8"); break;
				case 9:  s.insert(0, "9"); break;
				case 10: s.insert(0, "A"); break;
				case 11: s.insert(0, "B"); break;
				case 12: s.insert(0, "C"); break;
				case 13: s.insert(0, "D"); break;
				case 14: s.insert(0, "E"); break;
				case 15: s.insert(0, "F"); break;
				default:break;
			}
			num /= 16;
		}
		System.out.println(s.toString());
	}
}