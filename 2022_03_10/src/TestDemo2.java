
/**
  *  父亲的年龄
 * @author 19833
 *
 */
public class TestDemo2 {
	public static void main(String[] args) {
		int count =  0;
		//两层for循环分别用来遍历 各位 和 十位 的数字
		for(int i = 0; i <= 9; i++) {
			for(int j = 0; j <= 9;j++) {
				int my = i*10+j;   //计算父亲的年龄
				//父亲年龄的要求:一个2位数
				if(my >= 10 && my <= 99) {
					int son = my-27;   //儿子的年龄比父亲的年龄小 27 岁
					int tmp = j*10+i;  //求一下父亲年龄颠倒后的年龄
					//要求:父亲年龄颠倒后的年龄 等于 儿子的年龄
					if(tmp == son) {
						System.out.println(my);
						count++;  //统计满足情况的父亲的年龄
					}
				}
			}
		}
		System.out.println(count);
	}
}
