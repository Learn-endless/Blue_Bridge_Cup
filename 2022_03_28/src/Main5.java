
public class Main5 {
	/**
	 * 01�������⣺��̬�滮
	 * @param price
	 * @param size
	 * @param bag
	 * @return
	 */
	public static int zeroOneBag(int[] price, int[] size, int bag) {
		int n = price.length;
		
		//״̬����
		int[][] mat = new int[n+1][bag+1];
		//��Ϊ���鱾���ʼ������ 0 ���������ﲻ���ֶ��� mat[0][j] = 0 �� mat[i][j] = 0;
		
		//ֱ�ӱ���
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= bag; j++) {
				//����״̬ת�Ʒ��̣�
				//�����ŵ� i ����Ʒ��ʱ��(��i����Ʒ���������ʹ��� ��ǰ���� j ������)
				if(j < size[i-1]) {
					//���� �� i ����Ʒ����� �� size �������Ǵ� 0 ��ʼ��
					//���ŵ� i ����Ʒ
					mat[i][j] = mat[i-1][j];
					
				}else {
					//�ŵ� i ����Ʒ�������
					mat[i][j] = Math.max(mat[i-1][j-size[i-1]]+price[i-1], mat[i-1][j]);
				}
			}
		}
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= bag; j++) {
				System.out.printf("%3d",mat[i][j]);
			}
			System.out.println();
		}
		return mat[n][bag];
	}
	
	/**
	 * 01�������� �� �Ż��汾��ʹ��һά����(ֱ����ȥ��һ��֮�ϵ�����)
	 * @param price
	 * @param size
	 * @param bag
	 * @return
	 */
	public static int zeroOneBag1(int[] price, int[] size, int bag) {
		int n = price.length;
		
		//״̬����
		int[] mat = new int[bag+1];
		//��Ϊ���鱾���ʼ������ 0 ���������ﲻ���ֶ��� mat[0][j] = 0 �� mat[i][j] = 0;
		
		//ֱ�ӱ���
		for(int i = 1; i <= n; i++) {
			for(int j = bag; j >= 0; j--) {
				//״̬ת�Ʒ��̾�ֻ��һ������ˣ�
				if(size[i-1] <= j){
					//�ŵ� i ����Ʒ�������
					mat[j] = Math.max(mat[j-size[i-1]]+price[i-1], mat[j]);
				}
			}
		}
		
		for(int i = 0; i <= bag; i++) {
			System.out.printf("%3d",mat[i]);
		}
		return mat[bag];
	}
	
	public static void main(String[] args) {
		int[] price = {3,1,5,7,9};
		int[] size = {1,4,2,3,6};
		int bag = 10;
		int ret = zeroOneBag1(price,size,bag);
		System.out.println();
		System.out.println(ret);
	}
}
