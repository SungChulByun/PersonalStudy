package SWAcademy;
import java.util.*;
public class SWD4_Quiz_7965 {
	static long div = 1000000007;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] data = new int[t];
		int mx = 0;
		for(int tc=0;tc<t;tc++) {
			data[tc]=sc.nextInt();
			mx = Math.max(mx, data[tc]);
		}
		long[] dp = new long[mx+1];
		for(int i=1;i<=mx;i++) {
			dp[i]=(power(i, i)+dp[i-1])%div;
		}
		for(int i=0;i<t;i++) {
			System.out.println("#"+(i+1)+" "+dp[data[i]]);
		}
	}
	static long power(long x, long y) {
		if(y==0) return 1;
		else if(y==1) return x;
		else {
			long nx = Math.min(x, Math.abs(div-x));
			nx = (nx*nx)%div;
			return (power(nx, y/2)*power(x, y%2))%div;
		}
	}
}
