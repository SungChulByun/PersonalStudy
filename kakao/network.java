package kakao;

public class network {
	public static void main(String args[]) {
		System.out.println("ZZZZ".compareTo("ZZZZZ"));
	}
	static int visit[], ct, m, map[][];
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		m=n;
		map = computers.clone();
		visit = new int[n];
		for(int i=0;i<n;i++) {
			if(visit[i]==0) {
				dfs(i);
				answer++;
			}
		}
		return answer;
	}
	static void dfs(int x) {
		visit[x]=1;
		for(int i=0;i<m;i++) {
			if(map[x][i]==1&&visit[i]==0) {
				dfs(i);
			}
		}
	}
}
