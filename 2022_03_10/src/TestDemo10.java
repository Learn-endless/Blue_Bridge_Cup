import java.util.Scanner;

/**
  * 饮料换购
 * @author 19833
 *
 */
public class TestDemo10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			//统计总共能 获得 多少 瓶 饮料
			int count = n;
			//记录能用 总共的瓶盖数 能兑换的 饮料数
			int ret = n / 3;
			//记录当前还剩的 瓶盖 数 (不够3个)
			int tmp = n%3;
			//循环遍历,当能兑换的饮料数为 0 时,结束循环
			while(ret > 0) {
				//将兑换后的饮料数量 累加到 count 中去
				count += ret;
				//手里剩余的瓶盖数 加上 新兑换饮料的瓶盖数
				tmp += ret % 3;
				//判断一下,如果手里剩余的瓶盖个数 大于等于3 
				if(tmp >= 3) {
					//就能 又兑换 一瓶 新的饮料,将它 累加到ret 中,
					ret += tmp/3;
					//更新 tmp 手里剩余的瓶盖数
					tmp %= 3;
				}
				//去商店用手里饮料的瓶盖兑换新的饮料
				ret = ret / 3;			
			}
			
			System.out.println(count);
		}
	}
}
