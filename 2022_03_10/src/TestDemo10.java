import java.util.Scanner;

/**
  * ���ϻ���
 * @author 19833
 *
 */
public class TestDemo10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			//ͳ���ܹ��� ��� ���� ƿ ����
			int count = n;
			//��¼���� �ܹ���ƿ���� �ܶһ��� ������
			int ret = n / 3;
			//��¼��ǰ��ʣ�� ƿ�� �� (����3��)
			int tmp = n%3;
			//ѭ������,���ܶһ���������Ϊ 0 ʱ,����ѭ��
			while(ret > 0) {
				//���һ������������ �ۼӵ� count ��ȥ
				count += ret;
				//����ʣ���ƿ���� ���� �¶һ����ϵ�ƿ����
				tmp += ret % 3;
				//�ж�һ��,�������ʣ���ƿ�Ǹ��� ���ڵ���3 
				if(tmp >= 3) {
					//���� �ֶһ� һƿ �µ�����,���� �ۼӵ�ret ��,
					ret += tmp/3;
					//���� tmp ����ʣ���ƿ����
					tmp %= 3;
				}
				//ȥ�̵����������ϵ�ƿ�Ƕһ��µ�����
				ret = ret / 3;			
			}
			
			System.out.println(count);
		}
	}
}
