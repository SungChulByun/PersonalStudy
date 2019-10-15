package DynamicProgramming;

import java.util.*;
public class DP_14_SumDivision_2225 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = n;
		int y = m-1;
		long[][] dp = new long[x+1][y+1];
		for(int i=0;i<=y;i++) {
			dp[0][i]=1;
		}
		for(int i=1;i<=x;i++) {
			dp[i][0]=1;
			for(int j=1;j<=y;j++) {
				dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000000;
			}
		}
//		printmap(dp);
		System.out.println(dp[x][y]%1000000000);
	}
	static void printmap(long[][] map) {
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
