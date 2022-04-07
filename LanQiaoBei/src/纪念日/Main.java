package 纪念日;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2020 年 7 月 1 日是中国共产党成立 99 周年纪念日。
	中国共产党成立于 1921 年 7 月 23 日。
	请问从 1921 年 7 月 23 日中午 12 时到 2020 年 7 月 1 日中午 12 时一共包含多少分钟？填空题5分
	答案：52038720
 */
public class Main {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh");
		
		Date data1 = format.parse("1921-07-23-12");
		Date data2 = format.parse("2020-07-01-12");
		
		long a1 = data1.getTime();
		long a2 = data2.getTime();
		System.out.println((a2-a1)/1000/60);
		
	}
}
