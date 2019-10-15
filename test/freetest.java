package test;
import java.util.*;
public class freetest {
	static Queue<int[]> gqu = new LinkedList<int[]>();
	static Queue<int[]> qu = new LinkedList<int[]>();
	static int visit[], dx[] = new int[] {0, 0, 1, -1},
						dy[] = new int[] {1, -1, 0, 0};
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int ans[] = new int[t];
		for(int tc=0;tc<t;tc++) {
			int n = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			int map[][] = new int[h][w];
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			int[] order = new int[] {2, 2, 6};
			int[][] temp = clone(map);
			for(int i=0;i<order.length;i++) {
				func(temp, order[i]);
				temp = gravity(temp);
				printmap(temp);
			}
			System.out.println("remain : "+remain(temp));
		}
		for(int i=0;i<t;i++) {
			System.out.println("#"+(i+1)+" "+ans[i]);
		}
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
	static int remain(int[][] map) {
		int ct=0;
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				if(map[i][j]>0) ct++;
			}
		}
		return ct;
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
	static void func(int[][] mp, int loc){
		for(int i=0;i<mp.length;i++) {
			if(mp[i][loc]>0) {
				block(mp, new int[] {i, loc});
				return;
			}
		}
	}
	static void block(int[][] mp, int[] loc) {
		qu.clear();
		int hh = mp.length;
		int ww = mp[0].length;
		qu.add(new int[] {loc[0], loc[1]});
		while(!qu.isEmpty()) {
			int[] tp = qu.poll();
			int x = tp[0];
			int y = tp[1];
			int power = mp[x][y]-1;
			mp[x][y]=0;
			for(int i=1;i<=power;i++) {
				for(int j=0;j<4;j++) {
					int nx = x+dx[j]*i;
					int ny = y+dy[j]*i;
					if(nx>=0&&nx<hh&&ny>=0&&ny<ww) {
						if(mp[nx][ny]>0) qu.add(new int[] {nx, ny});
					}
				}
			}
		}
		
	}
	static int[][] clone(int[][] x){
		int[][] re = new int[x.length][x[0].length];
		for(int i=0;i<x.length;i++) {
			for(int j=0;j<x[0].length;j++) {
				re[i][j]=x[i][j];
			}
		}
		return re;
	}
	
	static void permutation(int x, int y) {
		make(new int[y], 0, 0, x);
	}
	static void make(int[] x, int loc, int cnt, int num) {
		if(loc==x.length) {
			gqu.add(x.clone());
		}
		else {
			for(int i=cnt;i<num;i++) {
				if(visit[i]==0) {
					visit[i]=1;
					x[loc]=i;
					make(x, loc+1, 0, num);
					visit[i]=0;
				}
			}
		}
	}
}