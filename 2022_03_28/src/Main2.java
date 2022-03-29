import java.util.*;
public class Main2 {
	/**
	  * ��һ����ά����������Ͻǵ����½ǵ���С·����
	  * �涨��ֻ�������ߣ�����������
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		  * ״̬���壺�������£������������αȽϵ���F[i][j]�ĵ��·�����е���С��һ����Ȼ����� F[i][j]
		  * ״̬ת�Ʒ��̣�F[i][j] = Math.min(F[i-1][j],F[i][j-1])+F[i][j]
		  *         ע�⻹�����������
		  *                         �� i = 0 ʱ��F[0][j] = F[0][j-1]+F[0][j]
		  *                         �� j = 0 ʱ��F[i][0] = F[i-1][j]+F[i][0]
		  * ��ʼ����F[0][0] = 0
		  * ���ؽ����F[row-1][col-1]
		 */
		
		int[][] F = {{0,2,5,7},{1,2,7,5},{9,1,2,4}};   //����һ����ά�����������Ÿ��Եľ���
		
		F[0][0] = 0;     //��ʼ״̬���Լ����Լ��ľ���Ϊ 0
		
		int n = F.length;
		int m = F[0].length;
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < m; j++) {
				if(i == 0) {
					F[i][j] = F[i][j-1]+F[i][j];
				}else if(j == 0) {
					F[i][j] = F[i-1][j]+F[i][j];
				}else {
					F[i][j] = Math.min(F[i-1][j],F[i][j-1])+F[i][j];
				}
			}
		}
		System.out.println(F[n-1][m-1]);
	}
	
	/**
	  * ��һ����ά����������Ͻǵ����½ǵ�·������
	  * �涨��ֻ�������ߣ�����������
	 * @param args
	 */
	public static void main6(String[] args) {
		/*
		  * ״̬���壺�������£�������������ͳ�Ƶ���F[i][j]�ĵ��·������
		  * ״̬ת�Ʒ��̣�F[i][j] = F[i-1][j]+F[i][j-1]
		  * ��ʼ����F[0][j] = 1 , F[i][0] = 1;
		  * ���ؽ����F[row-1][cul-1]
		 */
		
		int[][] F = new int[3][4];
		int n = F.length;
		int m = F[0].length;
		for(int i = 0; i < m; i++) {
			F[0][i] = 1;
		}
		for(int i = 1; i < n; i++) {
			F[i][0] = 1;
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < m; j++) {
				
				F[i][j] = F[i-1][j]+F[i][j-1];
			}
		}
		
		System.out.println(F[n-1][m-1]);
	}
	
	/*
	 *     2
	 *     3  4
	 *     6  5  7
	 *     4  1  8  3
	  *     �������δӶ������ײ������·����
	 */
	public static void main5(String[] args) {
		int[][] F = {{2},{3,4},{6,5,7},{4,1,8,3}};	
		/*
		  * �Ե�����
		  * �����������������δӶ����׵���С·����
		  * ״̬���壺���F[i][j]�� F[i+1][j]����С·��֮��
		  * ״̬ת�Ʒ��̣�F[i][j] = Min(F[i+1][j],F[i+1][j])+F[i][j]    (û���������)
		  * ״̬��ʼ�������һ�е�Ԫ��Ϊ��֪����
		  * ���ؽ����    ����Ԫ�ص�ֵ���ǽ��
		 */
		
		int n = F.length;
		for(int i = n-2; i >= 0; i--) {
			for(int j = 0; j <= i; j++) {
				F[i][j] = Math.min(F[i+1][j], F[i+1][j+1])+F[i][j];
			}
		}
		System.out.println(F[0][0]);
	}
	/*
	 *     2
	 *     3  4
	 *     6  5  7
	 *     4  1  8  3
	  *     �������δӶ������ײ������·����
	 */
	public static void main4(String[] args) {
		int[][] F = {{2},{3,4},{6,5,7},{4,1,8,3}};
		/*
		  * �Զ�����
		  * �����������������δӶ����׵���С·����
		  * ״̬���壺���F[i][j]�� F[i+1][j]����С·��֮��
		  * ״̬ת�Ʒ��̣�F(i) = Min(F[i-1][j],F[i-1][j-1])+F[i][j];
		  * ע�⣺���״̬ת�Ʒ�������������� ��
		  *     ��  j = 0  ʱ��F[i][j] = F[i-1][j]+F[i][j]
		  *     ��  j = i ʱ��F[i][j] = F[i-1][j-1]+F[i][j]
		  * ״̬��ʼ��������Ԫ��Ϊ��֪����
		  * ���ؽ�������һ���е���Сֵ
		 */	
		int n = F.length;
		for(int i = 1; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0) {
					F[i][j] = F[i-1][j] + F[i][j];
					
				}else if(j == i) {
					F[i][j] = F[i-1][j-1] + F[i][j];
					
				}else {
					F[i][j] = Math.min(F[i-1][j], F[i-1][j-1]) + F[i][j];
				}
			}
		}
		int min = F[n-1][0];
		for(int i = 1; i < F[n-1].length; i++) {
			min = Math.min(F[n-1][i], min);
		}
		System.out.println(min);
	}
	
	/**
	  * �ж�һ���ַ����ܲ����� dict �еĵ��ʷָ�
	 * @param s      ���ָ���ַ���
	 * @param dict   ��ŵ��ʵ��ֵ�
	 * @return       ����һ��booleanֵ
	 */
	public static boolean wordBreak(String s, Set<String> dict) {
		//״̬�Ķ��壺��ǰ i ���ַ��ܲ��ܱ� �ָ�
		boolean[] F = new boolean[s.length()+1];     //F(0)��һ������״̬��������Ҫ����һ��  s.length()+1 ��С������
		
		//��ʼ��ֵ
		F[0] = true;
		
		//ѭ�����ǰ i ���ַ��ܷ񱻷ָ������
		for(int i = 1; i <= s.length(); i++) {
			//״̬ת�Ʒ��� �� j < i && F(j) && F(j+1,i)���ж�ǰi���ַ��ܲ��ܱ��ָ�
			for(int j = 0; j < i; j++) {
				if(F[j] && dict.contains(s.substring(j, i))) {   //Ϊʲô�� j �������� j+1����ΪF(0)ֻ��һ��
					//����״̬�������������� ʹת�Ʒ��� �ܵ�����ȥ�������� j = 0 ָ��ľ��� ��һ�� �ַ�(����״̬��������ַ���ǰ��)��                          
					F[i] = true;
					//ֻҪ��һ�ַָ�����ͽ�������ѭ��
					break;
				}
			}
		}
		return F[s.length()];
	}
	
	public static void main3(String[] args) {
		String s = "leetcode";
		Set<String> set = new HashSet<>();
		set.add("leet");
		set.add("code");
		boolean flg = wordBreak(s,set);
		System.out.println(flg);
	}
	
	public static void main2(String[] args) {
		//���������쳲��������е�n�ĳ������ �ռ��ϵ��Ż�
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int fn = -1;
		int f0 = 0;
		int f1 = 1;
		
		for(int i = 2; i <= n; i++) {
			fn = f0+f1;
			f0 = f1;
			f1 = fn;
		}
		System.out.println(fn);
	}
	
	public static void main1(String[] args) {
		/*
		  * ʹ�ö�̬�滮������ 쳲��������� ��n��
		 * 1.״̬���壺���F(n-1)���쳲���������
		 * 2.ת�Ʒ��̣�F(n) = F(n-1) + F(n-2)
		 * 3.��ʼ�� ��   F(0) = 0;  F(1) = 1;
		 * 4.���ؽ����F(n); 
		 */
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] F = new int[n+1];     //�ӵ�0�ʼ
		
		F[0] = 0;
		F[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			F[i] = F[i-1]+F[i-2];
		}
		System.out.println(F[n]);
	}
}
