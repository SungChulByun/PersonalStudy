package Samsung_Previous;
import java.util.*;
public class S03_fishing_17143 {
	static int n, m, snum,
	dx[] = new int[] {-1, 1, 0, 0},
	dy[] = new int[] {0, 0, 1, -1};
	static shark[][] map, after; 
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		snum = sc.nextInt();
		map = new shark[n][m];
		int ans=0;
		// dir : 1 : 위 , 2 : 아래, 3 : 오른쪽, 4 : 왼쪽
		for(int i=0;i<snum;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int vel = sc.nextInt();
			int dir = sc.nextInt();
			int size = sc.nextInt();
			shark tp = new shark(x-1, y-1, vel, dir-1, size);
			map[x-1][y-1]=tp;
		}
//		System.out.println("start");
//		printsize();
		for(int t=0;t<m;t++) {
//			System.out.println("----"+(t+1)+"번째----");
//			System.out.println("before");
//			printsize();
			for(int i=0;i<n;i++) {
				if(map[i][t]!=null) {
					ans+=map[i][t].size;
					map[i][t]=null;
					break;
				}
			}
			
			after = new shark[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					move(i, j);
				}
			}
			map = after;
			
//			System.out.println("after");
//			printsize();
		}
		System.out.println(ans);
	}
	static void printsize() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]!=null)	System.out.print(map[i][j].size+" ");
				else System.out.print(0+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static void move(int x, int y) {
		if(map[x][y]!=null) {
			
			shark tp = map[x][y];

//			System.out.print("x, y : "+x+", "+y+", type : ");
//			System.out.println("dir : "+tp.dir);
			if(dx[tp.dir]!=0) {
//				System.out.print("vertical");
				tp.x+=dx[tp.dir]*tp.vel;
				tp.x%=2*(n-1);
				if(tp.x<0) tp.x+=2*(n-1);
				if(tp.x>=n-1) {
					
					int remain = tp.x-n+1;
					tp.x=n-1-remain;
					tp.dir=Math.abs(tp.dir-1);
				}
			}
			else if(dy[tp.dir]!=0) {
//				System.out.print("horizontal");
				tp.y+=dy[tp.dir]*tp.vel;
				tp.y%=2*(m-1);
				if(tp.y<0) tp.y+=2*(m-1);
				if(tp.y>=m-1) {
					
					int remain = tp.y-m+1;
					tp.y = m-1-remain;
					if(tp.dir==2) tp.dir=3;
					else tp.dir=2;
				}
			}
			
//			System.out.println();
			add(tp.x, tp.y, tp);
		}
	}
	static void add(int x, int y, shark sh) {
		if(after[x][y]==null) {
			after[x][y]=sh;
		}
		else {
			shark ori = after[x][y];
			if(ori.size<sh.size) after[x][y]=sh;
		}
	}
}

class shark{
	public int x;
	public int y;
	public int vel;
	public int dir;
	public int size;
	
	public shark(int x, int y, int v, int dir, int size) {
		this.x=x;
		this.y=y;
		this.vel=v;
		this.dir=dir;
		this.size=size;
	}
}