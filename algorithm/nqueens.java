package algorithm;
import java.util.*;
public class nqueens {
	static Stack<nqn> stk = new Stack<nqn>();
	static int n;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[][] map = new int[n][n];
		int ans=0;
		for(int i=0;i<n;i++) {
			int[][] tp = mark(map, 0, i);
			nqn tpq = new nqn(tp, 1);
			stk.push(tpq);
		}
		while(!stk.isEmpty()) {
			nqn tpq = stk.pop();
			
			if(tpq.line==n) {
				ans++;
				
			}
			else if(check(tpq)){
				for(int i=0;i<n;i++) {
					if(tpq.map[tpq.line][i]==0) {
						int[][] tp = mark(tpq.map, tpq.line, i);
						nqn nextq = new nqn(tp, tpq.line+1);
						stk.push(nextq);
					}
				}
			}
		}
		System.out.println(ans);
	}
	static int[][] mark(int[][] map, int x, int y){
		int[][] re = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				re[i][j]=map[i][j]; 
			}
		}
		
		for(int i=0;i<n;i++) {
			if(i!=x) re[i][y]=8;
		}
		for(int j=0;j<n;j++) {
			if(j!=y) re[x][j]=8;
		}
		for(int i=-Math.min(x, y);i<Math.min(n-x, n-y);i++) {
			re[x+i][y+i]=8;
		}
		for(int i=0;i<2*n;i++) {
			if(i>=0&&i<n&&x+y-i>=0&&x+y-i<n) re[i][x+y-i]=8;
		}
		re[x][y]=1;
		return re;
	}
	static void printmap(int[][] map) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static boolean check(nqn qn) {
		int ct=0;
		for(int i=0;i<n;i++) {
			if(qn.map[n-1][i]==0) ct++;
		}
		if(ct==0) return false;
		else return true;
	}
}
class nqn{
	int line;
	int[][] map;
	public nqn(int[][] mp, int l){
		this.map=mp;
		this.line=l;
	}
}