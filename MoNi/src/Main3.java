
/**
 * 　有一个整数 A=2021，每一次，可以将这个数加 1 、减 1 或除以 2，其中除以 2 必须在数是偶数的时候才允许。
　　例如，2021 经过一次操作可以变成 2020、2022。
　　再如，2022 经过一次操作可以变成 2021、2023 或 1011。
　　请问，2021 最少经过多少次操作可以变成 1。
 * @author 19833
 *
 */

public class Main3 {
	public static int count = 0;
	public static int[] ret = {1,1,2};
	public static int[] tmp = new int[24];
	public static void main(String[] args) {
		dfs(2021);
	}
	private static void dfs(int data) {
		if(data <= 1) {
			if(data == 1) {
				System.out.println(count);
			}
			return;
		}
			count++;
			if(data % 2 == 0) {
				dfs(data / 2);
			}else {
				dfs(data+1);
				dfs(data-1);
			}
			count--;
	}
}
