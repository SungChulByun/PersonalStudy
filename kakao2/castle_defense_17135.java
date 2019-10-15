package kakao2;

import java.util.*;
public class castle_defense_17135 {
	static int map[][], ct, m, n, d, loc[];
	static boolean shoot[];
	static Queue<int[]> qu = new LinkedList<int[]>();
	static Queue<int[]> sh = new LinkedList<int[]>();
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();
		map = new int[n][m];
		int answer=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		make(new int[3], 0, 0);
		while(!qu.isEmpty()) {
			ct=0;
			reset();
			loc = qu.poll();
//			System.out.println("start");
//			System.out.println(loc[0]+", "+loc[1]+", "+loc[2]);
//			printmap();
			
			for(int t=0;t<n;t++) {
				shoot = new boolean[3];
				for(int r=1;r<=d;r++) {
					for(int i=0;i<3;i++) {
						if(!shoot[i]) f(i, t, r);
					}
				}
				while(!sh.isEmpty()) {
					int[] tp = sh.poll();
					if(map[tp[0]][tp[1]]==1) {
						ct++;
						map[tp[0]][tp[1]]=2;
					}
				}
				for(int i=0;i<m;i++) {
					if(map[n-t-1][i]==1) map[n-t-1][i]=3;
				}
				
			}
//			System.out.println("end");
//			printmap();
//			System.out.println("ct : "+ct+", loc : "+loc[0]+", "+loc[1]+", "+loc[2]);
//			System.out.println();
			answer=Math.max(ct, answer);
		}
		System.out.println(answer);
		
	}
	static void printmap() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static void f(int i, int t, int r) {
		for(int j=0;j<=r-1;j++) {
			if(check(n-1-t-j, loc[i]-(r-1)+j)) {
//				System.out.println("--count : "+ct+", time : "+t+", range : "+r+", loc : "+(n-1-t-j)+", "+(loc[i]-(r-1)+j)+", archer : "+loc[i]);
				sh.add(new int[] {n-1-t-j,loc[i]-(r-1)+j});
				shoot[i]=true;
				return;
			}
		}
		for(int j=1;j<=r-1;j++) {
			if(check(n-1-t-(r-1)+j, loc[i]+j)) {
//				System.out.println("-count : "+ct+", time : "+t+", range : "+r+", loc : "+(n-1-t-(r-1)+j)+", "+(loc[i]+j)+", archer : "+loc[i]);
				sh.add(new int[] {n-1-t-(r-1)+j,loc[i]+j});
				shoot[i]=true;
				return;
			}
		}
	}
	
	static void reset() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]>=2) map[i][j]=1;
			}
		}
	}
	static boolean check(int x, int y) {
		if(x<0||x>=n||y<0||y>=m) return false;
		else {
			if(map[x][y]==1) return true;
			else return false;
		}
	}
	static void make(int[] x, int loc, int cnt) {
		if(loc==3) {
			qu.add(x.clone());
		}
		else {
			for(int i=cnt;i<=m+loc-3;i++) {
				x[loc]=i;
				make(x, loc+1, i+1);
			}
		}
	}
}
