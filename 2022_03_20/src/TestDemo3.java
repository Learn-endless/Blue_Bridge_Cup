
import java.util.*;
public class TestDemo3 {
	
	public static int N = 100010;
	
	static class Node{
		public int p;      //代表操作
		public int q;      //代表所需要操作的下标
		
		public Node(int p , int q) {
			this.p = p;
			this.q = q;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node[] tmp = new Node[6];
		
		int n = sc.nextInt();     //序列长度 : 1 2 3 ... n
		int m = sc.nextInt();     //操作的次数
		
		int top = 0; //用来维护 tmp 数组
		
		while(m-- != 0) {
			
			int p = sc.nextInt();
			int q = sc.nextInt();  //用来接收没对操作数
			
			if(p == 0) {
				//判断是不是连续的 降序排列
				while(top != 0 && tmp[top].p == 0) {
					//是升序,找到最大的 q
					q = Math.max(q,tmp[top--].q);
				}
				while(top >= 2 && tmp[top-1].q <= q) {
					top -= 2;
				}
				tmp[++top] = new Node(0,q);
				
			}else if(top != 0) {
				while(top != 0 && tmp[top].p == 1) {
					q = Math.min(q, tmp[top--].q);
				}
				while(top >= 2 && tmp[top-1].q >= q) {
					top -= 2;
				}
				tmp[++top] = new Node(1,q);
			}
		}
		
		int k = n; 
		int l = 1;
		int r = n;
		int[] ans = new int[n+1];
		
		for(int i = 1; i <= top; i++) {
			if(tmp[i].p == 0) 
				while(r > tmp[i].q && l <= r) ans[r--] = k--;
			else 
				while(l < tmp[i].q && l <= r) ans[l++] = k--;

		}
		
		if(top % 2 == 1) {
			while(l <= r) {
				ans[l++] = k--;
			}
		}else {
			while(l <= r) {
				ans[r--] = k--;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
