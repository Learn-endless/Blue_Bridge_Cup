package �ֽ�2019;

public class Main1 {
	public static void main(String[] args) {
	    int n = 2019;

	    int index = 0;  //��¼�ж����ַֽⷽ��
	    for (int i = 1; i < (int)(n / 2); i++) {	//�����ҵ�˼·����һ�����ǲ������n/2�ģ�������С�˷�Χ
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
    
  //�ж��������Ƿ����2��4����ΪҪ���ʹ�����Կɵ�������һ����������
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
