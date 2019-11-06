package Samsung_Previous;
import java.util.*;
public class S08_rotate_circle_17822 {
	static int map[][], n, m;
	static Queue<int[]> qu = new LinkedList<int[]>();
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		int k = sc.nextInt();
		int[][] data = new int[k][3];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<k;i++) {
			for(int j=0;j<3;j++) {
				data[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<k;i++) {
			rotate(data[i][0], data[i][1], data[i][2]);
//			printmap();
		}
		int ans = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				ans+=map[i][j];
			}
		}
		System.out.println(ans);
	}
	static void rotate(int x, int d, int k) {
		int ct=x;
		while(ct<=n) {
			map[ct-1]=rot(map[ct-1], d, k);
			ct+=x;
		}
		check();
	}
	static void check() {
		qu.clear();
		int sum=0;
		int ct=0;
		for(int i=0;i<n;i++) {
			if(map[i][0]==map[i][m-1]&&map[i][0]>0) {
				qu.add(new int[] {i, 0});
				qu.add(new int[] {i, m-1});
			}
			for(int j=0;j<m;j++) {
				if(map[i][j]>0) {
					sum+=map[i][j];
					ct++;
				}
				if(i>0) {
					if(map[i][j]==map[i-1][j]&&map[i][j]>0) {
						qu.add(new int[] {i, j});
						qu.add(new int[] {i-1, j});
					}
				}
				if(j>0) {
					if(map[i][j]==map[i][j-1]&&map[i][j]>0) {
						qu.add(new int[] {i, j});
						qu.add(new int[] {i, j-1});
					}
				}
			}
		}
		if(qu.isEmpty()) {
			double aver = ((double) sum)/((double) ct);
//			System.out.println("aver : "+aver);
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]>0) {
						if(map[i][j]>aver) map[i][j]--;
						else if(map[i][j]<aver) map[i][j]++;
					}
				}
			}
		}
		else {
			while(!qu.isEmpty()) {
				int[] tp = qu.poll();
				map[tp[0]][tp[1]]=0;
			}
		}
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
	static int[] rot(int[] ori, int dir, int k) {
		int re[] = new int[m];
		for(int i=0;i<m;i++) {
			re[i]=ori[(i+(dir*2-1)*k+3*m)%m];
		}
		return re;
	}
}
