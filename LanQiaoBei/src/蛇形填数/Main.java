package ��������;

public class Main {
    public static void main(String[] args) {
    	int n = 20;
    	int sum = 1;
    	for(int i = 2; i <= n; i++) {
    		//�Խ�����һ���Ȳ�����,������4�ı���(�ʼ��1��,2��,3��)
    		sum += (i-1)*4;
    	}
    	System.out.println(sum);
    }
}