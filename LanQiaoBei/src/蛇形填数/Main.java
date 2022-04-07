package 蛇形填数;

public class Main {
    public static void main(String[] args) {
    	int n = 20;
    	int sum = 1;
    	for(int i = 2; i <= n; i++) {
    		//对角线是一个等差数列,公差是4的倍数(最开始是1倍,2倍,3倍)
    		sum += (i-1)*4;
    	}
    	System.out.println(sum);
    }
}