public class TestDemo5 {
	/**
	 * ����������
	 * @param args
	 */
	public static void main(String[] args) {
		int t = 0;
		//����ÿ����
		for(int i = 1; i < 10000000;i++) {
			//�������3����
			int tmp = (int)Math.pow(i, 3);
			//����ͳ�� ÿ��λ�ϵ�����֮��
			int count = 0;
			//���� %10  /10 ����,�õ�ÿ��λ�ϵ�����
			while(tmp != 0) {
				int ret = tmp%10;
				//�ۼӵ� count ��
				count+=ret;
				tmp /= 10;
			}
			//�ж� ÿ��λ�ϵ�����֮�� �Ƿ� ���� ��ǰ��������ֱ���i
			if(i == count) {
				System.out.println(i);
				//��������,ͳ��һ�¸���
				t++;
			}
		}
		System.out.println(t);
	}
}
