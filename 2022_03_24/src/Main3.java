/**
 * ���� �㷨��� Cat And Mouse
 * @author 19833
 *
 */
public class Main3 {
	public static char[][] board = {                   //��ͼ
			 {'*','.','.','.','*','.','.','.','.','.'},
			 {'.','.','.','.','.','.','*','.','.','.'},
			 {'.','.','.','*','.','.','.','*','.','.'},
			 {'.','.','.','.','.','.','.','.','.','.'},
			 {'.','.','.','*','.','C','*','.','.','.'},
			 {'*','.','.','.','.','.','*','.','.','.'},
			 {'.','.','.','*','.','.','.','.','.','.'},
			 {'.','.','M','.','.','.','.','.','.','*'},
			 {'.','.','.','*','.','*','.','.','.','.'},
			 {'.','*','.','*','.','.','.','.','.','.'},
			};
	public static int nMin = -1;            //���������С�߽�
	public static int nMax = 10;            //����������߽�
	public static int mMin = -1;            //���������С�߽�
	public static int mMax = 10;            //����������߽�
	public static void main(String[] args) {
		//�ֱ���è���������ʼ����
		int[] c = {4,5}; 
		int[] m = {7,2};
		//��Ϸ��ʼ������ʱ��
 		int time = game(c,m);
		System.out.println(time);
	}
	
	/**
	 * è׽���������ܷ���
	 * @param c   è������
	 * @param m   ���������
	 * @return
	 */
	private static int game(int[] c, int[] m) {
		int time = 0;            //������¼����
		int flagCat = 0;         
		int flagMouse = 0;       //������ǵ�ǰ�������ߵ� 0 ��  1��  2��   3��
		
		//ѭ��������ֱ�������è��������ͬ��ֹͣ
		while(!isEquals(c,m)) {  
			//è��������Զ��ƶ�һ��
			flagCat = catMove(c,flagCat);           //������һ���ƶ��ķ���
			flagMouse = mouseMove(m,flagMouse);     //ͬ����������һ����Ҫ�ƶ��ķ���
			time++;   //��ʱ
		}
		return time;
	}

	/**
	 * �����ƶ�
	 * @param m
	 * @param flagMouse
	 * @return
	 */
	private static int mouseMove(int[] m, int flagMouse) {
		if(flagMouse == 0) {
			//���ƶ�
			//���ж������Ƿ�Ϸ�
			if(isNorthMove(m)) {
				return 0;
			}else {
				//��Ҫ��ת
				return 1;
			}
		}else if(flagMouse == 1) {
			//���ƶ�
			if(isEastMove(m)) {
				return 1;
			}else {
				//��Ҫ��ת
				return 2;
			}
		}else if(flagMouse == 2) {
			//�����ƶ�
			if(isSouthMove(m)) {
				return 2;
			}else {
				//��Ҫ��ת
				return 3;
			}
		}else {
			//�����ƶ�
			if(isWestMove(m)) {
				return 3;
			}else {
				//��Ҫ��ת
				return 0;
			}
		}
	}

	/**
	 * �����ƶ�����
	 * @param array
	 * @return
	 */
	private static boolean isWestMove(int[] array) {
		//�ж��±��Ƿ�Խ��
		if(array[1]-1 <= mMin) {
			return false;
		}
		//�ж��ƶ��������Ƿ����ϰ���
		if(board[array[0]][array[1]-1] == '*') {
			return false;
		}
		array[1] = array[1]-1;      //�����ƶ�һλ
		return true;
	}

	/**
	 * �����ƶ�����
	 * @param array
	 * @return
	 */
	private static boolean isSouthMove(int[] array) {
		//�ж��±��Ƿ�Խ��
		if(array[0]+1 >= nMax) {
			return false;
		}
		//�ж��ƶ��������Ƿ����ϰ���
		if(board[array[0]+1][array[1]] == '*') {
			return false;
		}
		array[0] = array[0]+1;      //�����ƶ�һλ
		return true;
	}

	/**
	 * ���ƶ�����
	 * @param array
	 * @return
	 */
	private static boolean isEastMove(int[] array) {
		//�ж��±��Ƿ�Խ��
		if(array[1]+1 >= mMax) {
			return false;
		}
		//�ж��ƶ��������Ƿ����ϰ���
		if(board[array[0]][array[1]+1] == '*') {
			return false;
		}
		array[1] = array[1]+1;      //���ƶ�һλ
		return true;
	}

	/**
	 * ���ƶ�����
	 * @param array
	 * @return
	 */
	private static boolean isNorthMove(int[] array) {
		//�ж��±��Ƿ�Խ��
		if(array[0]-1 <= nMin) {
			return false;
		}
		//�ж��ƶ��������Ƿ����ϰ���
		if(board[array[0]-1][array[1]] == '*') {
			return false;
		}
		array[0] = array[0]-1;      //�����ƶ�һλ
		return true;
	}

	/**
	 * è�ƶ�
	 * @param c
	 * @param flagCat
	 * @return
	 */
	private static int catMove(int[] c, int flagCat) {
		if(flagCat == 0) {
			//���ƶ�
			//���ж������Ƿ�Ϸ�
			if(isNorthMove(c)) {
				return 0;
			}else {
				//��Ҫ��ת
				return 1;
			}
		}else if(flagCat == 1) {
			//���ƶ�
			if(isEastMove(c)) {
				return 1;
			}else {
				//��Ҫ��ת
				return 2;
			}
		}else if(flagCat == 2) {
			//�����ƶ�
			if(isSouthMove(c)) {
				return 2;
			}else {
				//��Ҫ��ת
				return 3;
			}
		}else {
			//�����ƶ�
			if(isWestMove(c)) {
				return 3;
			}else {
				//��Ҫ��ת
				return 0;
			}
		}
	}

	/**
	  * �ж�è�������λ���Ƿ������
	 * @param c  è�ĺ�����        è�������� 
	 * @param m  ����ĺ�����    ����������� 
	 */
	private static boolean isEquals(int[] c,int[] m) {
		return c[0] == m[0] && c[1] == m[1];
	}
}
