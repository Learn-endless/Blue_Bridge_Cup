/**
 * 198. 打家劫舍 leetcode
 * @author 19833
 *
 */
public class TestDemo13 {
	public static void main(String[] args) {
		int[] array = {2,5,7,4,6,5,2,1,0};
		
		int ret = rob(array);
		System.out.println(ret);
	}

	private static int rob(int[] array) {
		int len = array.length;
		//创建一个 dp 数组
		int[] dp = new int[len];
		//题目要求,不能偷相邻的两户人家
		dp[0] = array[0];
		dp[1] = array[1];
		
		//遍历给 dp 数组开始赋值
		for(int i = 2; i < len ;i++) {
			dp[i] = Math.max(dp[i-2]+array[i], dp[i-1]);
		}
		//最后一个值就是能够偷盗的最多的金币
		return dp[len - 1];
	}
}
