import java.util.*;
public class TestDemo10 {
	/**
	 * BASIC-4	ÊıÁĞÌØÕ÷
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int[] array = new int[input];
		for(int i = 0; i < input; i++) {
			array[i] = sc.nextInt();
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int i = 0; i < input; i++) {
			if(max < array[i]) {
				max = array[i];
			}
			if(min > array[i]) {
				min = array[i];
			}
			sum += array[i];
		}
		System.out.println(max);
		System.out.println(min);
		System.out.println(sum);
	}
}
