package com.lanqiaobei.learn;

import java.util.Arrays;

public class TestDemo8 {
	public static int[] tmp = new int[5];
	public static int[][] stamp = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
	
	public static boolean label = false;
	public static void main(String[] args) {
		int count = 0;
		int a,b,c,d,e;
		for(a = 1; a <= 12 ;a++) {
			for(b = a+1; a <= 12 ;a++) {
				for(c = b+1; a <= 12 ;a++) {
					for(d = c+1; a <= 12 ;a++) {
						for(e = d+1; a <= 12 ;a++) {
							tmp[0] = a;
							tmp[1] = b;
							tmp[2] = c;
							tmp[3] = d;
							tmp[4] = e;
							if(check()) {
								count++;
							}
						}
					}
				}
			}
		}
	}
	private static boolean check() {
		int x = -1;
		int y = -1;
		boolean flg = false;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				if(stamp[i][j] == tmp[0]) {
					x = i;
					y = j;
					flg = true;
					break;
				}
			}
			if(flg) {
				break;
			}
		}
		dfs(0,x,y);
		return label;
	}
	
	public static boolean[] t = new boolean[13];
	private static void dfs(int depth,int x, int y) {
		if(depth == 5) {
			label = true;
			return;
		}
		
		if(t[stamp[x][y]] == false && checkNumber(x,y)) {
			t[stamp[x][y]] = true;
			if(x-1 >= 0) {
				dfs(depth+1,x-1,y);
			}
			if(x+1 <= 2) {
				dfs(depth+1,x+1,y);
			}
			if(y-1 >= 0) {
				dfs(depth+1,x,y-1);
			}
			if(y+1 <= 3) {
				dfs(depth+1,x,y+1);
			}
			
		}
	}
	private static boolean checkNumber(int x, int y) {
		String s = Arrays.toString(tmp);
		if(s.contains(stamp[x][y]+"")) {
			return true;
		}
		return false;
	}
}
