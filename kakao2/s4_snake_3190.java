package kakao2;
import java.util.*;
public class s4_snake_3190 {
	static int dx[] = new int[] {0, 1, 0, -1}, dy[] = new int[] {1, 0, -1, 0}, map[][];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[n][n];
		int k = sc.nextInt();
		for(int i=0;i<k;i++) {
			map[sc.nextInt()-1][sc.nextInt()-1]=-1;
		}
		int t = sc.nextInt();
		Map<Integer, String> turn = new HashMap<Integer, String>();
		for(int i=0;i<t;i++) {
			turn.put(sc.nextInt(), sc.next());
		}
		Queue<int[]> qu = new LinkedList<>();
		int time=0;
		int len=1;
		qu.add(new int[] {0, 0, 0, 0}); // x, y, time, dir
		while(!qu.isEmpty()) {
			int[] tp = qu.poll();
			int cx = tp[0];
			int cy = tp[1];
			int ctime = tp[2];
			int cdir = tp[3];
			if(map[cx][cy]==-1) {
				len++;
			}
			else if(map[cx][cy]>0) {
				if(ctime-map[cx][cy]<=len) {
					qu.clear();
					time=ctime;
					break;
				}
			}
			map[cx][cy]=ctime;
			if(turn.containsKey(ctime)) {
				if(turn.get(ctime).equals("L")) {
					cdir=(cdir+3)%4;
				}
				else {
					cdir=(cdir+1)%4;
				}
			}
			int nx = cx+dx[cdir];
			int ny = cy+dy[cdir];
			if(nx<0||nx>=n||ny<0||ny>=n) {
				qu.clear();
				time = ctime+1;
				break;
			}
			
			qu.add(new int[] {nx, ny, ctime+1, cdir});
		}
		System.out.println(time);
		sc.close();
//		printmap(map);
	}
	static void printmap(int[][] m) {
		System.out.println();
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m.length;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
