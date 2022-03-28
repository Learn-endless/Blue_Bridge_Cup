import java.util.*;
/**
 * ���� �㷨��� ���˱���
 * @author ֻ��������
 *
 */
public class Main1 {
	
	static class Box{
		public int Ti;
		public int Di;
		
		public Box(int Ti,int Di) {
			this.Ti = Ti;          //���˺�ʱ
			this.Di = Di;          //�ڻ��ٶ�
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Box[] array = new Box[n];
		
		for(int i = 0; i < n; i++) {
			array[i] = new Box(sc.nextInt(),sc.nextInt());
		}
		
		//�������ڻ���������
		Arrays.sort(array,new Comparator<Box>() {

			@Override
			public int compare(Box o1, Box o2) {
				/*
				  *  ���o1�Ȱ��ߣ���ô�ڻ���Ϊ  T1 * D2
				  *  ���o2�Ȱ��ߣ��ڻ���Ϊ T2 * D1
				 */
				return  o1.Ti*o2.Di - o2.Ti*o1.Di;
			}
		});
		
		long time = 0;     //��¼��ʱ
		long sum = 0;      //ͳ���ܵ��ڻ���
		
		for(int i = 0; i < n; i++) {
			/*
			  * Ĭ�ϰ��˹����в����ڻ����Ѿ���Ŀ�ĵص�boxҲ�����ڻ�
			  * ֻ�л�û��ʼ���box�Ż��ڻ� 
			  * ע�⣺�Ӱ�ڶ���boxʱ�ŻῪʼͳ�����ڻ��� 
			 */
			sum += time*array[i].Di;    
			time += array[i].Ti;       //��ǰ���boxʱ�ĺ�ʱͳ������
		}
		System.out.println(sum);
	}
}
