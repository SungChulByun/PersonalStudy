package SWAcademy;

import java.util.*;
public class SWD4_InnerGame_7988 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String[] ans = new String[t];
		
		for(int tc=0;tc<t;tc++) {
			int k = sc.nextInt();
			int[][] map = new int[100][100];
			HashMap<String, Integer> str = new HashMap<String, Integer>();
			Queue<int[]> qu = new LinkedList<int[]>();
			int ct=0;
			for(int i=0;i<k;i++) {
				String a = sc.next();
				String b = sc.next();
				if(!str.containsKey(a)) {
					str.put(a, ct);
					ct++;
				}
				if(!str.containsKey(b)) {
					str.put(b, ct);
					ct++;
				}
				map[str.get(a)][str.get(b)]=1;
				map[str.get(b)][str.get(a)]=1;
			}
			int n = str.size();
			boolean avail=true;
			for(int i=0;i<n;i++) {
				qu.clear();
				int visit[] = new int[n];
				visit[i]=1;
				qu.add(new int[] {i, 1});
				while(!qu.isEmpty()) {
					int[] tp = qu.poll();
					int x = tp[0];
					int team = tp[1];
					for(int j=0;j<n;j++) {
						if(map[x][j]==1) {
							if(visit[j]==team) avail=false;
							else if (visit[j]==0) {
								visit[j]=-team;
								qu.add(new int[] {j, -team});
							}
						}
					}
				}
			}
			if(avail) ans[tc]="Yes";
			else ans[tc]="No";
		}
		for(int i=0;i<t;i++) {
			System.out.println("#"+(i+1)+" "+ans[i]);
		}
	}
}