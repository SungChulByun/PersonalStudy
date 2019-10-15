package nhn;

import java.util.*;
public class nhn_problem4 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int oil = sc.nextInt();
		int edge = sc.nextInt();
		int map[][] = new int[n][n];
		for(int i=0;i<edge;i++) {
			int x = tonum(sc.next());
			int y = tonum(sc.next());
			int dis = sc.nextInt();
			map[x][y]=dis;
			map[y][x]=dis;
		}
	}
	static int tonum(String x) {
		return (x.charAt(0)-'A');
	}
}
