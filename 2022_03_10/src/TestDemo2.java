
/**
  *  ���׵�����
 * @author 19833
 *
 */
public class TestDemo2 {
	public static void main(String[] args) {
		int count =  0;
		//����forѭ���ֱ��������� ��λ �� ʮλ ������
		for(int i = 0; i <= 9; i++) {
			for(int j = 0; j <= 9;j++) {
				int my = i*10+j;   //���㸸�׵�����
				//���������Ҫ��:һ��2λ��
				if(my >= 10 && my <= 99) {
					int son = my-27;   //���ӵ�����ȸ��׵�����С 27 ��
					int tmp = j*10+i;  //��һ�¸�������ߵ��������
					//Ҫ��:��������ߵ�������� ���� ���ӵ�����
					if(tmp == son) {
						System.out.println(my);
						count++;  //ͳ����������ĸ��׵�����
					}
				}
			}
		}
		System.out.println(count);
	}
}
