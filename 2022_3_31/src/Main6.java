
public class Main6 {
	
	/**
	 * ��Ŀ���༭��С����
	 * @param word1    ��һ���ַ���
	 * @param word2    �ڶ����ַ���
	 * @return   ������С�༭����
	 */
	private static int func(String word1,String word2) {
		int[][] board = new int[word1.length()+1][word2.length()+1];
		
		//��ʾ word2 ��ǰ i ���ַ� (��ǰ���һ������״̬�����մ�)
		for(int i = 0; i <= word2.length(); i++) {
			board[0][i] = i;
		}
		//��ʾ word1 ��ǰ i ���ַ� (��ǰ���һ������״̬�����մ�)
		for(int i = 0; i <= word1.length(); i++) {
			board[i][0] = i;
		}
		//������������: �� board[1][1] ��ʼͳ�ơ�����word1��ǰ i ���ַ���� word2 ��ǰ j ���ַ�����С��������
		for(int i = 1; i <= word1.length(); i++) {
			for(int j = 1; j <= word2.length(); j++) {
				
				//�Ƚ��� ��� �� ɾ�� �����ıȽ�(���������ıȽ�)���õ���С�Ĳ�������
				board[i][j] = Math.min(board[i][j-1]+1, board[i-1][j]+1);
				//Ȼ��鿴 word1 ��ǰ i ���ַ��� word2 ��ǰ j ���ַ��Ƿ�һ��
				if(word1.charAt(i-1) == word2.charAt(j-1)) {
					//һ���Ļ����ý����滻������ֱ���õ���ǰ�Ĳ��������� i-1 �䵽 j-1�Ĳ��������е���Сֵ������
					board[i][j] = Math.min(board[i][j], board[i-1][j-1]);
				}else {	
					//��֮��˵������Ҫ����һ�αȽ� (��ǰ���ɾ������Ӳ������������滻�Ĳ����������бȽϣ��õ���Сֵ)
					board[i][j] = Math.min(board[i][j], board[i-1][j-1]+1);
				}
			}
		}
		
		/**
		 * ����ֻ�ǲ鿴һ�µ�ǰ�������ŵ������С�༭�����Ĺ���
		 */
		for(int i = 0; i <= word1.length(); i++) {
			for(int j = 0; j <= word2.length(); j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		//���ؾ�������һ�е����һ�е�ֵ
		return board[word1.length()][word2.length()];
	}
	
	public static void main(String[] args) {
		String s1 = "bite";
		String s2 = "bite";
		
		int ret = func(s1,s2);
		System.out.println(ret);
	}
}
