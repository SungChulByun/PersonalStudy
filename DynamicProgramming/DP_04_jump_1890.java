package DynamicProgramming;

import java.util.*;
public class DP_04_jump_1890 {
	static long[][] ans;
	static int n, map[][];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		ans = new long[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		ans[0][0]=1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==n-1&&j==n-1) continue;
				if(ans[i][j]>0) calculate(i, j);
			}
		}
		System.out.println(ans[n-1][n-1]);
	}
	static void calculate(int x, int y) {
		int jump = map[x][y];
		if(x+jump<n) {
			ans[x+jump][y]+=ans[x][y];
		}
		if(y+jump<n) {
			ans[x][y+jump]+=ans[x][y];
		}
	}
	static void printmap(long[][] mp) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(mp[i][j]+" ");
			}
			System.out.println();
		}
	}
}
