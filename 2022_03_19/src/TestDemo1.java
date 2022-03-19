import java.util.*;
public class TestDemo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] count = new int[20];
		count[0] = 3;
		if(n == 1) {
			System.out.println(1);
		}else {
			int[] ret = {1,1};
			while(true) {
				int[] tmp = new int[ret.length+1];
				int len = tmp.length;
				
				for(int i = 0; i < len; i++) {
					
					func(count);
					if(i == 0 || i == len-1) {
						tmp[i] = 1;
					}else {
						tmp[i] = ret[i]+ret[i-1];
						if(tmp[i] == n) {
							print(count);
							return;
						}
					}
				}
				ret = tmp;
			}
		}
	}

	private static void print(int[] count) {
		boolean flg = false;
		for(int i = count.length-1; i >= 0; i--) {
			if(count[i] != 0) {
				flg = true;
			}
			if(flg) {
				System.out.print(count[i]+"");
			}
		}
	}

	private static void func(int[] count) {
		int ret = 0;
		for(int i = 0; i < count.length; i++) {
			int num = count[i] + 1 + ret;
			count[i] = num % 10;
			ret = num / 10;
		}
	}
}
