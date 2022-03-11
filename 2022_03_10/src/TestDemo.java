import java.util.Scanner;
/**
 * ������
 * @author ֻ��������
 *
 */
public class TestDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextInt();       //��ʾɸ�ӵĸ���
		int m = sc.nextInt();       //��ʾ�����������(����������Ϊһ��)
		
		boolean[][] b = new boolean[7][7];   //������Ŷ��������Ϣ
		int[] shaiZi = {0,4,5,6,1,2,3};      //������Ŀ��ȷ��ɸ�� 6 ��ĵ���:
		                                     //shaiZi[i] = j: i�Ķ�������j
		                                     //1 �Ķ����� 4��2 �Ķ����� 5��3 �Ķ����� 6��
		for(int i = 0;i < m; i++) {
			int x = sc.nextInt();   //a��
			int y = sc.nextInt();   //b��
			//��������Ĺ�ϵ��ŵ� b ������
			b[x][y] = true; 
			b[y][x] = true;        //��� 1 �� 2�Ƕ�����,��ô 2 �� 1Ҳ�Ƕ�����
		}
		
		int e = 0;               //һ��ָ��ָ�� dp�����±�,������ dp[0]��dp[1]֮�䷴ת  
		
		//����һ����������,�������ĵ�һ�ж���ֵ�� 1
		long[][] dp = new long[2][7];
		for(int i = 1; i < 7; i++) {
			dp[0][i] = 1;
		}
		int c = 4;
		//ֻ�д�����ɸ�ӿ�ʼ���� ������
		for(long i = 2; i <= n; i++) {
			e = 1 - e;         //ʹ������ ���� ��ת(0,1)֮��.
			c *= 4;
			for(int j = 1; j < 7; j++) {
				for(int k = 1; k < 7; k++) {
					//�жϵ�ǰ���������Ƿ��ܽ�����һ��
					if(b[shaiZi[j]][k] == false) {
						dp[e][j] = dp[e][j] + dp[1-e][k];
					}
				}
			}
		}
		
		long sum = 0;    //ͳ������
		for(int i = 1; i < 7; i++) {
			sum = (sum+dp[e][i])%1000000007;
		}
		sum = (sum*c)%1000000007;
		System.out.println(sum);
	}

}
