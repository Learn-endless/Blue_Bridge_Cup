
import java.util.*;
public class TestDemo4 {
	
	/**
	  * 存放每组的操作参数
	 */
	static class Node{
		public int p;        //方式
		public int q;        //参数
		
		//构造方法
		public Node(int p, int q) {
			this.p = p;
			this.q = q;
		}
	}
	
	public static int N = 7;    //最大的操作次数
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Node[] tmp = new Node[N];    //存放全部的操作次数
		int top = 0;                 //用来统计当前tmp数组中有效的操作次数
		
		int n = sc.nextInt();        //表示序列的长度
		int m = sc.nextInt();        //表示操作的次数
		int[] ans = new int[n+1];    //用来存放结果数组
		
		//循环输入每次的操作
		while(m-- != 0) {
			
			int p = sc.nextInt();  //操作的方式:降序/升序
 			int q = sc.nextInt();  //操作那些参数
 			
 			//如果是降序操作
 			if(p == 0) {
 				//找出连续的降序操作的最大值
 				while(top != 0 && tmp[top].p == 0)  q = Math.max(q, tmp[top--].q);
 				//删除连续的降序操作
 				while(top >= 2 && tmp[top-1].q <= q) top -= 2;
 				//将找到的最大降序操作的值放到 tmp 中
 				tmp[++top] = new Node(0,q);
 			
 			}else {
 				//同理找到连续的升序操作的最小值
 				while(top != 0 && tmp[top].p == 1) q = Math.min(q, tmp[top--].q);
 				//删除连续的升序操作
 				while(top >= 2 && tmp[top-1].q >= q) top -= 2;
 				//更新当前操作到 tmp 中去
 				tmp[++top] = new Node(1,q);
 			}
		}
		
		int k = n;   //当前需要操作序列中最右边的最大值
		int l = 1;   //左下标
		int r = n;   //右下标
		
		//遍历当前的所有操作(注意top在上面赋值时,是++top)
		for(int i = 1; i <= top; i++) {
			//如果当前操作是 0 降序操作
			if(tmp[i].p == 0) {
				//从后往前填充
				while(r > tmp[i].q && l <= r)  ans[r--] = k--;
			}else {
				//从前往后填充
				while(l < tmp[i].q && l <= r)  ans[l++] = k--;
			}
		}
		
		//处理 l 到  r 之间的区域
		if(top % 2 == 1) {
			//从前往后填充
			while(l <= r) ans[l++] = k--;
		}else {
			//从后往前填充
			while(l <= r) ans[r--] = k--;
		}
		
		//循环打印出结果
		for(int i = 1; i <= n; i++) {
			System.out.print(ans[i]+" ");
		}
	}
}



