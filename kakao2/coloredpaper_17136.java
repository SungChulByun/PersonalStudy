package kakao2;
import java.util.*;
public class coloredpaper_17136 {
	static int map[][], ct, answer, cnt[];
	static boolean fin;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		map = new int[10][10];
		fin=false;
		ct=0;
		answer=101;
		cnt = new int[6];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==1) ct++;
			}
		}
        
		dfs(0, 0, 5);
		if(answer==101) {
			answer=-1;
		}
		System.out.println(answer);
	}
	static void dfs(int i, int j, int k) {
		int tp=0;
		for(int x=1;x<k;x++) {
			tp+=5*x*x;
		}
		tp+=(5-cnt[k])*k*k;
		if(ct>tp) return;
		if(k==0) {
//			System.out.println("here ct : "+ct);
			if(ct==0) {
				int sum=0;
				for(int t=1;t<=5;t++) {
					sum+=cnt[t];
				}
				answer=Math.min(sum, answer);
			}
			return;
		}
		else {
			if(avail(i, j, k)) {
				cover(i, j, k);
//				System.out.println("cover i, j : "+i+", "+j+", k : "+k);
				cnt[k]++;
				ct-=k*k;
				if(cnt[k]==5) dfs(0, 0, k-1);
				else if(j==9&&i==9) dfs(0, 0, k-1);
				else if(j==9&&i<9) dfs(i+1, 0, k);
				else dfs(i, j+1, k);
				if(fin) return;
				uncover(i, j, k);
//				System.out.println("uncover i, j : "+i+", "+j+", k : "+k);
				cnt[k]--;
				ct+=k*k;
			}
			if(j==9&&i==9) dfs(0, 0, k-1);
			else if(j==9&&i<9) dfs(i+1, 0, k);
			else dfs(i, j+1, k);
			if(fin) return;
		}
	}
	static boolean avail(int x, int y, int d) {
		if(x+d>=11||y+d>=11) return false;
		for(int i=0;i<d;i++) {
			for(int j=0;j<d;j++) {
				if(map[x+i][y+j]==0) return false;
			}
		}
		return true;
	}
	
	static void cover(int x, int y, int d) {
		for(int i=0;i<d;i++) {
			for(int j=0;j<d;j++) {
				map[x+i][y+j]=0;
			}
		}
	}
	static void uncover(int x, int y, int d) {
		for(int i=0;i<d;i++) {
			for(int j=0;j<d;j++) {
				map[x+i][y+j]=1;
			}
		}
	}
}
