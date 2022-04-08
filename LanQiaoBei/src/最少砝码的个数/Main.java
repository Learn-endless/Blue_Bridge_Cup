package 最少砝码的个数;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int count = 1;
		int total = 1;
		int weight = 1;
		while(total < n) {
			count++;
			weight*=3;
			total += weight;
		}
		System.out.println(count);
	}
}
