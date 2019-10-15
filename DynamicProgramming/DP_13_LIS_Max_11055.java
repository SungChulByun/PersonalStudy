package DynamicProgramming;

import java.util.*;
public class DP_13_LIS_Max_11055 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int data[] = new int[n];
		int dp[] = new int[n];
		int answer=0;
		for(int i=0;i<n;i++) {
			data[i]=sc.nextInt();
			dp[i]=data[i];
		}
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
//				System.out.println("here");
				if(data[i]>data[j]) {
//					System.out.println("here");
					dp[i]=Math.max(dp[i], dp[j]+data[i]);
				}
			}
		}

		for(int i=0;i<n;i++) {
			answer=Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
}
