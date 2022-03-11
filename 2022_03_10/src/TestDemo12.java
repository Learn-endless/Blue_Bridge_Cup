
/**
 * 53. ����������  leetcode
 * @author 19833
 *
 */
public class TestDemo12 {
	public static void main(String[] args) {
		int[] array = {1,7,4,5,8,4,1,8,9};
		int ret = maxSubArray(array);
		System.out.println(ret);
	}

	private static int maxSubArray(int[] array) {
		//����һ�� dp ����,�����ۼ� ���������ֵĺ�
		int[] dp = new int[array.length];
		dp[0] = array[0];
		//��ʼ�ۼ�
		for(int i = 1; i < array.length; i++) {
			if(dp[i-1]>0) {
				dp[i] = dp[i-1]+array[i];
			}else {
				dp[i] = array[i];
			}
		}
		//�����ҵ� dp �������Ǹ�ֵ
		int max = dp[0];
		for(int i = 1; i < dp.length; i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
