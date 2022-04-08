package ×Ö·û´®±àÂë;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = {'0','A','B','C','D','E','F','G',
				'H','I','J','K','L','M','N','O','P',
				'Q','R','S','T','U','V','W','X','Y','Z'};
		
		String s = sc.next();
		int len = s.length();
		
		int k = 0;
		StringBuilder st = new StringBuilder();
		while(k < len) {
			if(k + 1 < len) {
				String sk = s.substring(k,k+2);
				int ret = Integer.parseInt(sk);
				if(ret < 27) {
					st.append(ch[ret]);
					k+=2;
				}else {
					char x = s.charAt(k);
					int y = Integer.parseInt(x+"");
					st.append(ch[y]);
					k++;
				}
			}else {
				char x = s.charAt(k);
				int y = Integer.parseInt(x+"");
				st.append(ch[y]);
				k++;
			}
		}
		System.out.println(st.toString());
	}
}
