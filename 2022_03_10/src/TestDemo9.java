/**
 * ��������
 * @author ֻ��������
 *
 */
public class TestDemo9 {
	public static int count = 0;
	public static void main(String[] args) {
		//ʹ��������������㷨 -- �����㷨
		dfs(0,0);           //������������,�������(Ҳ���ǿ��Ƶݹ������),С�����е�����.
		System.out.println(count);
	}

	private static void dfs(int depth, int sum) {
		//��� depth ����13 ���� sum(����) ������ 13,ֱ�ӽ�����ǰ�ݹ�,���� ѡ����һ�� ����
		if(depth > 13 || sum > 13) return ;
		if(depth == 13 && sum == 13) {
			//˵����������Ҫ��� 13 ����,ͳ��һ��
			count++;
		}
		//��� depth < 13 ���� sum < 13,˵�� 13 �����͵� �� ��û��ѡ��,��Ҫ�����ݹ���ȥ
		for(int i = 0; i < 5 ;i++) {
			// ÿ����һ�� depth ,���Ƕ�����ѡ�� 0��,1��,2��,3�Ż���4��.
			// ����������Ҫ��һ�� for ѭ������ʾ���Ե�ѡ��
			
			sum += i;          //����ǰѡ��ĵ����ӵ� sum ��
			dfs(depth+1,sum);  //����һ��ݹ�
			sum -= i;          //����sum��ֵ
		}
	}
}
