
public class Main4 {
/**
  * 542. 01 矩阵
    * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
    * 两个相邻元素间的距离为 1 。
  * DP  两次遍历  ,拿到四个方向的最小值
  */
    public static int[][] updateMatrix_1(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // 第一次遍历，正向遍历，根据相邻左元素和上元素得出当前元素的对应结果
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = row + col;
                }
                if (i > 0) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i - 1][j] + 1);
                }
                if (j > 0) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][j - 1] + 1);
                }
            }
        }
        // 第二次遍历，反向遍历，根据相邻右元素和下元素及当前元素的结果得出最终结果
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i < row - 1) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i + 1][j] + 1);
                }
                if (j < col - 1) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][j + 1] + 1);
                }
            }
        }
        return matrix;
    }
    
    public static void main(String[] args) {
		int[][] ret = {{1,0,1,1,0,0},{1,0,0,0,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,0,0,0,0,1}};
		
		int[][] tmp = updateMatrix_1(ret);
		for(int i = 0; i < tmp.length; i++) {
			for(int j = 0; j < tmp[0].length; j++) {
				System.out.print(tmp[i][j]+"  ");
			}
			System.out.println();
		}
	}
}
