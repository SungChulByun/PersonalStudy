package SWAcademy;

import java.util.*;
public class SWD4_GCD_8659 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] data = new int[t];
		int mx = 0;
		for(int tt=0;tt<t;tt++) {
			int x = sc.nextInt();
			data[tt]=x;
			mx = Math.max(mx, x);
		}
		long[] fibo = genFibo(mx);
		for(int i=0;i<t;i++) {
			System.out.println("#"+(i+1)+" "+fibo[data[i]]+" "+fibo[data[i]-1]);
		}
	}
	static long[] genFibo(int n) {
		long[] fibo=new long[n+1];
		fibo[0]=1;
		fibo[1]=2;
		for(int i=2;i<n+1;i++) {
			fibo[i]=fibo[i-1]+fibo[i-2];
		}
		return fibo;
	}
}
