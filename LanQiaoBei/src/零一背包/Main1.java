package ��һ����;

public class Main1 {
	
	private static int func(int[] weight, int[] price, int bag) {
		int len = weight.length;
		int[][] array = new int[len+1][bag+1];
		
		for(int i = 1; i <= len; i++) {
			for(int j = 1; j <= bag; j++) {
				if(weight[i-1] > j) {
					array[i][j] = array[i-1][j];
				}else {
					//�����������Ҫ�����i����Ʒ����ô��Ҫ�Ƚ�һ�¼��� �� i ����Ʒ�Ͳ����룬�ĸ���ֵ��
					array[i][j] = Math.max(array[i-1][j-weight[i-1]]+price[i-1],array[i-1][j]);
				}
			}
		}
		return array[len][bag];
	}
	
	public static void main(String[] args) {
		int[] weight = {3,2,8,1};
		int[] price = {10,2,7,9};
		int bag = 10;
		int ret = func(weight,price,bag);
		System.out.println(ret);
	}
}
