
/**
 * ����һ������ A=2021��ÿһ�Σ����Խ�������� 1 ���� 1 ����� 2�����г��� 2 ����������ż����ʱ�������
�������磬2021 ����һ�β������Ա�� 2020��2022��
�������磬2022 ����һ�β������Ա�� 2021��2023 �� 1011��
�������ʣ�2021 ���پ������ٴβ������Ա�� 1��
 * @author 19833
 *
 */

public class Main3 {
	public static int count = 0;
	public static int[] ret = {1,1,2};
	public static int[] tmp = new int[24];
	public static void main(String[] args) {
		dfs(2021);
	}
	private static void dfs(int data) {
		if(data <= 1) {
			if(data == 1) {
				System.out.println(count);
			}
			return;
		}
			count++;
			if(data % 2 == 0) {
				dfs(data / 2);
			}else {
				dfs(data+1);
				dfs(data-1);
			}
			count--;
	}
}
