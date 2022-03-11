/**
 * 牌型种数
 * @author 只爱吃土豆
 *
 */
public class TestDemo9 {
	public static int count = 0;
	public static void main(String[] args) {
		//使用深度优先搜索算法 -- 回溯算法
		dfs(0,0);           //传入两个参数,树的深度(也就是控制递归的条件),小明手中的牌数.
		System.out.println(count);
	}

	private static void dfs(int depth, int sum) {
		//如果 depth 大于13 或者 sum(总数) 超过了 13,直接结束当前递归,回溯 选择另一种 方案
		if(depth > 13 || sum > 13) return ;
		if(depth == 13 && sum == 13) {
			//说明有了满足要求的 13 张牌,统计一下
			count++;
		}
		//如果 depth < 13 并且 sum < 13,说明 13 张类型的 牌 还没有选完,需要继续递归下去
		for(int i = 0; i < 5 ;i++) {
			// 每进入一层 depth ,我们都可以选择 0张,1张,2张,3张或者4张.
			// 所以我们需要用一个 for 循环来表示所以的选择
			
			sum += i;          //将当前选择的点数加到 sum 中
			dfs(depth+1,sum);  //往下一层递归
			sum -= i;          //回溯sum的值
		}
	}
}
