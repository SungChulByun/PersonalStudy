package SWAcademy;
import java.util.*;
public class SW_mock_pinball {
	static int map[][], n, cx, cy, dir, touch,
	dx[] = new int[] {0, -1, 0, 1},
	dy[] = new int[] {-1, 0, 1, 0},
	warm[][] = new int[5][4],
	stop=0;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int ans[] = new int[t];
		for(int tc=0;tc<t;tc++) {
			n = sc.nextInt();
			map = new int[n+2][n+2];
			init();
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i+1][j+1]=sc.nextInt();
					if(map[i+1][j+1]>=6&&map[i+1][j+1]<=10) {
						addwarm(map[i+1][j+1], i+1, j+1);
					}
				}
			}
			printmap(warm);
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i+1][j+1]==0) {
						for(int k=0;k<4;k++) {
							if(stop==1) {
								System.out.println("end");
								return;
							}
							ans[tc]=Math.max(func(i+1, j+1, k), ans[tc]);
						}
					}
				}
			}
		}
		for(int i=0;i<t;i++) System.out.println("#"+(i+1)+" "+ans[i]);
	}
	static void printmap(int[][] mp) {
		for(int i=0;i<mp.length;i++) {
			for(int j=0;j<mp[0].length;j++) {
				System.out.print(mp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static int func(int sx, int sy, int dr) {
		touch=0;
		dir=dr;
		cx=sx;
		cy=sy;
		
		move();
		while(!(map[cx][cy]==-1||(cx==sx&&cy==sy))) {
			move();
			System.out.println("start : "+sx+", "+sy+" start dir : "+dr+" loc : "+cx+", "+cy+" dir : "+dir);
			if(sx==1&&sy==6) {
//				stop=1;
//				break;
			}
		}
		return touch;
	}
	static void move() {
		if ((cx==0&&dir==1)||(cx==n+1&&dir==3)||(cy==0&&dir==0)||(cy==n+1&&dir==2)) {//¾ç »çÀÌµå
			rev();
			touch++;
		}
		else {
			int nx = cx+dx[dir];
			int ny = cy+dy[dir];
			System.out.println(cx+", "+cy+", "+dir);
			if(map[nx][ny]==5) {
				rev();
				touch++;
			}
			else {
				if(map[nx][ny]>=1&&map[nx][ny]<=4) {
					ref(map[nx][ny]);
				}
				else if(map[nx][ny]>=6) {//¿úÈ¦
					System.out.println("--warm");
					cx=nx;
					cy=ny;
					warmholl(map[nx][ny]);
				}
				else {//ºí·¢È¦ : -1 & ºó °ø°£ : 0
					cx=nx;
					cy=ny;
				}
			}
		}
	}
	static void warmholl(int w) {
		
		if(warm[w-6][0]==cx&&warm[w-6][1]==cy) {
			System.out.println("----warm1");
			cx = warm[w-6][2];
			cy = warm[w-6][3];
		}
		else {
			System.out.println("----warm2");
			cx = warm[w-6][0];
			cy = warm[w-6][1];
		}
	}
	static void init() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<4;j++) {
				warm[i][j]=-1;
			}
		}
	}
	static void addwarm(int w, int x, int y) {
		if(warm[w-6][0]==-1) {
			warm[w-6][0]=x;
			warm[w-6][1]=y;
		}
		else {
			warm[w-6][2]=x;
			warm[w-6][3]=y;
		}
	}
	static void ref(int wall) {
		if(wall==0) {
			if(dir==2) {
				cx=cx+dx[dir];
				cy=cy+dy[dir];
				dir = 1;
			}
			else if(dir==3) {
				cx=cx+dx[dir];
				cy=cy+dy[dir];
				dir = 0;
			}
			else rev();
		}
		else if(wall==1) {
			if(dir==3) {
				cx=cx+dx[dir];
				cy=cy+dy[dir];
				dir = 2;
			}
			else if(dir==0) {
				cx=cx+dx[dir];
				cy=cy+dy[dir];
				dir= 1;
			}
			else rev();
		}
		else if(wall==2) {
			if(dir==0) {
				cx=cx+dx[dir];
				cy=cy+dy[dir];
				dir= 3;
			}
			else if(dir==1) {
				cx=cx+dx[dir];
				cy=cy+dy[dir];
				dir = 2;
			}
			else rev();
		}
		else {
			if(dir==1) {
				cx=cx+dx[dir];
				cy=cy+dy[dir];
				dir = 0;
			}
			else if(dir==2) {
				cx=cx+dx[dir];
				cy=cy+dy[dir];
				dir = 3;
			}
			else rev();
		}
	}
	static void rev() {
		dir= (dir+2)%4;
	}
}
