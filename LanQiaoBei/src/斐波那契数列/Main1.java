package ì³²¨ÄÇÆõÊıÁĞ;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] f = new int[n+1];
		
		f[0] = 0;
		f[1] = 1;
		for(int i = 2; i <= n; i++) {
			f[i] = f[i-1]+f[i-2];
		}
		System.out.println(f[n]);
	}
}	
