import java.util.*;
public class TestDemo2 {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {1,2,3,4,5,6,7,8,9};
		int ret = findKth(arr,9,3);
		System.out.println(ret);
	}
	
	public static int findKth(int[] s, int n, int K) {
		PriorityQueue<Integer> arr = new PriorityQueue<>(n,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		int i = 0;
		for(i = 0; i < K; i++) {
			arr.offer(s[i]);
		}
		
		for(; i < n; i++) {
			if(s[i] < arr.peek()) {
				arr.poll();
				arr.offer(s[i]);
			}
		}
		return arr.poll();
	}
}
