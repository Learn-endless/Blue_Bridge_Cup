/**
 * 198. ��ҽ��� leetcode
 * @author 19833
 *
 */
public class TestDemo13 {
	public static void main(String[] args) {
		int[] array = {2,5,7,4,6,5,2,1,0};
		
		int ret = rob(array);
		System.out.println(ret);
	}

	private static int rob(int[] array) {
		int len = array.length;
		//����һ�� dp ����
		int[] dp = new int[len];
		//��ĿҪ��,����͵���ڵ������˼�
		dp[0] = array[0];
		dp[1] = array[1];
		
		//������ dp ���鿪ʼ��ֵ
		for(int i = 2; i < len ;i++) {
			dp[i] = Math.max(dp[i-2]+array[i], dp[i-1]);
		}
		//���һ��ֵ�����ܹ�͵�������Ľ��
		return dp[len - 1];
	}
}
