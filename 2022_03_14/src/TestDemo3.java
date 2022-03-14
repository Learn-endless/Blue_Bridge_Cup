import java.util.*;
public class TestDemo3{
	/**
	 * BASIC-11	十六进制转十进制
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		//转化为数组
		char[] ch = s.toCharArray();
		long sum = 0;
		int count = 0;
		//遍历每个 十六进制 字符
		for(int i = ch.length-1; i >= 0; i--) {
			char ret = ch[i];
			//将转化后的 十进制 数累加到 sum 中
			switch(ret) {
				case '0': sum += 0  * Math.pow(16,count++); break;
				case '1': sum += 1  * Math.pow(16,count++); break;
				case '2': sum += 2  * Math.pow(16,count++); break;
				case '3': sum += 3  * Math.pow(16,count++); break;
				case '4': sum += 4  * Math.pow(16,count++); break;
				case '5': sum += 5  * Math.pow(16,count++); break;
				case '6': sum += 6  * Math.pow(16,count++); break;
				case '7': sum += 7  * Math.pow(16,count++); break;
				case '8': sum += 8  * Math.pow(16,count++); break;
				case '9': sum += 9  * Math.pow(16,count++); break;
				case 'A': sum += 10 * Math.pow(16,count++); break;
				case 'B': sum += 11 * Math.pow(16,count++); break;
				case 'C': sum += 12 * Math.pow(16,count++); break;
				case 'D': sum += 13 * Math.pow(16,count++); break;
				case 'E': sum += 14 * Math.pow(16,count++); break;
				case 'F': sum += 15 * Math.pow(16,count++); break;
				default:break;
			}
		}
		System.out.println(sum);
	}
}