package kakao;
import java.util.*;
public class farthestnode {
	public static void main(String args[]) {
		int[][] test = new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(6, test));
	}
	public static int solution(int n, int[][] node) {
		int answer=0;
		int[] far = new int[n+1];
		int[] visit = new int[n+1];
		Queue<int[]> qu = new LinkedList<>();
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		for(int i=0;i<node.length;i++) {
			if(map.containsKey(node[i][0])) {
				map.get(node[i][0]).add(node[i][1]);
			}
			else {
				HashSet<Integer> tp = new HashSet<>();
				tp.add(node[i][1]);
				map.put(node[i][0], tp);
			}
			if(map.containsKey(node[i][1])) {
				map.get(node[i][1]).add(node[i][0]);
			}
			else {
				HashSet<Integer> tp = new HashSet<>();
				tp.add(node[i][0]);
				map.put(node[i][1], tp);
			}
		}
		qu.add(new int[] {1, 0});
		while(!qu.isEmpty()) {
			int[] tp = qu.poll();
			int cur = tp[0];
			int time = tp[1];
			if(visit[cur]==0) {
				far[cur]=time;
//				System.out.println("cur : "+cur+", far :"+time);
				for(Integer asdf:map.get(cur)) {
					qu.add(new int[] {asdf, time+1});
				}
			}
			visit[cur]=1;
		}
		int max=0;
		for(int i=1;i<=n;i++) {
			max = Math.max(max, far[i]);
		}
		for(int i=1;i<=n;i++) {
			if(far[i]==max) answer++;
		}
		return answer;
	}
}
