package kakao;
import java.util.*;
public class doublepriorityqueue {
	public static void main(String args[]) {
		String[] test = new String[] {"I 7","I 5","I -5","D -1"};
		System.out.println(solution(test)[0]+", "+solution(test)[1]);
	}
	public static int[] solution(String[] operations) {
		int[] answer = new int[2];
		int n = operations.length;
		PriorityQueue<Integer> maxqu = new PriorityQueue<>();
		PriorityQueue<Integer> minqu = new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			char how = operations[i].charAt(0);
			int data = Integer.parseInt(operations[i].split(" ")[1]);
			if(how=='I') {
				maxqu.add(-data);
				minqu.add(data);
			}
			else {
				if(maxqu.size()>0) {
					if(data==1) {
						int tp = -maxqu.poll();
						minqu.remove(tp);
					}
					else {
						int tp = -minqu.poll();
						maxqu.remove(tp);
					}
				}
			}
		}
		if(maxqu.size()>0) {
			answer[0]=-maxqu.poll();
			answer[1]=minqu.poll();
		}
		return answer;
	}
}
