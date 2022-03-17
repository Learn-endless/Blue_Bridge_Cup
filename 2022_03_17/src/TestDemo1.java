
import java.util.*;
public class TestDemo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();
		double x2 = sc.nextDouble();
		double y2 = sc.nextDouble();
		double x3 = sc.nextDouble();
		double y3 = sc.nextDouble();
		double x4 = sc.nextDouble();
		double y4 = sc.nextDouble();
		
		if(x1 > x2) {
			double tmp = x1;
			x1 = x2;
			x2 = tmp;
		}
		if(y1 > y2) {
			double tmp = y1;
			y1 = y2;
			y2 = tmp;
		}
		if(x3 > x4) {
			double tmp = x3;
			x3 = x4;
			x4 = tmp;
		}
		if(y3 > y4) {
			double tmp = y3;
			y3 = y4;
			y4 = tmp;
		}
		
		double max1 = Math.max(x1,x3);   //行  左
		double min1 = Math.min(x2,x4);   //行  右
		
		double max2 = Math.max(y1,y3);   //列  左
		double min2 = Math.min(y2,y4);   //列  右
		
		double ans = Math.max((min1-max1)*(min2-max2),0.0);
		if(min1 < max1 && min2 < max2) {
			System.out.printf("%.2f",0.0);
		}else{
			System.out.printf("%.2f",ans);
		}
	}
}
