package DynamicProgramming;

import java.util.*;
public class DP_05_decliningway_1520 {
	static int dx[] = new int[] {1, -1, 0, 0},
			   dy[] = new int[] {0, 0, -1, 1},
			   n, m, map[][], ans[][];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		ans = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				ans[i][j]=-1;
				map[i][j]=sc.nextInt();
			}
		}
		
		System.out.println(dfs(0, 0));
		
	}
	static int dfs(int x, int y) {
		if(x==n-1&&y==m-1) return 1;
		if(ans[x][y]!=-1) {
			return ans[x][y];
		}
		ans[x][y]=0;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(!(nx<0||nx>=n||ny<0||ny>=m)){
				if(map[nx][ny]<map[x][y]) {
					ans[x][y]+=dfs(nx, ny);
				}
			}
		}
		return ans[x][y];
	}
}