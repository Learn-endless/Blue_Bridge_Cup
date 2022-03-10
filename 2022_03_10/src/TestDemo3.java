import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class TestDemo3 {
	
	/**
	  *  求出一个数组全排列
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int len = arr.length;
		//用来存放 全部 的排列 结果,每一个结果都是一个 List<Integer>
		List<List<Integer>> list = new ArrayList<>();
		//用来存放 每一组 排列 的数据
		Stack<Integer> stack = new Stack<>();
		//用来记录 arr 数组中每个值的 状态:是否已经被使用
		boolean[] used = new boolean[len];
		
		//回溯算法(深度优先遍历)
		dfs(arr,len,0,stack,used,list);
		
		System.out.println(list);
		
	}

	/**
	  *  回溯算法(深度优先算法)
	 * @param arr      需要全排列的数组
	 * @param len      数组的长度
	 * @param depth    用来记录递归到第几层
	 * @param stack    用来存放每一组的数据
	 * @param used     用来记录每个数据是否使用
	 * @param list     存放所有的 排列的情况
	 */
	private static void dfs(int[] arr, int len, int depth, Stack<Integer> stack, boolean[] used, List<List<Integer>> list) {
		//递归结束条件:当前深度 == 数组的长度
		if(depth == len) {
			//将已经放好的一组数据放入 list
			list.add(new ArrayList<>(stack));  //注意这里使用 新的 对象,因为递归 回溯会到 根节点(根节点是一个空节点)
			return;
		}
		//每一次递归进来,都会从整个数组中找元素
		for(int i = 0; i < len; i++) {
			//先判断当前元素是否已经被放入 stack 中
			if(used[i] == true) {
				//找下一个
				continue;
			}
			//没有就放入 stack 中
			stack.push(arr[i]);
			//更改当前元素的 状态
			used[i] = true;
			//开始递归
			dfs(arr,len,depth+1,stack,used,list);
			//注意:当这里 回溯 回来之后,我们就需要 进行 逆操作(这一步至关重要)
			
			//删除上面添加的 stack 中的值
			stack.pop();
			//更新状态
			used[i] = false;
		}
		
	}
}
