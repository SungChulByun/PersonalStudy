package Samsung;
import java.util.*;
public class S06_newgame_17780 {
	static HashMap<Integer, int[]> loc = new HashMap<Integer, int[]>();
	static node map[][];
	static boolean fin;
	static int dx[] = new int[] {0, 0, -1, 1},
			   dy[] = new int[] {1, -1, 0, 0},
			   n, k;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int ct=0;
		fin = false;
		n = sc.nextInt();
		k = sc.nextInt();
		map = new node[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=new node(sc.nextInt());
			}
		}
		for(int i=0;i<k;i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int dir = sc.nextInt()-1;
			map[x][y].addone(i, dir);
			if(map[x][y].size==k) fin=true;
			loc.put(i, new int[] {x, y});
		}
		while(!fin&&ct<=1000) {
			for(int i=0;i<k;i++) {
				movenum(i);
			}
			ct++;
		}
		if(fin) {
			System.out.println(ct);
		}
		else System.out.println(-1);
	}
	static int rev(int dir) {
		if(dir==0) return 1;
		else if(dir==1) return 0;
		else if(dir==2) return 3;
		else return 2;
	}
	static void movenum(int num) {
		int x = loc.get(num)[0];
		int y = loc.get(num)[1];
		node nd = map[x][y];
		if(nd.data.get(0)[0]==num) {
			int dir = nd.data.get(0)[1];
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			if(isWall(nx, ny)) {
				dir = rev(dir);
				nd.data.get(0)[1]=dir;
				int nnx = x+dx[dir];
				int nny = y+dy[dir];
				if(!isWall(nnx, nny)) {
					updateloc(map[x][y], nnx, nny);
					if(map[nnx][nny].color==0) {// Èò»ö
						map[nnx][nny].add(map[x][y]);
					}
					else if(map[nnx][nny].color==1) {
						map[x][y].reverse();
						map[nnx][nny].add(map[x][y]);
					}
					if(map[nnx][nny].size>=4) {
						fin=true;
					}
				}
			}
			else {
				updateloc(map[x][y], nx, ny);
				if(map[nx][ny].color==0) {// Èò»ö
					map[nx][ny].add(map[x][y]);
				}
				else if(map[nx][ny].color==1) {
					map[x][y].reverse();
					map[nx][ny].add(map[x][y]);
				}
				if(map[nx][ny].size>=4) fin=true;
			}
		}
	}
	static void updateloc(node nd, int nx, int ny) {
		for(int i=0;i<nd.size;i++) {
			loc.put(nd.data.get(i)[0], new int[] {nx, ny});
		}
	}
	static boolean isWall(int nx, int ny) {
		if(nx<0||nx>=n||ny<0||ny>=n) {
			return true;
		}
		else if(map[nx][ny].color==2) {
			return true;
		}
		else return false;
	}
}

class node{
	ArrayList<int[]> data = new ArrayList<int[]>(); // {name, dir}
	int color, size;
	public node(int col) {
		this.color=col;
		this.size=0;
	}
	public void addone(int name, int dir) {
		data.add(new int[] {name, dir});
		size++;
	}
	public void reverse() {
		ArrayList<int[]> temp = new ArrayList<int[]>();
		for(int i=0;i<data.size();i++) {
			temp.add(data.get(data.size()-1-i));
		}
		data=temp;
	}
	public void add(node nd) {
		this.data.addAll(nd.data);
		this.size+=nd.size;
		nd.size=0;
		nd.data.clear();
	}
}