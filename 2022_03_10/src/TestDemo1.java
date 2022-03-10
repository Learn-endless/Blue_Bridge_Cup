import java.util.Scanner;

/**
  *  扫雷
 * @author 19833
 *
 */
public class TestDemo1 {
    public static int total(int[][] arr,int x,int y){
        return arr[x-1][y-1]+arr[x-1][y]+arr[x-1][y+1]+arr[x][y-1]+arr[x][y+1]+arr[x+1][y-1]+arr[x+1][y]+arr[x+1][y+1];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        //输入行数和列数
        int n = scan.nextInt();
        int m = scan.nextInt();
        //创建两个数组
        int[][] arr = new int[n+2][m+2];   //存放雷
        int[][] tmp = new int[n+2][m+2];   //存放雷的信息
        //遍历开始放雷
        for(int i = 1; i <= n; i++){
          for(int j = 1; j <= m; j++){
            arr[i][j] = scan.nextInt();
          }
        }
        //遍历开始统计雷的信息,并将雷的信息放到 tmp数组中去
        for(int i = 1; i <= n; i++){
          for(int j = 1; j <= m; j++){
            if(arr[i][j] == 0){
              tmp[i][j] = total(arr,i,j);
            }else{
              tmp[i][j] = 9;
            }
          }
        }
        //打印 tmp 数组中存放雷的信息
        for(int i = 1; i <= n; i++){
          for(int j = 1; j <= m; j++){
            System.out.print(tmp[i][j]+" ");
          }
          System.out.println();
        }
        scan.close();
    }
}
