
public class TestDemo4 {
	public static void main(String[] args) {
		int[] array = new int[10];
		
		for(int i = 0; i <= 9; i++) {
			array[i] = 2021;
		}
		for(int i = 0; ; i++) {
			int n = i;
			while(n != 0) {
				int ret = n % 10;
				if(array[ret] != 0) {
					array[ret]--;
				}else {
					System.out.println(i-1);
					return;
				}
				n /= 10;
			}
		}
	}
}
