
public class TestDemo8 {
	/**
	  *   �ӷ���˷�
	  *   ����ؼ�: 1225-(a+a+1)-(b+b+1);     2015-(a*(a+1))-(b*(b+1))
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i = 1; i < 47; i++) {          //�� i == 46 ʱ,�˺��� 46 �� 47 ֮��,48 ��49 ֮��
			for(int j = i+2;j <= 48 ; j++) {   //i��j��ע����ÿ�������ߵ��Ǹ���
				
				int a = 1225 - i-i-1 - j-j-1;
				int b = 2015 - i*(i+1) - j*(j+1);
				if(a == b) {
					System.out.println(i);
				}
			}
		}
	}
}
