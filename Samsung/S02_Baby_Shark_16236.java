package Samsung;

import java.util.*;
public class S02_Baby_Shark_16236 {
	static PriorityQueue<pair> qu = new PriorityQueue<pair>(new pairComparator());
	static Queue<pair> nqu = new LinkedList<pair>();
	static int n, map[][], visit[][], sx, sy, fish, shark_size, stk, time, ct, order[][];
	static int dx[] = new int[] {-1, 0, 0, 1};
	static int dy[] = new int[] {0, -1, 1, 0};
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		boolean fin=false;
		ct=0;
		order = new int[n][n];
		time=0;
		fish=0;
		shark_size=2;
		stk=0;
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==9) {
					sx=i; sy=j;
				}
				else if(map[i][j]>0) fish++;
			}
		}
		while(!fin) {
//			System.out.println("size : "+shark_size+", time : "+time);
//			printmap(map);
			addPair();
			fin=!move();
		}
//		printmap(order);
		System.out.println(time);
	}
	static void addPair() {
		visit = new int[n][n];
		nqu.clear();
		qu.clear();
		nqu.add(new pair(sx, sy, 0));
		visit[sx][sy]=1;
		while(!nqu.isEmpty()) {
			pair tp = nqu.poll();
			int x = tp.x;
			int y = tp.y;
			int d = tp.d;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0&&nx<n&&ny>=0&&ny<n) {
					if(visit[nx][ny]==0) {
						if(map[nx][ny]<=shark_size) {
							visit[nx][ny]=1;
							nqu.add(new pair(nx, ny, d+1));
							qu.add(new pair(nx, ny, d+1));
							
						}
					}
				}
			}
		}
	}
	static boolean move() {
		if(fish==0) return false;
		while(!qu.isEmpty()) {
			pair tp = qu.poll();
			int x = tp.x;
			int y = tp.y;
			int d = tp.d;
			if(map[x][y]>0&&map[x][y]<shark_size) {
				time+=d;
				map[sx][sy]=0;
				order[sx][sy]=ct;
				ct++;
				sx=x; sy=y;
				eat();
				return true;
			}
		}
		return false;
	}
	static void eat() {
		fish--;
		map[sx][sy]=9;
		stk++;
		if(stk==shark_size) {
			stk=0;
			shark_size++;
		}
	}
	static void printmap(int[][] mp) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(mp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
class pairComparator implements Comparator<pair>{
	public int compare(pair p1, pair p2) {
		if(p1.d!=p2.d) {
			return p1.d-p2.d;
		}
		else {
			if(p1.x!=p2.x) {
				return p1.x-p2.x;
			}
			else {
				return p1.y-p2.y;
			}
		}
	}
}
class pair {
	public int x;
	public int y;
	public int d;
	public pair(int x, int y, int d) {
		this.x=x;
		this.y=y;
		this.d=d;
	}
}
