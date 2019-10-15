package test;

import java.util.*;
public class freetest_2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int[][] test2 = clone(map);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				test2[i][j]=2;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		int[][] test1 = map.clone();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				test1[i][j]=3;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static int[][] clone(int[][] x){
		return x.clone();
	}
}