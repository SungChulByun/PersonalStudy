package DynamicProgramming;

import java.util.*;
public class DP_10_coin2_2294 {
	static int coin[], dp[][];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in) ;
		int n = sc.nextInt();
		int val = sc.nextInt();
		coin = new int[n];
		for(int i=0;i<n;i++) {
			coin[i]=sc.nextInt();
		}
		dp = new int[n][val+1];
		for(int i=0;i<n;i++) {
			for(int j=0;j<=val;j++) dp[i][j]=-1;
		}
		Arrays.sort(coin);
		for(int i=0;i<n;i++) {
			for(int j=0;j<=val;j++) {
				myfunc(i, j);
			}
		}
//		printmap(dp);
		int ans = dp[n-1][val];
		if(ans<=0) ans=-1;
		System.out.println(ans);
	}
	static void myfunc(int num, int val) {
		if(num==0) {
			if(val!=0&&val%coin[0]==0) dp[num][val]=val/coin[0];
		}
		else {
			int max = coin[num];
			int q = val/max;
			int tp=Integer.MAX_VALUE;
			boolean avail=false;
			for(int i=0;i<=q;i++) {
				if(dp[num-1][val-i*max]>=0) {
					avail=true;
					tp=Math.min(i+dp[num-1][val-i*max], tp);
				}
				else {
					if(val%max==0) {
						avail=true;
						tp=q;
					}
				}
			}
			if(avail) dp[num][val]=tp;
			else dp[num][val]=-1;
		}
	}
	static void printmap(int[][] map) {
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}