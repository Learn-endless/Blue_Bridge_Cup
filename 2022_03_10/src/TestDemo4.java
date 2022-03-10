
/**
 * 蓝桥杯: 三羊献瑞
 * @author 19833
 *
 */
public class TestDemo4 {
	public static void main(String[] args) {
		//创建一个数组,用来表示  三 羊 献 瑞 祥 生 辉 气
		int[] arr = new int[8];
		//自定义函数,用来找出 符合 题目要求 的数
		dfs(arr,0);
	}

	private static void dfs(int[] a, int n) {
		//说明 a 数组 中的所有数都找完了
		if(n == 8) {
			//判断当前数组中的数是不是满足要求
			if(checkArray(a) == true) {
				//找到了合适的数,就将  三 羊 献 瑞  所对应的数字打印出来
				System.out.println(a[0]+""+a[1]+a[2]+a[3]);
			}
		}else {
			//说明还没有找满 8 个数
			for(int i = 0; i < 10; i++) {
				//每个位上的数字范围:0-9
				a[n] = i;   //将数字复制到当前 n 所指的位置
				//检查一下当前所填数字是否满足要求: a[0] 只能是 1,a数组中的数字不能重复
				if(check(a,n) == true) {
					//递归后一位数字
					dfs(a,n+1);
				}
			}
		}
	}

	/**
	 * 检查是否符合 题目要求: a[0] == 1, a数组中的数字不能出现重复
	 * @param a  存放  三 羊 献 瑞 祥 生 辉 气 的数组
	 * @param n  当前第几位
	 * @return   返回检查结果
	 */
	private static boolean check(int[] a, int n) {
		//如果 当前 是第一位数字
		if(n == 0) {
			//判断一下是不是 1
			if(a[n] != 1) {
				//告诉 dfs 方法 不用往下递归了
				return false;
			}
		}else {
			//不是第一位,就要检查 当前 赋的值 在前面出现过没有
			for(int i = 0; i < n; i++) {
				if(a[i] == a[n]) {
					//也不用递归下去了
					return false;
				}
			}
		}
		//符合条件,返回一个true,进行下一位的查找
		return true;
	}

	/**
	 * 检查 当前 所 找到的一组数 能不能满足 题目要求
	 * @param a  一个数组
	 * @return   true 或 false
	 */
	private static boolean checkArray(int[] a) {
		int x = a[0]*1000+a[1]*100+a[2]*10+a[3];
		int y = a[4]*1000+a[3]*100+a[5]*10+a[6];
		int w = a[0]*10000+a[1]*1000+a[5]*100+a[3]*10+a[7];
		if(x+y == w) {
			return true;
		}
		return false;
	}
}
