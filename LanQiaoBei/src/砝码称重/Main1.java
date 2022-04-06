package �������;

import java.util.Scanner;

public class Main1 {
	
	private static int func(int n, int[] weight) {
		//�����������ܳƳ�������
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += weight[i];
		}
		
		boolean[][] flg = new boolean[n+1][sum+1];
		flg[0][0] = true;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= sum; j++) {
				//��ʾ��ǰ����������Ա��Ƴ���
				if(flg[i-1][j]) {
					//ֱ���˻���һ��״̬
					flg[i][j] = true;
					//˵����ǰ�Ŀ��ԳƳ������� j + ��i����������� Ҳ���Ա��Ƴ���
					flg[i][j+weight[i-1]] = true;
					
					//����ֻ�ǽ��еļӵĲ�����Ȼ����м��Ĳ���
					//����Ϊ�˷�ֹ���������������������Ƚ��бȽϣ�Ȼ�����
					if(j > weight[i-1]) {
						flg[i][j-weight[i-1]] = true;
					}else {
						flg[i][weight[i-1]-j] = true;
					}
				}
			}
		}
		//ͳ�����һ��Ϊ true ��ֵ(���ڵ�0����һ������״̬�����Բ���ͳ�����Ƿ�Ϊ true)
		int ans = 0;
		for(int i = 1; i <= sum; i++) {
			if(flg[n][i]) {
				ans++;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] weight = new int[n];
		for(int i = 0; i < n; i++) {
			weight[i] = sc.nextInt();
		}
		
		int ans = func(n,weight);
		System.out.println(ans);
	}
}
