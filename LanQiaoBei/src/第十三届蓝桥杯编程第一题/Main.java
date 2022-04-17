package 第十三届蓝桥杯编程第一题;

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
		//定义一个map用来统计重复出现字符的个数
		Map<Character, Integer> map = new HashMap<>();
		//优先级队列，用来存放每个键值对(重写比较方法)
		PriorityQueue<Entry<Character, Integer>> pr = new PriorityQueue<>(new Comparator<Entry<Character, Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				return o2.getValue()-o1.getValue();
			}
		});
		//遍历统计
		for(int i = 0; i < s.length(); i++) {
			if(!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), 0);
			}else {
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			}
		}
		//将map里的结果转成 set 放到一个 优先级队列中去(大根堆)
		for(Entry<Character, Integer> entry: map.entrySet()) {
			pr.offer(entry);
		}
		//找出最多次出现的字符(并列的也算在内)
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
		//排个升序
		Arrays.sort(ret);
		//输出结果
		for(int i = 0; i < ret.length; i++) {
			System.out.print(ret[i]);
		}
	}
}
