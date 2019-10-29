package SWAcademy;
import java.util.*;
public class SW_mock_desert_2105 {
	static int map[][], n;
	static HashSet<Integer> set = new HashSet<Integer>();
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int ans[] = new int[t];
		for(int tc=0;tc<t;tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) map[i][j]=sc.nextInt();
			}
			ans[tc]=-1;
			for(int i=1;i<n-1;i++) {
				for(int j=1;j<n-1;j++) {
					int temp = maxcount(i, j);
					ans[tc]=Math.max(ans[tc], temp);
				}
			}
		}
		for(int i=0;i<t;i++) System.out.println("#"+(i+1)+" "+ans[i]);
	}
	static int maxcount(int x, int y) {
		int mx=-2;
		for(int i=1;y-i>=0;i++) {
			for(int j=1;y+j<n;j++) {
				if(x+i+j<n) {
					int temp = count(x, y, i, j);
					mx=Math.max(mx, temp);
				}
			}
		}
		return mx;
	}
	static int count(int x, int y, int left, int right) {
		set.clear();
		set.add(map[x][y]);
		for(int i=1;i<=left;i++) {
			if(set.contains(map[x+i][y-i])) return -1;
			set.add(map[x+i][y-i]);
		}
		for(int i=1;i<=right;i++) {
			if(set.contains(map[x+left+i][y-left+i])) return -1;
			set.add(map[x+left+i][y-left+i]);
		}
		
		for(int i=1;i<=right;i++) {
			if(set.contains(map[x+i][y+i])) return -1;
			set.add(map[x+i][y+i]);
		}
		
		for(int i=1;i<left;i++) {
			if(set.contains(map[x+right+i][y+right-i])) return -1;
			set.add(map[x+right+i][y+right-i]);
		}
		

		if(set.size()==2*(left+right)) return set.size();
		else return -1;
	}
}
