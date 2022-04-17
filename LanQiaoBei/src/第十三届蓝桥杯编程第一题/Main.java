package ��ʮ�������ű���̵�һ��;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		//����һ��map����ͳ���ظ������ַ��ĸ���
		Map<Character, Integer> map = new HashMap<>();
		//���ȼ����У��������ÿ����ֵ��(��д�ȽϷ���)
		PriorityQueue<Entry<Character, Integer>> pr = new PriorityQueue<>(new Comparator<Entry<Character, Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				return o2.getValue()-o1.getValue();
			}
		});
		//����ͳ��
		for(int i = 0; i < s.length(); i++) {
			if(!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), 0);
			}else {
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			}
		}
		//��map��Ľ��ת�� set �ŵ�һ�� ���ȼ�������ȥ(�����)
		for(Entry<Character, Integer> entry: map.entrySet()) {
			pr.offer(entry);
		}
		//�ҳ����γ��ֵ��ַ�(���е�Ҳ������)
		Entry<Character, Integer> str = pr.poll();
		StringBuilder sss = new StringBuilder();
		sss.append(str.getKey());
		while(pr.size() != 0) {
			if(str.getValue() != pr.peek().getValue()) {
				break;
			}else {
				sss.append(pr.poll().getKey());
			}
		}
		char[] ret = sss.toString().toCharArray();
		//�Ÿ�����
		Arrays.sort(ret);
		//������
		for(int i = 0; i < ret.length; i++) {
			System.out.print(ret[i]);
		}
	}
}
