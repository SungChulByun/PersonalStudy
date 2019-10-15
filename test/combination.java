package test;

import java.util.*;
public class combination {
	static long[][] dp;
	static int n, m;
	public static void main(String args[]) {
		combination(30, 30);
	}
	static void combination(int n, int m) {
		dp = new long[n+1][m+1];
		for(int i=0;i<=m;i++) {
			dp[0][i]=1;
		}
		for(int i=1;i<=n;i++) {
			dp[i][0]=1;
			for(int j=1;j<=m;j++) {
				dp[i][j]=(dp[i-1][j]+dp[i][j-1]);
			}
		}
		System.out.println(dp[n][m]);
	}
}
