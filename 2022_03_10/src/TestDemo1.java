import java.util.Scanner;

/**
  *  ɨ��
 * @author 19833
 *
 */
public class TestDemo1 {
    public static int total(int[][] arr,int x,int y){
        return arr[x-1][y-1]+arr[x-1][y]+arr[x-1][y+1]+arr[x][y-1]+arr[x][y+1]+arr[x+1][y-1]+arr[x+1][y]+arr[x+1][y+1];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //�ڴ��������Ĵ���...
        //��������������
        int n = scan.nextInt();
        int m = scan.nextInt();
        //������������
        int[][] arr = new int[n+2][m+2];   //�����
        int[][] tmp = new int[n+2][m+2];   //����׵���Ϣ
        //������ʼ����
        for(int i = 1; i <= n; i++){
          for(int j = 1; j <= m; j++){
            arr[i][j] = scan.nextInt();
          }
        }
        //������ʼͳ���׵���Ϣ,�����׵���Ϣ�ŵ� tmp������ȥ
        for(int i = 1; i <= n; i++){
          for(int j = 1; j <= m; j++){
            if(arr[i][j] == 0){
              tmp[i][j] = total(arr,i,j);
            }else{
              tmp[i][j] = 9;
            }
          }
        }
        //��ӡ tmp �����д���׵���Ϣ
        for(int i = 1; i <= n; i++){
          for(int j = 1; j <= m; j++){
            System.out.print(tmp[i][j]+" ");
          }
          System.out.println();
        }
        scan.close();
    }
}
