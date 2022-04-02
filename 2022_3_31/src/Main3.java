
public class Main3 {
	
	private static int huiWenString(String s) {
		int len = s.length();
		if(len == 1 || isPal(s,0,len-1)) {
			return 0;
		}
		
		int[] array = new int[len+1];
		//初始化
		for(int i = 1; i <= len; i++) {
			array[i] = i-1;
		}
		
		//状态转移方程：F[i] = j < i && [j+1,i]isPal : Math.min(F[i],F[j]+1)
		for(int i = 1; i <= len; i++) {
			for(int j = 1; j < i; j++) {
				
				if(isPal(s,0,i-1)) {
					array[i] = 0;
					continue;
				}
				
				if(isPal(s,j,i-1)) {
					array[i] = Math.min(array[i], array[j]+1);
				}
			}
		}
		return array[len];
	}
	
	
	private static boolean isPal(String s,int start,int end) {
		while(start < end) {
			if(s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "google";
		int ret = huiWenString(s);
		System.out.println(ret);
	}
}
