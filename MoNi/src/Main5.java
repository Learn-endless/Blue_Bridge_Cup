import java.util.Scanner;
public class Main5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int a = sc.nextInt();
		int t = sc.nextInt();
		int sum = 0;
		while(sum < t){
		    sum += a;
		    count++;
		}
		System.out.println(count);
	}
}