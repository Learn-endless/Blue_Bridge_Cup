import java.util.*;
public class TestDemo1 {
	/**
	 * BASIC-01	A+B问题
	 */
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		System.out.println(a+b);
//	}
	/**
	 * BASIC-13	数列排序
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		
		Arrays.sort(array);
		for(int i = 0; i < n; i++) {
			System.out.print(array[i] +" ");
		}
	}
	
}
