import java.util.*;
public class Main4 {
	public static int[][] tmp = new int[30][30];
	public static int nMin = -1;
	public static int nMax = 30;
	public static int mMin = -1;
	public static int mMax = 30;
	public static void main(String[] args) {
		tmp[0][0] = 1;
		right(0,1);
		for(int i = 0; i < 30; i++) {
			System.out.println(Arrays.toString(tmp[i]));
		}
		System.out.println(tmp[19][19]);
	}
	private static void right(int i, int j) {
		if(j >= mMax) {
			return;
		}
		nMin = i;	
		while(j < mMax) {
			tmp[i][j] = tmp[i][j-1]+1;
			j++;
		}
		
		down(i+1,j-1);
	}
	private static void down(int i, int j) {
		if(i >= nMax) {
			return;
		}
		mMax = j;
		while(i < nMax) {
			tmp[i][j] = tmp[i-1][j] + 1;
			i++;
		}
		
		left(i-1,j-1);
	}
	private static void left(int i, int j) {
		if(j <= mMin) {
			return;
		}
		nMax = i;
		while(j > mMin) {
			tmp[i][j] = tmp[i][j+1]+1;
			j--;
		}
		
		up(i-1,j+1);
	}
	private static void up(int i, int j) {
		if(i <= nMin) {
			return;
		}
		mMin = j;
		while(i > nMin) {
			tmp[i][j] = tmp[i+1][j]+1;
			i--;
		}
		right(i+1,j+1);
	}
}
