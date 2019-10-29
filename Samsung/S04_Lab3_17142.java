package Samsung;
import java.util.*;
public class S04_Lab3_17142 {
	static int map[][], tempmap[][], n, vi,
	dx[] = new int[] {0, 0, 1, -1},
	dy[] = new int[] {1, -1, 0, 0};
	static ArrayList<int[]> vloc = new ArrayList<int[]>();
	static Queue<int[]> qu = new LinkedList<int[]>();
	static Queue<int[]> gqu = new LinkedList<int[]>();
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		vi = sc.nextInt();
		map = new int[n][n];
		int ct=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==2) {
					vloc.add(new int[] {i, j});
					map[i][j]=n*n;
				}
				else if(map[i][j]==1) map[i][j]=-1;
				else ct++;
			}
		}
		vi = Math.min(vi, vloc.size());
		generate(vloc.size(), vi);
		boolean avail=false;
		int ans=n*n;
		
//		func(new int[] {0, 2});
//		printmap(tempmap);
		while(!gqu.isEmpty()) {
			int[] tp = gqu.poll();
//			for(int i=0;i<tp.length;i++) {
//				System.out.println("virus : "+tp[i]+", x, y : "+vloc.get(tp[i])[0]+", "+vloc.get(tp[i])[1]);
//			}
//			System.out.println("----map----");
//			printmap(map);
			int a = func(tp);
			if(a>=0)	{
				avail=true;
				ans = Math.min(ans, a);
			}
			System.out.println("val : "+a);
			printmap(tempmap);
		}
		if(ct==0) System.out.println(0);
		else if(avail) System.out.println(ans-1);
		else System.out.println(-1);
	}
	static void bfs(int v[]) {
		qu.clear();
		int len = v.length;
		for(int i=0;i<len;i++) {
			int x = vloc.get(v[i])[0];
			int y = vloc.get(v[i])[1];
			qu.add(new int[] {x, y, 1});
		}
		while(!qu.isEmpty()) {
			int[] tp = qu.poll();
			int x = tp[0];
			int y = tp[1];
			int t = tp[2];
//			System.out.println("x, y, t : "+x+", "+y+", "+t);
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0&&nx<n&&ny>=0&&ny<n) {
					if(tempmap[nx][ny]==0||tempmap[nx][ny]>t+1) {
						tempmap[nx][ny]=t+1;
						qu.add(new int[] {nx, ny, t+1});
					}
				}
			}
		}
	}
	static int func(int[] v) {
		tempmap = clone(map);
		bfs(v);
		int re = getMax();
		return re;
	}
	static int getMax() {
		int mx=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(tempmap[i][j]==0) return -1;
				mx = Math.max(tempmap[i][j], mx);
			}
		}
		return mx;
	}
	static int[][] clone(int[][] mp){
		int[][] re = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				re[i][j] = mp[i][j];
			}
		}
		return re;
	}
	static void generate(int x, int y) {
		make(new int[y], 0, 0, x);
	}
	static void make(int[] x, int loc, int cnt, int num) {
		if(loc==x.length) {
			gqu.add(x.clone());
		}
		else {
			for(int i=cnt;i<num+loc+1-x.length;i++) {
				
				x[loc]=i;
				make(x, loc+1, i+1, num);
			}
		}
	}
	static void printmap(int[][] mp) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				String tp = "";
				if(mp[i][j]>=0) tp=" ";
				System.out.print(tp+mp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
