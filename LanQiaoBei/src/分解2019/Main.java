package 分解2019;

public class Main {
	

	public static void main(String[] args) {
		int count=0;
		for(int i = 1; i < 2019; i++) {
			if(isE(i)) {
				for(int j = i + 1; j < 2019; j++) {
					if(isE(j)) {
						int k = 2019-i-j;
						if(k > 0 && isE(k)) {
							System.out.println(i+" "+j+" "+k);
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);	
	}
 
//判断数字中是否包含2和4，因为要多次使用所以可单独定义一个函数调用
	static boolean isE(int i){
		while(i != 0) {
			if(i % 10 == 2 || i % 10 == 4) {
				return false;
			}
			i /= 10;
		}
		return true;
	}
}
