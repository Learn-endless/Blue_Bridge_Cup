
public class Main6 {
	
	/**
	 * 题目：编辑最小次数
	 * @param word1    第一个字符串
	 * @param word2    第二个字符串
	 * @return   返回最小编辑次数
	 */
	private static int func(String word1,String word2) {
		int[][] board = new int[word1.length()+1][word2.length()+1];
		
		//表示 word2 的前 i 个字符 (最前面加一个辅助状态——空串)
		for(int i = 0; i <= word2.length(); i++) {
			board[0][i] = i;
		}
		//表示 word1 的前 i 个字符 (最前面加一个辅助状态——空串)
		for(int i = 0; i <= word1.length(); i++) {
			board[i][0] = i;
		}
		//遍历整个矩阵: 从 board[1][1] 开始统计——将word1的前 i 个字符变成 word2 的前 j 个字符的最小操作次数
		for(int i = 1; i <= word1.length(); i++) {
			for(int j = 1; j <= word2.length(); j++) {
				
				//先进行 添加 和 删除 操作的比较(操作次数的比较)，拿到最小的操作次数
				board[i][j] = Math.min(board[i][j-1]+1, board[i-1][j]+1);
				//然后查看 word1 的前 i 个字符和 word2 的前 j 个字符是否一样
				if(word1.charAt(i-1) == word2.charAt(j-1)) {
					//一样的话不用进行替换操作，直接拿到当前的操作次数与 i-1 变到 j-1的操作次数中的最小值，更新
					board[i][j] = Math.min(board[i][j], board[i-1][j-1]);
				}else {	
					//反之，说明还需要进行一次比较 (将前面的删除和添加操作次数再与替换的操作次数进行比较，拿到最小值)
					board[i][j] = Math.min(board[i][j], board[i-1][j-1]+1);
				}
			}
		}
		
		/**
		 * 这里只是查看一下当前矩阵里存放的求出最小编辑次数的过程
		 */
		for(int i = 0; i <= word1.length(); i++) {
			for(int j = 0; j <= word2.length(); j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		//返回矩阵的最后一行的最后一列的值
		return board[word1.length()][word2.length()];
	}
	
	public static void main(String[] args) {
		String s1 = "bite";
		String s2 = "bite";
		
		int ret = func(s1,s2);
		System.out.println(ret);
	}
}
