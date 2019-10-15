package codeup;

import java.util.*;

public class faithfulant_1099 {
	static int map[][] = new int[10][10], dx[] = new int[] {0, 1}, dy[] = new int[] {1, 0};
	static boolean find=false;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		if(map[1][1]==2) {
			change(1,1);
		}
		else {
			dfs(1,1);
		}
		printmap(map);
	}
	static void dfs(int x, int y) {
		for(int i=0;i<2;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(map[nx][ny]==0) {
				dfs(nx, ny);
				if(find) {
					change(x, y);
					i++;
				}
			}
			if(map[nx][ny]==2||(nx==8&&ny==8)) {
				map[nx][ny]=9;
				map[x][y]=9;
				find=true;
				i++;
			}
		}
	}
	static void printmap(int[][] x) {
		for(int i=0;i<x.length;i++) {
			for(int j=0;j<x.length;j++) {
				System.out.print(x[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void change(int x, int y) {
		map[x][y]=9;
	}
}
