package kakao2;

import java.util.*;
public class s6_dragoncurve_15685 {
	static int dx[] = new int[] {1, 0, -1, 0};
	static int dy[] = new int[] {0, -1, 0, 1};
	static HashSet<String> map = new HashSet<String>();
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int answer=0;
		int n = sc.nextInt();
		int[][] data = new int[n][4];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<4;j++) {
				data[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
//			System.out.println("i : "+i);
			insert(data[i]);
		}
		
		for(int i=0;i<=100;i++) {
			for(int j=0;j<=100;j++) {
				if(map.contains(toPosition(i, j))) {
					if(map.contains(toPosition(i+1, j))&&map.contains(toPosition(i, j+1))&&map.contains(toPosition(i+1, j+1))) {
						answer++;
					}
				}
			}
		}
		System.out.println(answer);
	}
	static String toPosition(int x, int y) {
		String tp = "";
		return tp+x+","+y;
	}
	static int[] nextDir(int[] dir) {
		int[] re = new int[2*dir.length];
		for(int i=0;i<dir.length;i++) {
			re[i]=dir[i];
		}
		for(int i=0;i<dir.length;i++) {
			re[dir.length+i]=func(dir[dir.length-1-i]);
		}
		return re;
	}
	static int[] genDir(int gen, int stdir) {
		int ct=0;
		int[] re = new int[1];
		re[0]=stdir;
		while(ct<gen) {
			re=nextDir(re);
			ct++;
		}
		return re;
	}
	static void insert(int[] dt) {
		int x = dt[0];
		int y = dt[1];
		map.add(toPosition(x, y));
//		System.out.println(toPosition(x, y));
		int d = dt[2];
		int gen = dt[3];
		int dir[] = genDir(gen, d);
		for(int i=0;i<dir.length;i++) {
			x = x+dx[dir[i]];
			y = y+dy[dir[i]];
			map.add(toPosition(x, y));
//			System.out.println(toPosition(x, y));
		}
	}
	
	static int func(int dir) {
		return (dir+1)%4;
	}
}
