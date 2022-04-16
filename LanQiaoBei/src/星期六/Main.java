package ĞÇÆÚÁù;

public class Main {
	
	public static void main(String[] args) {
		int ret = (int) (Math.pow(20, 22) % 7);
		System.out.println(ret+6);
	}
	
	public static void main1(String[] args) {
		int day = 6;
		for(int i = 1; i <= Math.pow(20, 22); i++) {
			if(day == 7) {
				day = 1;
			}else {
				day++;
			}
		}
		System.out.println(day);
	}
}	
