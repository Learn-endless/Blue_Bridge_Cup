
import java.util.*;
public class TestDemo1 {
	/**
	 * ��֪n��m����ӡn^1��n^2��...��n^m��
	 * Ҫ���þ�̬����ʵ�֡�n^m��ʾn��m�η���
	 * ��֪n��m����ӡn^1��n^2��...��n^m��Ҫ���þ�̬����ʵ�֡�
	 * n^m��ʾn��m�η�����ÿ����ʾ5������ÿ������Ϊ12���Ҷ��룩
	 * @param args
	 */
	public static int n;
	public static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 1; i <= m; i++) {
			System.out.printf("%12.0f",Math.pow(n, i));
			if(i % 5 == 0) {
				System.out.println();
			}
		}
	}
}
