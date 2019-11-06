package Samsung_Previous;
import java.util.*;
public class S07_Rotate_Array4_17406 {
	static int n, m, rt, visit[], data[][];
	static Queue<int[]> gqu = new LinkedList<int[]>(); 
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		rt = sc.nextInt();
		int ans = Integer.MAX_VALUE;
		int[][] map = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		data = new int[rt][3];
		for(int i=0;i<rt;i++) {
			data[i][0]=sc.nextInt()-1;
			data[i][1]=sc.nextInt()-1;
			data[i][2]=sc.nextInt();
		}
		visit = new int[rt];
		int[] tp = new int[rt];
		generate(tp, 0);
		while(!gqu.isEmpty()) {
			int[] temp = gqu.poll();
			ans = Math.min(ans, minval(rotAll(map, temp)));
		}
		System.out.println(ans);
	}
	
	static void generate(int[] x, int cur) {
		if(cur==rt) {
			gqu.add(x.clone());
		}
		else {
			for(int i=0;i<rt;i++) {
				if(visit[i]==0) {
					x[cur]=i;
					visit[i]=1;
					generate(x, cur+1);
					visit[i]=0;
				}
			}
		}
	}
	static int[][] rotAll(int[][] mp, int[] order) {
		int[][] re = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				re[i][j]=mp[i][j];
			}
		}
		for(int i=0;i<rt;i++) {
			re = rotate(re, data[order[i]][0], data[order[i]][1], data[order[i]][2]);
		}
		return re;
	}
	static int minval(int[][] mp) {
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			int sum=0;
			for(int j=0;j<m;j++) {
				sum+=mp[i][j];
			}
			min = Math.min(min, sum);
		}
		return min;
	}
	
	static int[][] rotate(int[][] mp, int r, int c, int s){
		int[][] re = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				re[i][j]=mp[i][j];
			}
		}
		for(int k=1;k<=s;k++) {
			for(int j=c-k+1;j<=c+k;j++) re[r-k][j]=mp[r-k][j-1];
			for(int i=r-k+1;i<=r+k;i++) re[i][c+k]=mp[i-1][c+k];
			for(int j=c+k-1;j>=c-k;j--) re[r+k][j]=mp[r+k][j+1];
			for(int i=r+k-1;i>=r-k;i--) re[i][c-k]=mp[i+1][c-k];
		}
		return re;
	}
}
