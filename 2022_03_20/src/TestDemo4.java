
import java.util.*;
public class TestDemo4 {
	
	/**
	  * ���ÿ��Ĳ�������
	 */
	static class Node{
		public int p;        //��ʽ
		public int q;        //����
		
		//���췽��
		public Node(int p, int q) {
			this.p = p;
			this.q = q;
		}
	}
	
	public static int N = 7;    //���Ĳ�������
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Node[] tmp = new Node[N];    //���ȫ���Ĳ�������
		int top = 0;                 //����ͳ�Ƶ�ǰtmp��������Ч�Ĳ�������
		
		int n = sc.nextInt();        //��ʾ���еĳ���
		int m = sc.nextInt();        //��ʾ�����Ĵ���
		int[] ans = new int[n+1];    //������Ž������
		
		//ѭ������ÿ�εĲ���
		while(m-- != 0) {
			
			int p = sc.nextInt();  //�����ķ�ʽ:����/����
 			int q = sc.nextInt();  //������Щ����
 			
 			//����ǽ������
 			if(p == 0) {
 				//�ҳ������Ľ�����������ֵ
 				while(top != 0 && tmp[top].p == 0)  q = Math.max(q, tmp[top--].q);
 				//ɾ�������Ľ������
 				while(top >= 2 && tmp[top-1].q <= q) top -= 2;
 				//���ҵ�������������ֵ�ŵ� tmp ��
 				tmp[++top] = new Node(0,q);
 			
 			}else {
 				//ͬ���ҵ������������������Сֵ
 				while(top != 0 && tmp[top].p == 1) q = Math.min(q, tmp[top--].q);
 				//ɾ���������������
 				while(top >= 2 && tmp[top-1].q >= q) top -= 2;
 				//���µ�ǰ������ tmp ��ȥ
 				tmp[++top] = new Node(1,q);
 			}
		}
		
		int k = n;   //��ǰ��Ҫ�������������ұߵ����ֵ
		int l = 1;   //���±�
		int r = n;   //���±�
		
		//������ǰ�����в���(ע��top�����渳ֵʱ,��++top)
		for(int i = 1; i <= top; i++) {
			//�����ǰ������ 0 �������
			if(tmp[i].p == 0) {
				//�Ӻ���ǰ���
				while(r > tmp[i].q && l <= r)  ans[r--] = k--;
			}else {
				//��ǰ�������
				while(l < tmp[i].q && l <= r)  ans[l++] = k--;
			}
		}
		
		//���� l ��  r ֮�������
		if(top % 2 == 1) {
			//��ǰ�������
			while(l <= r) ans[l++] = k--;
		}else {
			//�Ӻ���ǰ���
			while(l <= r) ans[r--] = k--;
		}
		
		//ѭ����ӡ�����
		for(int i = 1; i <= n; i++) {
			System.out.print(ans[i]+" ");
		}
	}
}



