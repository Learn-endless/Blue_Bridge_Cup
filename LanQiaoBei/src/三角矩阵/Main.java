package 三角矩阵;

public class Main {
	/**
	 * 自底向上
	 * @param array
	 * @return
	 */
	private static int func(int[][] array) {
		int n = array.length;
		for(int i = n-2; i >= 0; i--) {
			for(int j = i; j >= 0; j--) {
				array[i][j] = Math.min(array[i+1][j],array[i+1][j+1])+array[i][j];
			}
		}
		return array[0][0];
	}
	
	public static void main(String[] args) {
		int[][] array = {{2},{3,4},{6,5,7},{4,1,8,3}};
		int ret = func1(array);
		System.out.println(ret);
	}
	
	/**
	 * 自顶向下
	 * @param array
	 * @return
	 */
	private static int func1(int[][] array) {
		int n = array.length;
		for(int i = 1; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if(i == j) {
					array[i][j] += array[i-1][j-1];
				}else {
					array[i][j] = Math.min(array[i][j], array[i][j+1])+array[i-1][j];
				}
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
		int min = array[n-1][0];
		for(int i = 1; i < n; i++) {
			min = Math.min(min, array[n-1][i]);
		}
		return min;
	}
}
