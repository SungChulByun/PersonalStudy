package kakao;
import java.util.*;
public class dickcontroler {
	public static void main(String args[]) {
		int[][] test = new int[][] {{1, 3}, {1, 9}, {2, 6}, {4, 3}};
		int result = solution(test);
		System.out.println(result);
	}
	public static int solution(int[][] jobs) {
		PriorityQueue<Integer> qu = new PriorityQueue<Integer>();
		ArrayList<int[]> list = new ArrayList<int[]>();
		int n = jobs.length;
		int etime=0;
		int answer=0;
		for(int i=0;i<n;i++) {
			etime=Math.max(jobs[i][1], etime);
			list.add(jobs[i]);
		}
		Collections.sort(list, new myintsort());
		int workremain=0;
		int i=0;
		while(list.size()>0||qu.size()>0||workremain>0){
			if(list.size()>0) {
				while(list.get(0)[0]==i) {
					int term =list.get(0)[1];
//					System.out.println("start : "+list.get(0)[0]+", end : "+list.get(0)[1]+", term : "+term);
					qu.add(term);
					list.remove(0);
//					System.out.println("-i : "+i+", list size : "+list.size());
					if(list.size()==0) break;
				}
			}
			if(workremain==0&&!qu.isEmpty()) {
				workremain+=qu.poll();

			}
			if(workremain>0) {
				answer+=qu.size()+1;
			}
//			System.out.println("**i : "+i+", remain : "+workremain+", wait : "+qu.size()+", answer"+answer);
			if(workremain>0) workremain--;
			i++;
		}
		return answer/jobs.length;
	}
}

class myintsort implements Comparator<int[]>{
	@Override
	public int compare(int[] x, int[] y) {
		if(x[0]==y[0]) {
			return x[1]-y[1];
		}
		else{
			return x[0]-y[0];
		}
	}
}