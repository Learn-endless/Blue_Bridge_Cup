/**
 * 试题 算法提高 Cat And Mouse
 * @author 19833
 *
 */
public class Main3 {
	public static char[][] board = {                   //地图
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
	public static int nMin = -1;            //横坐标的最小边界
	public static int nMax = 10;            //横坐标的最大边界
	public static int mMin = -1;            //纵坐标的最小边界
	public static int mMax = 10;            //纵坐标的最大边界
	public static void main(String[] args) {
		//分别存放猫和老鼠的起始坐标
		int[] c = {4,5}; 
		int[] m = {7,2};
		//游戏开始，返回时间
 		int time = game(c,m);
		System.out.println(time);
	}
	
	/**
	 * 猫捉老鼠主功能方法
	 * @param c   猫的坐标
	 * @param m   老鼠的坐标
	 * @return
	 */
	private static int game(int[] c, int[] m) {
		int time = 0;            //用来记录秒数
		int flagCat = 0;         
		int flagMouse = 0;       //用来标记当前是往哪走的 0 北  1东  2南   3西
		
		//循环遍历，直到老鼠和猫的坐标相同就停止
		while(!isEquals(c,m)) {  
			//猫和老鼠各自都移动一步
			flagCat = catMove(c,flagCat);           //返回下一次移动的方向
			flagMouse = mouseMove(m,flagMouse);     //同理返回老鼠下一次需要移动的方向
			time++;   //计时
		}
		return time;
	}

	/**
	 * 老鼠移动
	 * @param m
	 * @param flagMouse
	 * @return
	 */
	private static int mouseMove(int[] m, int flagMouse) {
		if(flagMouse == 0) {
			//向北移动
			//先判断坐标是否合法
			if(isNorthMove(m)) {
				return 0;
			}else {
				//需要右转
				return 1;
			}
		}else if(flagMouse == 1) {
			//向东移动
			if(isEastMove(m)) {
				return 1;
			}else {
				//需要右转
				return 2;
			}
		}else if(flagMouse == 2) {
			//向南移动
			if(isSouthMove(m)) {
				return 2;
			}else {
				//需要右转
				return 3;
			}
		}else {
			//向西移动
			if(isWestMove(m)) {
				return 3;
			}else {
				//需要右转
				return 0;
			}
		}
	}

	/**
	 * 向西移动方法
	 * @param array
	 * @return
	 */
	private static boolean isWestMove(int[] array) {
		//判断下标是否越界
		if(array[1]-1 <= mMin) {
			return false;
		}
		//判断移动方向上是否有障碍物
		if(board[array[0]][array[1]-1] == '*') {
			return false;
		}
		array[1] = array[1]-1;      //向西移动一位
		return true;
	}

	/**
	 * 向南移动方法
	 * @param array
	 * @return
	 */
	private static boolean isSouthMove(int[] array) {
		//判断下标是否越界
		if(array[0]+1 >= nMax) {
			return false;
		}
		//判断移动方向上是否有障碍物
		if(board[array[0]+1][array[1]] == '*') {
			return false;
		}
		array[0] = array[0]+1;      //向南移动一位
		return true;
	}

	/**
	 * 向东移动方法
	 * @param array
	 * @return
	 */
	private static boolean isEastMove(int[] array) {
		//判断下标是否越界
		if(array[1]+1 >= mMax) {
			return false;
		}
		//判断移动方向上是否有障碍物
		if(board[array[0]][array[1]+1] == '*') {
			return false;
		}
		array[1] = array[1]+1;      //向东移动一位
		return true;
	}

	/**
	 * 向北移动方法
	 * @param array
	 * @return
	 */
	private static boolean isNorthMove(int[] array) {
		//判断下标是否越界
		if(array[0]-1 <= nMin) {
			return false;
		}
		//判断移动方向上是否有障碍物
		if(board[array[0]-1][array[1]] == '*') {
			return false;
		}
		array[0] = array[0]-1;      //向上移动一位
		return true;
	}

	/**
	 * 猫移动
	 * @param c
	 * @param flagCat
	 * @return
	 */
	private static int catMove(int[] c, int flagCat) {
		if(flagCat == 0) {
			//向北移动
			//先判断坐标是否合法
			if(isNorthMove(c)) {
				return 0;
			}else {
				//需要右转
				return 1;
			}
		}else if(flagCat == 1) {
			//向东移动
			if(isEastMove(c)) {
				return 1;
			}else {
				//需要右转
				return 2;
			}
		}else if(flagCat == 2) {
			//向南移动
			if(isSouthMove(c)) {
				return 2;
			}else {
				//需要右转
				return 3;
			}
		}else {
			//向西移动
			if(isWestMove(c)) {
				return 3;
			}else {
				//需要右转
				return 0;
			}
		}
	}

	/**
	  * 判断猫和老鼠的位置是否相等了
	 * @param c  猫的横坐标        猫的纵坐标 
	 * @param m  老鼠的横坐标    老鼠的纵坐标 
	 */
	private static boolean isEquals(int[] c,int[] m) {
		return c[0] == m[0] && c[1] == m[1];
	}
}
