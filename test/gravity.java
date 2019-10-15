package test;
import java.util.*;
public class gravity {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int[][] ans = gravity(map);
		printmap(ans);
	}
	static void printmap(int[][] map) {
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static int[][] gravity(int[][] map){
		int n = map.length;
		int m = map[0].length;
		int[][] re = new int[n][m];
		for(int i=0;i<m;i++) {
			Queue<Integer> qu = new LinkedList<Integer>();
			for(int j=0;j<n;j++) {
				if(map[n-1-j][i]>0) {
					qu.add(map[n-1-j][i]);
				}
			}
			int ct=0;
			while(!qu.isEmpty()) {
				re[n-1-ct][i]=qu.poll();
				ct++;
			}
		}
		return re;
	}
}
