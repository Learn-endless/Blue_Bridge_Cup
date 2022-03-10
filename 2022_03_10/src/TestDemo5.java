public class TestDemo5 {
	/**
	 * 立方变自身
	 * @param args
	 */
	public static void main(String[] args) {
		int t = 0;
		//遍历每个数
		for(int i = 1; i < 10000000;i++) {
			//求出它的3次幂
			int tmp = (int)Math.pow(i, 3);
			//用来统计 每个位上的数字之和
			int count = 0;
			//进行 %10  /10 操作,拿到每个位上的数字
			while(tmp != 0) {
				int ret = tmp%10;
				//累加到 count 中
				count+=ret;
				tmp /= 10;
			}
			//判断 每个位上的数字之和 是否 等于 当前的这个数字本身i
			if(i == count) {
				System.out.println(i);
				//满足条件,统计一下个数
				t++;
			}
		}
		System.out.println(t);
	}
}
