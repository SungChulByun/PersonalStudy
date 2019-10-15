package DynamicProgramming;

import java.util.*;
public class DP_09_coin1_2293 {
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
		Arrays.sort(coin);
		for(int i=0;i<n;i++) {
			for(int j=0;j<=val;j++) {
				myfunc(i, j);
			}
		}
		System.out.println(dp[n-1][val]);
	}
	static void myfunc(int num, int val) {
		if(num==0) {
			if(val%coin[0]==0) dp[num][val]=1;
		}
		else {
			int max = coin[num];
			int q = val/max;
			for(int i=0;i<=q;i++) {
				dp[num][val]+=dp[num-1][val-i*max];
			}
		}
	}
}