import java.util.*;
/**
 * BASIC-6	杨辉三角形
 * @author 只爱吃土豆
 *
 */
public class TestDemo8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 1) {
			System.out.println("1");
		}else{
			System.out.println("1");
			System.out.println("1 1");
			prinfYangHuiSanJiao(n);
		}
	}

	private static void prinfYangHuiSanJiao(int n) {
		int[][] arr = new int[n][n];
		arr[0][0] = 1;
		arr[1][0] = 1;
		arr[1][1] = 1;
		for(int i = 2; i < n; i++) {
			arr[i][0] = 1;
			System.out.print("1 ");
			for(int j = 1; j < i; j++) {
				arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
				System.out.print(arr[i][j] + " ");
			}
			arr[i][i] = 1;
			System.out.println("1");
		}
	}
}
