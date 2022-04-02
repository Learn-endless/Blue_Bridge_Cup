import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main5 {
	private static boolean isPal(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static ArrayList<String> countSubstrings(String s) {
    	ArrayList<String> pr = new ArrayList<>();
        int len = s.length();
        if(len == 1){
            return null;
        }
        int[] mat = new int[len];
        for(int i = 0; i < len; i++){
            mat[i] = 1;
        }

        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                if(isPal(s,j,i)){
                    pr.add(s.substring(j, i+1));
                    mat[i]++;
                }
                if(j + 1 == i){
                    mat[i] += mat[j];
                }
            }
        }
        System.out.println(mat[len-1]);
        return pr;
    }
    
    public static void main(String[] args) {
    	ArrayList<String> s = countSubstrings("google");
    	Iterator<String> st = s.iterator();
    	while(st.hasNext()) {
    		System.out.println(st.next());
    	}
	}
}
