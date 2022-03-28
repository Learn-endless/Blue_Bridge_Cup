import java.util.*;
/**
 * 试题 算法提高 搬运冰块
 * @author 只爱吃土豆
 *
 */
public class Main1 {
	
	static class Box{
		public int Ti;
		public int Di;
		
		public Box(int Ti,int Di) {
			this.Ti = Ti;          //搬运耗时
			this.Di = Di;          //融化速度
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Box[] array = new Box[n];
		
		for(int i = 0; i < n; i++) {
			array[i] = new Box(sc.nextInt(),sc.nextInt());
		}
		
		//按最少融化量来排序
		Arrays.sort(array,new Comparator<Box>() {

			@Override
			public int compare(Box o1, Box o2) {
				/*
				  *  如果o1先搬走，那么融化量为  T1 * D2
				  *  如果o2先搬走，融化量为 T2 * D1
				 */
				return  o1.Ti*o2.Di - o2.Ti*o1.Di;
			}
		});
		
		long time = 0;     //记录耗时
		long sum = 0;      //统计总的融化量
		
		for(int i = 0; i < n; i++) {
			/*
			  * 默认搬运过程中不会融化，已经到目的地的box也不会融化
			  * 只有还没开始搬的box才会融化 
			  * 注意：从搬第二个box时才会开始统计总融化量 
			 */
			sum += time*array[i].Di;    
			time += array[i].Ti;       //将前面搬box时的耗时统计下来
		}
		System.out.println(sum);
	}
}
