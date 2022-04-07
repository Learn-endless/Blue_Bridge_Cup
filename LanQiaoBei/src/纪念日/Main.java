package ������;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2020 �� 7 �� 1 �����й����������� 99 ��������ա�
	�й������������� 1921 �� 7 �� 23 �ա�
	���ʴ� 1921 �� 7 �� 23 ������ 12 ʱ�� 2020 �� 7 �� 1 ������ 12 ʱһ���������ٷ��ӣ������5��
	�𰸣�52038720
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
