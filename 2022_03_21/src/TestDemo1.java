import java.util.*;

public class TestDemo1 {
	
	static class Line {
		public double k;
		public double b;
		
		public Line(double k,double b) {
			this.k = k;
			this.b = b;
		}
	}
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		for(int x1=0;x1<2;x1++){
			for(int y1=0;y1<3;y1++){	
				for(int x2=0; x2 < 2;x2++){
					for(int y2=0;y2<3;y2++){			
						if(x1 != x2) {
							double k=(y2-y1)*1.0/(x2-x1);
							double b=(y1*x2-x1*y2)*1.0/(x2-x1);
							set.add(k+"="+b);
							System.out.println(x1+" :: "+y1);
							System.out.println(x2+" :: "+y2);
							System.out.println(k+"="+b);
							System.out.println("-------------------");
						}
					}
				}
			}
		}
		
		System.out.println(set.size()+2);
	}
}
