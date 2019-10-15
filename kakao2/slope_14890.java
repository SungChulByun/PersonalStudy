package kakao2;

import java.util.*;
public class slope_14890 {
	static int n, L;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		L = sc.nextInt();
		int answer=0;
		int map[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			boolean x = avail(map[i]);
//			for(int j=0;j<n;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println(" "+x);
//			System.out.println();
			if(x) answer++;
		}
		for(int i=0;i<n;i++) {
			int[] tp = new int[n];
			for(int j=0;j<n;j++) {
				tp[j]=map[j][i];
			}
			boolean x = avail(tp);
//			for(int j=0;j<n;j++) {
//				System.out.print(tp[j]+" ");
//			}
//			System.out.println(" "+x);
//			System.out.println();
			if(x) answer++;
		}
		System.out.println(answer);
	}
	public static boolean avail(int[] d) {
		int len=1;
		for(int i=1;i<n;i++) {
//			System.out.println("i : "+i+", len : "+len+", L : "+L);
			if(d[i]==d[i-1]) len++;
			else if(d[i]-d[i-1]==1) {
				if(len>=L) len=1;
				else return false;
			}
			else if(d[i]-d[i-1]==-1) {
				if(i+L-1>=n) return false;
				else{
					for(int j=1;j<L;j++) {
						if(d[i]!=d[i+j]) return false;
					}
					i+=L-1;
					len=0;
				}
			}
			else {
				return false;
			}
		}
		return true;
	}
}
