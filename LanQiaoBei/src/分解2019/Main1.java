package 分解2019;

public class Main1 {
	public static void main(String[] args) {
	    int n = 2019;

	    int index = 0;  //记录有多少种分解方法
	    for (int i = 1; i < (int)(n / 2); i++) {	//按照我的思路，第一个数是不会大于n/2的，所以缩小了范围
	        if (isE(i)) {
	            continue;
	        }
	        for (int j = i + 1; j < n; j++) {
	            if (isE(j)) {
	                continue;
	            }
	            for (int k = j + 1; k < n; k++) {
	                if (isE(k)) {
	                    continue;
	                }

	                if (i + j + k == n) {
	                	System.out.println(i+" "+j+" "+k);
	                    index++;
	                }
	            }
	        }
	    }

	    System.out.println(index);
	}
    
  //判断数字中是否包含2和4，因为要多次使用所以可单独定义一个函数调用
  	static boolean isE(int i){
  		while(i != 0) {
  			if(i % 10 == 2 || i % 10 == 4) {
  				return true;
  			}
  			i /= 10;
  		}
  		return false;
  	}
}
