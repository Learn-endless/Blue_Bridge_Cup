import java.util.*;

public class TestDemo7 {
	public static int count = 0;
	public static int num = 0;
	public static boolean flg = false;
	public static int ret = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String s = sc.nextLine();
			if(s.equals(".")) {
				return;
			}
			String[] str = s.split(" ");
			int n = Integer.parseInt(str[2]);
			String[][] array = new String[n][2];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < 2; j++) {
					array[i][j] = sc.next();
				}
			}
			num++;
			dfs(str[0],str[1],n,array);
			if(flg) {
				System.out.println("\ncase "+num+": "+ret);
			}else {
				System.out.println("case "+num+": No solution");
			}
			count = 0;
			flg = false;
			sc.nextLine();
		}
	}

	private static void dfs(String s1, String s2,int hang,String[][] array) {
		if(s1.equals(s2)) {
			ret = count;
			flg = true;
			return;
		}
		for(int i = 0; i < hang; i++) {
			if(s1.contains(array[i][0])) {
				if(s1.equals(array[i][0])) {
					count++;
					dfs(array[i][1],s2,hang,array);
					count--;
				}else {
					s1.replaceFirst(array[i][0], array[i][1]);
					count++;
					dfs(s1,s2,hang,array);
					count--;
				}
			}
		}
	}
}
