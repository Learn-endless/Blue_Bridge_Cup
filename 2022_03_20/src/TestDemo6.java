
public class TestDemo6 {
	/**
	  * »õÎï°Ú·Å
	 */
	public static long N = 2021041820210418L;

	public static int count = 0;
	public static void main(String[] args) {
		long[] cnt = new long[1000100];
		int ret = 0;
		for(long i= 1;i <= Math.sqrt(N);i++){
	        if(N % i == 0){
	            cnt[ret++] = i;
	            cnt[ret++] = N / i;
	        }
	    }
		
		for(int i = 0; i < ret; i++) {
			for(int j = 0; j < ret; j++) {
				if(N % (cnt[i] * cnt[j]) == 0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
