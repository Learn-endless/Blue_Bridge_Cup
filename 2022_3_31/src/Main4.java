import java.util.ArrayList;
import java.util.Arrays;

public class Main4 {
    public static ArrayList<String> tmp = new ArrayList<>();
    public static String[][] countSubstrings(String s) {
        for (int i=0; i < s.length(); i++){
            count(s, i, i);//回文串长度为奇数
            count(s, i, i+1);//回文串长度为偶数
        }
        
        String[] ret = new String[tmp.size()];
        for(int i = 0; i < tmp.size(); i++) {
        	ret[i] = tmp.get(i);
        }
        
        String[][] rt = new String[1][];
        rt[0] = ret;
        return rt;
    }
    
    public static void count(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
        	String t = s.substring(start, end+1);
        	tmp.add(t);
            start--;
            end++;
        }
    }
	public static void main(String[] args) {
		String s = "google";
		String[][] ret = countSubstrings(s);
		System.out.println(Arrays.deepToString(ret));
	}
}