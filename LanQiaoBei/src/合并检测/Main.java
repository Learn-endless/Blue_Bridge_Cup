package ºÏ²¢¼ì²â;

public class Main {
	public static void main(String[] args) {
		int n = 100;
		double y = 0;
		for(int k = 1; k <= n; k++) {
			y = 1.0*n/k+0.01*n*k;
			System.out.printf("%.2f-->%d",y,k);
			System.out.println();
			y=0;
		}
	}
}
