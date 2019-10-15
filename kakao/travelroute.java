package kakao;
import java.util.*;
public class travelroute {
	public static void main(String args[]) {
		String[][] test = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] test1 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[][] test2 = { { "ICN", "BOO"}, { "ICN", "COO"}, { "COO", "DOO"}, { "DOO", "COO"}, { "BOO", "DOO"},{ "DOO", "BOO"}, { "BOO", "ICN"}, {"COO", "BOO"}};
		String[] result = solution(test2);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
	}
	static int used[], len;
	static travel[] data;
	static ArrayList<int[]> route = new ArrayList<int[]>();
	public static String[] solution(String[][] tickets) {
		len = tickets.length;
		String[] answer = new String[len+1];
		used = new int[len];
		data = new travel[len];
		for(int i=0;i<len;i++) {
			data[i]=new travel(tickets[i][0], tickets[i][1]);
		}
		Arrays.sort(data);
		dfs(0, new int[len], 0);
		Collections.sort(route, new mysort());
		
		int[] target = route.get(0);
		for(int i=0;i<len;i++) {
			answer[i]=data[target[i]].start;
		}
		answer[len]=data[target[len-1]].end;
		return answer;
	}
	public static void dfs(int cur, int[] past, int cnt) {
		if(cnt==past.length) {
			route.add(past.clone());
		}
		else {

			for(int i=0;i<len;i++) {
				if(cnt==0) {
					if(data[i].start.equals("ICN")){
						past[0]=i;
						used[i]=1;
						dfs(i, past, cnt+1);
						used[i]=0;
					}
				}
				else {
					if(used[i]==0&&data[cur].end.equals(data[i].start)) {
						past[cnt]=i;
						used[i]=1;
						dfs(i, past, cnt+1);
						used[i]=0;
					}
				}
			}
		}
	}
}
class mysort implements Comparator<int[]>{
	@Override
	public int compare(int[] x, int[] y) {
		for(int i=0;i<x.length;i++) {
			if(x[i]>y[i]) {
				return 1;
			}
			else if(x[i]<y[i]) {
				return -1;
			}
		}
		return 0;
	}
}
class travel implements Comparable<travel>{
	String start;
	String end;
	int no;
	public travel(String st, String ed) {
		this.start=st;
		this.end=ed;
	}
	@Override
	public int compareTo(travel tl) {
		if(this.start.equals(tl.start)){
			return this.end.compareTo(tl.end);
		}
		else {
			return this.start.compareTo(tl.start);
		}
	}
}