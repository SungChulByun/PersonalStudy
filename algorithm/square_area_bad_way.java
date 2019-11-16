package algorithm;

import java.util.*;
public class square_area_bad_way {
	public static void main(String args[]) {
		int[][] rec1 = new int[][] {{0, 1, 4, 4}, {3, 1, 5, 3}};
		int[][] rec2 = new int[][] {{1, 1, 6, 5}, {2, 0, 4, 2}, {2, 4, 5, 7}, {4, 3, 8, 6}, {7, 5, 9, 7}};
		long ans1 = solution(rec1);
		long ans2 = solution(rec2);
		System.out.println("#1 : "+ans1);
		System.out.println("#2 : "+ans2);
	}
	public static long solution(int[][] rec) {
		long ans = 0;
		int mx = 0;
		int my = 0;
		for(int i=0;i<rec.length;i++) {
			mx = Math.max(mx, rec[i][2]);
			my = Math.max(my, rec[i][3]);
		}
		int[][] map = new int[mx][my];
		for(int i=0;i<rec.length;i++) {
			for(int x=rec[i][0];x<rec[i][2];x++) {
				for(int y=rec[i][1];y<rec[i][3];y++) {
					mx = Math.max(mx, rec[i][2]);
					my = Math.max(my, rec[i][3]);
					map[x][y]=1;
				}
			}
		}
		for(int i=0;i<mx;i++) {
			for(int j=0;j<my;j++) {
				if(map[i][j]>0) ans++;
			}
		}
		return ans;
	}
}
