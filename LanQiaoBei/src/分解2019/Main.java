package �ֽ�2019;

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
 
//�ж��������Ƿ����2��4����ΪҪ���ʹ�����Կɵ�������һ����������
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
