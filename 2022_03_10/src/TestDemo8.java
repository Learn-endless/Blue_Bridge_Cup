
public class TestDemo8 {
	/**
	  *   加法变乘法
	  *   解题关键: 1225-(a+a+1)-(b+b+1);     2015-(a*(a+1))-(b*(b+1))
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i = 1; i < 47; i++) {          //当 i == 46 时,乘号是 46 和 47 之间,48 和49 之间
			for(int j = i+2;j <= 48 ; j++) {   //i和j标注的是每组的最左边的那个数
				
				int a = 1225 - i-i-1 - j-j-1;
				int b = 2015 - i*(i+1) - j*(j+1);
				if(a == b) {
					System.out.println(i);
				}
			}
		}
	}
}
