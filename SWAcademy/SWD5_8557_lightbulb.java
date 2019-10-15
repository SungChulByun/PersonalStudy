package SWAcademy;

import java.util.Scanner;
public class SWD5_8557_lightbulb {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		double[] ans = new double[t];
		for(int tt=0;tt<t;tt++) {
			double p = sc.nextDouble();
			long n = sc.nextLong();
			ans[tt]=seq(p, n);
		}
		for(int i=0;i<t;i++) {
			System.out.println("#"+(i+1)+" "+ans[i]);
		}
	}
	static double seq(double pr, long x) {
		return 0.5-0.5*sqtime(1-2*pr, x);
	}
	static double sqtime(double pr, long x) {
		if(x==0) return 1;
		else if(x<10) {
			return Math.pow(pr, x);
		}
		else {
			return Math.pow(sqtime(pr, x/10), 10)*sqtime(pr, x%10);
		}
	}
}
