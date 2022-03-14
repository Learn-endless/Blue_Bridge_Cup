import java.util.*;
public class TestDemo4 {
	/**
	 * BASIC-12	十六进制转八进制
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		String[] strArray = new String[input];
		
		for(int i = 0; i < input; i++) {
			strArray[i] = sc.next();
		}
		//循环处理输入的每组 十六进制 数
		for(int i = 0; i < input; i++) {
			function(strArray[i]);
		}
	}

	private static void function(String string) {
		StringBuilder s = new StringBuilder();
		//1.先将这个 十六进行的字符串转化为 二进制序列
		char[] ch = string.toCharArray();
		int len = ch.length;
		for(int i = 0; i < len; i++) {
			char ret = ch[i];
			switch(ret) {
				case '0': s.append("0000"); break;
				case '1': s.append("0001"); break;
				case '2': s.append("0010"); break;
				case '3': s.append("0011"); break;
				case '4': s.append("0100"); break;
				case '5': s.append("0101"); break;
				case '6': s.append("0110"); break;
				case '7': s.append("0111"); break;
				case '8': s.append("1000"); break;
				case '9': s.append("1001"); break;
				case 'A': s.append("1010"); break;
				case 'B': s.append("1011"); break;
				case 'C': s.append("1100"); break;
				case 'D': s.append("1101"); break;
				case 'E': s.append("1110"); break;
				case 'F': s.append("1111"); break;
				default:break;
			}
		}
		//2.判断当前 s 字符串的前三个字符的状态(先进行补齐,然后判断前三个字符是不是 0)
		if(s.length() % 3 ==1) {
			s.insert(0, "00");
		}else if(s.length() % 3 ==2) {
			s.insert(0, "0");
		}
		//是的话,删除掉
		if(s.substring(0,3).equals("000")) {
			s.delete(0, 3);
		}
		
		//3.转化为八进制存放到一个数组中
		int l = s.length();
		//start 和 end 用来 找 三位二进制表示的 八进制数,(三个为一组)
		int start = 0;
		int end = 3;
		//存放转化后的 八进制 数
		int[] tmp = new int[l/3];
		//tmp的下标
		int count = 0;
		//由于是 三个 为一组,所以循环次数是二进序列的 三分之一
		for(int j = 0; j < l/3; j++) {
			//拿到每组的三个字符
			String su = s.substring(start, end);
			//找到对应的8进制数,并添加到 tmp 数组的对应下标
			switch(su) {
			   case "000" : tmp[count++] = 0; break;
			   case "001" : tmp[count++] = 1; break;
			   case "010" : tmp[count++] = 2; break;
			   case "011" : tmp[count++] = 3; break;
			   case "100" : tmp[count++] = 4; break;
			   case "101" : tmp[count++] = 5; break;
			   case "110" : tmp[count++] = 6; break;
			   case "111" : tmp[count++] = 7; break;
			   default : break;
			}
			//下一组
			start +=3;
			end += 3;
		}
		//循环打印 tmp 中的 8 进制结果
		for(int i = 0; i < count; i++) {
			System.out.print(tmp[i]);
		}
		System.out.println();
	}
}
