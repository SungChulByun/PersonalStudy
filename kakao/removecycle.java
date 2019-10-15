package kakao;
import java.util.*;
public class removecycle {
	public static void main(String args[]) {
		int[] test = new int[] {0, 2, 4, 6, 1, 6, 3};
		System.out.println(solution(test));
	}
	static int[] dx = new int[] {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dy = new int[] {1, 1, 0, -1, -1, -1, 0, 1};
	public static int solution(int[] arrows) {
		HashSet<String> map = new HashSet<>();
		int answer = 0;
		int[] cur = new int[2];
		map.add("0,0");
		for(int i=0;i<arrows.length;i++) {
			int[] nextloc = next(cur, arrows[i]);
			String nextvec = toStr(new int[] {cur[0], cur[1], arrows[i]});
			if(arrows[i]%2==1) {
				String mid = midofvec(cur, arrows[i]);
				if(map.contains(mid)&&!map.contains(nextvec)) {
					answer++;
				}
				map.add(mid);
			}
			if(map.contains(toStr(nextloc))) {
				if(!map.contains(nextvec)) {
					answer++;
//					System.out.println(loctostr(nextloc[0], nextloc[1]));
				}
			}
			map.add(toStr(cur));
			map.add(nextvec);
			map.add(toStr(reverse(cur, arrows[i])));
			cur=nextloc;
		}
		return answer;
	}
	static String toStr(int[] x) {
		String re = "";
		for(int i=0;i<x.length-1;i++) re+=((Integer) x[i]).toString()+",";
		re+=x[x.length-1];
		return re;
	}
	static String midofvec(int[] cur, int v) {
		int[] nxt = next(cur, v);
		double x = ((double) cur[0]+nxt[0])/2;
		double y = ((double) cur[1]+nxt[1])/2;
		String re = ((Double) x).toString()+","+((Double) y).toString();
		return re;
	}
	static int[] next(int[] cur, int v) {
		int x = cur[0];
		int y = cur[1];
		return new int[] {x+dx[v], y+dy[v]};
	}
	static int[] reverse(int[] cur, int v) {
		int[] nt = next(cur, v);
		return new int[] {nt[0], nt[1], (v+4)%8};
	}
}
