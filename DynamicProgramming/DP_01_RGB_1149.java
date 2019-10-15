package DynamicProgramming;

import java.util.*;
public class DP_01_RGB_1149 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] r = new int[n];
		int[] rr = new int[n];
		int[] g = new int[n];
		int[] gg = new int[n];
		int[] b = new int[n];
		int[] bb = new int[n];
		for(int i=0;i<n;i++) {
			r[i]=sc.nextInt();
			g[i]=sc.nextInt();
			b[i]=sc.nextInt();
		}
		rr[0]=r[0];
		gg[0]=g[0];
		bb[0]=b[0];
		for(int i=1;i<n;i++) {
			rr[i]=Math.min(gg[i-1]+r[i], bb[i-1]+r[i]);
			gg[i]=Math.min(rr[i-1]+g[i], bb[i-1]+g[i]);
			bb[i]=Math.min(gg[i-1]+b[i], rr[i-1]+b[i]);
		}
		int answer = 0;
		answer = Math.min(rr[n-1], gg[n-1]);
		answer = Math.min(answer, bb[n-1]);
		System.out.println(answer);
	}
}
