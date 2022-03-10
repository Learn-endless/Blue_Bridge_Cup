
/**
 * ���ű�: ��������
 * @author 19833
 *
 */
public class TestDemo4 {
	public static void main(String[] args) {
		//����һ������,������ʾ  �� �� �� �� �� �� �� ��
		int[] arr = new int[8];
		//�Զ��庯��,�����ҳ� ���� ��ĿҪ�� ����
		dfs(arr,0);
	}

	private static void dfs(int[] a, int n) {
		//˵�� a ���� �е���������������
		if(n == 8) {
			//�жϵ�ǰ�����е����ǲ�������Ҫ��
			if(checkArray(a) == true) {
				//�ҵ��˺��ʵ���,�ͽ�  �� �� �� ��  ����Ӧ�����ִ�ӡ����
				System.out.println(a[0]+""+a[1]+a[2]+a[3]);
			}
		}else {
			//˵����û������ 8 ����
			for(int i = 0; i < 10; i++) {
				//ÿ��λ�ϵ����ַ�Χ:0-9
				a[n] = i;   //�����ָ��Ƶ���ǰ n ��ָ��λ��
				//���һ�µ�ǰ���������Ƿ�����Ҫ��: a[0] ֻ���� 1,a�����е����ֲ����ظ�
				if(check(a,n) == true) {
					//�ݹ��һλ����
					dfs(a,n+1);
				}
			}
		}
	}

	/**
	 * ����Ƿ���� ��ĿҪ��: a[0] == 1, a�����е����ֲ��ܳ����ظ�
	 * @param a  ���  �� �� �� �� �� �� �� �� ������
	 * @param n  ��ǰ�ڼ�λ
	 * @return   ���ؼ����
	 */
	private static boolean check(int[] a, int n) {
		//��� ��ǰ �ǵ�һλ����
		if(n == 0) {
			//�ж�һ���ǲ��� 1
			if(a[n] != 1) {
				//���� dfs ���� �������µݹ���
				return false;
			}
		}else {
			//���ǵ�һλ,��Ҫ��� ��ǰ ����ֵ ��ǰ����ֹ�û��
			for(int i = 0; i < n; i++) {
				if(a[i] == a[n]) {
					//Ҳ���õݹ���ȥ��
					return false;
				}
			}
		}
		//��������,����һ��true,������һλ�Ĳ���
		return true;
	}

	/**
	 * ��� ��ǰ �� �ҵ���һ���� �ܲ������� ��ĿҪ��
	 * @param a  һ������
	 * @return   true �� false
	 */
	private static boolean checkArray(int[] a) {
		int x = a[0]*1000+a[1]*100+a[2]*10+a[3];
		int y = a[4]*1000+a[3]*100+a[5]*10+a[6];
		int w = a[0]*10000+a[1]*1000+a[5]*100+a[3]*10+a[7];
		if(x+y == w) {
			return true;
		}
		return false;
	}
}
