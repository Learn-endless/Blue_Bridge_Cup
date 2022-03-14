import java.util.*;
public class TestDemo4 {
	/**
	 * BASIC-12	ʮ������ת�˽���
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		String[] strArray = new String[input];
		
		for(int i = 0; i < input; i++) {
			strArray[i] = sc.next();
		}
		//ѭ�����������ÿ�� ʮ������ ��
		for(int i = 0; i < input; i++) {
			function(strArray[i]);
		}
	}

	private static void function(String string) {
		StringBuilder s = new StringBuilder();
		//1.�Ƚ���� ʮ�����е��ַ���ת��Ϊ ����������
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
		//2.�жϵ�ǰ s �ַ�����ǰ�����ַ���״̬(�Ƚ��в���,Ȼ���ж�ǰ�����ַ��ǲ��� 0)
		if(s.length() % 3 ==1) {
			s.insert(0, "00");
		}else if(s.length() % 3 ==2) {
			s.insert(0, "0");
		}
		//�ǵĻ�,ɾ����
		if(s.substring(0,3).equals("000")) {
			s.delete(0, 3);
		}
		
		//3.ת��Ϊ�˽��ƴ�ŵ�һ��������
		int l = s.length();
		//start �� end ���� �� ��λ�����Ʊ�ʾ�� �˽�����,(����Ϊһ��)
		int start = 0;
		int end = 3;
		//���ת����� �˽��� ��
		int[] tmp = new int[l/3];
		//tmp���±�
		int count = 0;
		//������ ���� Ϊһ��,����ѭ�������Ƕ������е� ����֮һ
		for(int j = 0; j < l/3; j++) {
			//�õ�ÿ��������ַ�
			String su = s.substring(start, end);
			//�ҵ���Ӧ��8������,����ӵ� tmp ����Ķ�Ӧ�±�
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
			//��һ��
			start +=3;
			end += 3;
		}
		//ѭ����ӡ tmp �е� 8 ���ƽ��
		for(int i = 0; i < count; i++) {
			System.out.print(tmp[i]);
		}
		System.out.println();
	}
}
