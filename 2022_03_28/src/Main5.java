
public class Main5 {
	/**
	 * 01背包问题：动态规划
	 * @param price
	 * @param size
	 * @param bag
	 * @return
	 */
	public static int zeroOneBag(int[] price, int[] size, int bag) {
		int n = price.length;
		
		//状态定义
		int[][] mat = new int[n+1][bag+1];
		//因为数组本身初始化就是 0 ，所以这里不用手动将 mat[0][j] = 0 和 mat[i][j] = 0;
		
		//直接遍历
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= bag; j++) {
				//两种状态转移方程：
				//当不放第 i 个商品的时候(第i件商品的体积本身就大于 当前背包 j 的容量)
				if(j < size[i-1]) {
					//这里 第 i 件商品的体积 在 size 数组中是从 0 开始的
					//不放第 i 件商品
					mat[i][j] = mat[i-1][j];
					
				}else {
					//放第 i 件商品的情况：
					mat[i][j] = Math.max(mat[i-1][j-size[i-1]]+price[i-1], mat[i-1][j]);
				}
			}
		}
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= bag; j++) {
				System.out.printf("%3d",mat[i][j]);
			}
			System.out.println();
		}
		return mat[n][bag];
	}
	
	/**
	 * 01背包问题 ： 优化版本：使用一维数组(直接舍去上一行之上的数据)
	 * @param price
	 * @param size
	 * @param bag
	 * @return
	 */
	public static int zeroOneBag1(int[] price, int[] size, int bag) {
		int n = price.length;
		
		//状态定义
		int[] mat = new int[bag+1];
		//因为数组本身初始化就是 0 ，所以这里不用手动将 mat[0][j] = 0 和 mat[i][j] = 0;
		
		//直接遍历
		for(int i = 1; i <= n; i++) {
			for(int j = bag; j >= 0; j--) {
				//状态转移方程就只有一种情况了：
				if(size[i-1] <= j){
					//放第 i 件商品的情况：
					mat[j] = Math.max(mat[j-size[i-1]]+price[i-1], mat[j]);
				}
			}
		}
		
		for(int i = 0; i <= bag; i++) {
			System.out.printf("%3d",mat[i]);
		}
		return mat[bag];
	}
	
	public static void main(String[] args) {
		int[] price = {3,1,5,7,9};
		int[] size = {1,4,2,3,6};
		int bag = 10;
		int ret = zeroOneBag1(price,size,bag);
		System.out.println();
		System.out.println(ret);
	}
}
