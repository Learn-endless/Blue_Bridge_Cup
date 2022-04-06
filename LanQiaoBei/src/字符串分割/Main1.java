package ×Ö·û´®·Ö¸î;

import java.util.ArrayList;

public class Main1 {
	
	
	private static boolean func(String s,ArrayList<String> str) {
		int len = s.length();
		boolean[] flg = new boolean[len+1];
		
		flg[0] = true;
		
		for(int i = 1; i <= len; i++) {
			for(int j = 0; j < i; j++) {
				if(flg[j] && str.contains(s.substring(j,i))) {
					flg[i] = true;
					break;
				}
			}
		}
		return flg[len];
	}
	
	public static void main(String[] args) {
		String s = "leetcode";
		ArrayList<String> str = new ArrayList<>();
		str.add("leet");
		str.add("code");
		boolean flg = func(s,str);
		System.out.println(flg);
	}
}
