import java.util.*;

public class TestDemo3{
	public static int a[][]=new int [2100][2100],n=2021;
	public static int INF=Integer.MAX_VALUE/2;
	public static int dist[]=new int[2100];
	public static boolean flg[]=new boolean[2100];
	
	
	static void dijkstra(int u){
		Arrays.fill(dist, INF);
		
		dist[u]=0;	
		
		for(int i= 2;i <= n;++i){
			
			int t=-1;
			
			for(int j=1;j<=n;++j){
				if(flg[j] == false &&(t==-1||dist[j]<dist[t])) {
					t=j;
				}
			}
			flg[t]=true;
			
			for(int j=1;j<=n;++j){
				dist[j] = Math.min(dist[j], dist[t]+a[t][j]);
			}
		}
		
	}
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		
		for(int i = 1; i <= 2021; i++) {
			for(int j = 1; j <= 2021; j++) {
				if(i == j) {
					a[i][j] = 0;
					
				}else if(Math.abs(i-j) > 21) {
					a[i][j] = INF;
				}else {
					a[i][j] = lcm(i,j);
				}
			}
		}
		dijkstra(1);
		System.out.println(dist[2021]);
	}	
	
	
	
	public static int gcd(int a,int b){
		if(b == 0) {
			return a;
		}
		return gcd(b,a%b);
	}
	
	public static int lcm(int a,int b) {
		return a*b/gcd(a,b);
	}
}