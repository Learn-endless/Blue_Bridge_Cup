
import java.util.*;
public class TestDemo5 {
	/**
	 * ���� ������ϰ �ֽ�������
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//����һ����Χ[a,b]
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		//���������Χ�е�ÿ����
		for(int i = a; i <= b; i++) {
			//�����ж��ǲ���һ������
			if(isPrime(i)) {
				//������ֱ�����
				System.out.println(i+"="+i);
			}else {
				//�Ǻ��� �ʹ�С�����ҳ�����������   - ���ص���һ���ַ���
				String ret = handleComposite(i); 
				//��ӡ����
				System.out.println(i+"="+ret);
			}
		}
	}

	/**
	  * �������� ÿһ��������������
	 * @param n һ������
	 * @return  ������������ɵ��ַ���
	 */
	private static String handleComposite(int n) {
		StringBuilder s = new StringBuilder();
		//һֱѭ������ǰ�������,������ 1 Ϊֹ
		while(n != 1) {
			//��2��ʼѭ�����Ե�ǰ�ĺ���
			for(int i = 2; i <= n; i++) {
				//�ж��ܷ� ����ǰ�� i ������,���ұ����������ǲ�������
				if(n % i == 0 && isPrime(i)) {
					//������,˵����ǰ�� i �� n ��һ��������
					s.append(i+"*");
					//n������i
					n /= i;
					//����ȥѰ����һ��������
					break;
				}
			}
		}
		//ɾ���� s �ַ���������һ�� * ��
		s.delete(s.length()-1, s.length());
		return s.toString();
	}

	/**
	 * �ж�һ�����ǲ���һ������
	 * @param data һ����
	 * @return     ����һ�� booleanֵ
	 */
	private static boolean isPrime(int data) {
		//���� 2 - data��ƽ����,������֮��û���ܹ����� data ������,˵��data����һ������
		for(int i = 2; i <= Math.sqrt(data); i++) {
			if(data % i == 0) {
				return false;
			}
		}
		return true;
	}
}
