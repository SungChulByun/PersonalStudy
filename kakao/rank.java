package kakao;
import java.util.*;
public class rank {
	public static void main(String args[]) {
		int[][] test = new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		System.out.println(solution(5, test));
	}
	public static int solution(int n, int[][] results) {
		int answer =0;
		int[] lower = new int[n+1];
		int[] upper = new int[n+1];
		HashMap<Integer, HashSet<Integer>> losemap= new HashMap<>();
		HashMap<Integer, HashSet<Integer>> winmap= new HashMap<>();
		Queue<Integer> qu = new LinkedList<>();
		for(int i=0;i<results.length;i++) {
			int win = results[i][0];
			int lose = results[i][1];
			if(losemap.containsKey(win)) {
				losemap.get(win).add(lose);
			}
			else {
				HashSet<Integer> tp = new HashSet<>();
				tp.add(lose);
				losemap.put(win, tp);
			}
			if(winmap.containsKey(lose)) {
				winmap.get(lose).add(win);
			}
			else {
				HashSet<Integer> tp = new HashSet<>();
				tp.add(win);
				winmap.put(lose, tp);
			}
		}
		for(int i=1;i<=n;i++) {
			int[] visit = new int[n+1];
			int ct=-1;
			qu.add(i);
			while(!qu.isEmpty()) {
				int cur=qu.poll();
				if(visit[cur]==0) {
					if(losemap.get(cur)!=null) {
						for(int elem:losemap.get(cur)) {
							if(visit[elem]==0) {
								qu.add(elem);
							}
						}
					}
					ct++;
				}
				visit[cur]=1;
			}
			lower[i]=ct;
		}
		qu.clear();
		for(int i=1;i<=n;i++) {
			int[] visit = new int[n+1];
			int ct=-1;
			qu.add(i);
			while(!qu.isEmpty()) {
				int cur=qu.poll();
				if(visit[cur]==0) {
					if(winmap.get(cur)!=null) {
						for(int elem:winmap.get(cur)) {
							if(visit[elem]==0) {
								qu.add(elem);
							}
						}
					}
					ct++;
				}
				visit[cur]=1;
			}
			upper[i]=ct;
		}
		for(int i=1;i<=n;i++) {
//			System.out.println("i : "+i+", upper : "+upper[i]+", lower : "+lower[i]);
			if(lower[i]+upper[i]==n-1) {
				answer++;
			}
		}
		
		return answer;
	}
}
