package Samsung;
import java.util.*;
public class S05_garymandering_17779 {
	static int n, map[][];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int d1=0;j-d1>=0&&i+d1<=n-1;d1++) {
					for(int d2=0;i+d2<=n-1&&j+d2<=n-1;d2++) {
						if(i+d1+d2<=n-1) {
							int tp[] = new int[5];
							for(int x=0;x<n;x++) {
								for(int y=0;y<n;y++) {
									int temp = area(x, y, i, j, d1, d2);
									tp[temp]+=map[x][y];
								}
							}
							Arrays.sort(tp);
							ans = Math.min(ans, tp[4]-tp[0]);
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
	static int area(int i, int j, int x, int y, int d1, int d2) {
		if(x+y<=i+j&&i+j<=x+y+2*d2&&x-y<=i-j&&i-j<=x-y+2*d1) return 4;
		else {
			if(i>=0&&i<x+d1&&j>=0&&j<=y) return 0;
			else if(i>=0&&i<=x+d2&&y<j&&j<=n-1) return 1;
			else if(x+d1<=i&&i<=n-1&&0<=j&&j<y-d1+d2) return 2;
			else if(x+d2<i&&i<=n-1&&y-d1+d2<=j&&j<=n-1) return 3;
		}
		return -1;
	}
}
