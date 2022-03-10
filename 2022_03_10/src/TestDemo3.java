import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class TestDemo3 {
	
	/**
	  *  ���һ������ȫ����
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int len = arr.length;
		//������� ȫ�� ������ ���,ÿһ���������һ�� List<Integer>
		List<List<Integer>> list = new ArrayList<>();
		//������� ÿһ�� ���� ������
		Stack<Integer> stack = new Stack<>();
		//������¼ arr ������ÿ��ֵ�� ״̬:�Ƿ��Ѿ���ʹ��
		boolean[] used = new boolean[len];
		
		//�����㷨(������ȱ���)
		dfs(arr,len,0,stack,used,list);
		
		System.out.println(list);
		
	}

	/**
	  *  �����㷨(��������㷨)
	 * @param arr      ��Ҫȫ���е�����
	 * @param len      ����ĳ���
	 * @param depth    ������¼�ݹ鵽�ڼ���
	 * @param stack    �������ÿһ�������
	 * @param used     ������¼ÿ�������Ƿ�ʹ��
	 * @param list     ������е� ���е����
	 */
	private static void dfs(int[] arr, int len, int depth, Stack<Integer> stack, boolean[] used, List<List<Integer>> list) {
		//�ݹ��������:��ǰ��� == ����ĳ���
		if(depth == len) {
			//���Ѿ��źõ�һ�����ݷ��� list
			list.add(new ArrayList<>(stack));  //ע������ʹ�� �µ� ����,��Ϊ�ݹ� ���ݻᵽ ���ڵ�(���ڵ���һ���սڵ�)
			return;
		}
		//ÿһ�εݹ����,�����������������Ԫ��
		for(int i = 0; i < len; i++) {
			//���жϵ�ǰԪ���Ƿ��Ѿ������� stack ��
			if(used[i] == true) {
				//����һ��
				continue;
			}
			//û�оͷ��� stack ��
			stack.push(arr[i]);
			//���ĵ�ǰԪ�ص� ״̬
			used[i] = true;
			//��ʼ�ݹ�
			dfs(arr,len,depth+1,stack,used,list);
			//ע��:������ ���� ����֮��,���Ǿ���Ҫ ���� �����(��һ��������Ҫ)
			
			//ɾ��������ӵ� stack �е�ֵ
			stack.pop();
			//����״̬
			used[i] = false;
		}
		
	}
}
