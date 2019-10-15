package DynamicProgramming;

import java.util.*;
public class DP_06_LCS_9251 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String x = sc.next();
		String y = sc.next();
		int n = x.length();
		int m = y.length();
		int data[][] = new int[n+1][m+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(x.charAt(i-1)==y.charAt(j-1)) {
					data[i][j]=data[i-1][j-1]+1;
				}
				else {
					data[i][j]=Math.max(data[i-1][j], data[i][j-1]);
				}
			}
		}
		System.out.println(data[n][m]);
		
	}
}
