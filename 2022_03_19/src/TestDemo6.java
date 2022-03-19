import java.util.*;

public class TestDemo6
{
	static int a[][]=new int [2100][2100],n=2021,N=2100;
	static int INF=0x3f3f3f3f;
	static int dist[]=new int[2100];
	static boolean st[]=new boolean[N];
	static void dijkstra(int u)
	{
		Arrays.setAll(dist, x->INF);
		dist[u]=0;
		//st[u]=true;
		for(int i=0;i<n;++i)
		{
			int t=-1;
			for(int j=1;j<=n;++j)
			{
				if(!st[j]&&(t==-1||dist[j]<dist[t]))t=j;
			}
			st[t]=true;
			for(int j=1;j<=n;++j)
			{
				if(dist[j]>dist[t]+a[t][j])
				{
					dist[j]=dist[t]+a[t][j];
				}
			}
		}
		
	}
	static int gcd(int a,int b)
	{
		return (b==0)?a:gcd(b,a%b);
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<2100;++i)Arrays.setAll(a[i],x->INF);
		for(int i=1;i<=2021;i++)
		{
			for(int j=i;j<i+22;++j)
			{
				if(i==j)a[i][j]=0;
				else
				{
					a[i][j]=i*j/gcd(i,j);
					a[j][i]=a[i][j];
				}
			}
		}
		dijkstra(1);
		System.out.println(dist[2021]);
	}
}