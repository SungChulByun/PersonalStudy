package DynamicProgramming;

import java.util.*;
public class DP_15_GreedyPanda_1937 {
	static int n, map[][], day[][];
	static int dx[] = new int[] {0, 0, -1, 1};
	static int dy[] = new int[] {1, -1, 0, 0};
	static Queue<int[]> qu = new LinkedList<int[]>();
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		day = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(around(i, j)==4) qu.add(new int[] {i, j});
			}
		}
		while(!qu.isEmpty()) {
			int tp[] = qu.poll();
			dfs(tp[0], tp[1]);
		}
		int mx = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				mx = Math.max(mx, day[i][j]);
			}
		}
		System.out.println(mx+1);
	}
	static int around(int x, int y) {
		int ct=0;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||nx>=n||ny<0||ny>=n) {
				ct++;
				continue;
			}
			if(map[x][y]>=map[nx][ny]) ct++;
		}
		return ct;
	}
	static void dfs(int x, int y) {
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0&&nx<n&&ny>=0&&ny<n) {
				if(map[nx][ny]<map[x][y]) {
					if(day[nx][ny]<day[x][y]+1) {
						day[nx][ny]=day[x][y]+1;
						dfs(nx, ny);
					}
				}
			}
		}
	}
}
