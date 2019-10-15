package kakao;
import java.util.*;
public class ramyunfactory {
	public static void main(String argsp[]) {
		int st = 4, dates[] = new int[] {4, 10, 15}, supplies[] = new int[] {20, 5, 10}, k=30;
		int result = solution(st, dates, supplies, k);
		System.out.println(result);
	}
	static PriorityQueue<Integer> qu = new PriorityQueue<Integer>();
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer =0;
		int d=0, remain=stock;
		for(int i=0;i<k;i++) {
			if(d<dates.length) {
				if(i==dates[d]) {
					qu.add(supplies[d]);
					d++;
				}
			}

			if(remain<0) {
				int sup = qu.poll();
				remain+=sup;
				answer++;
			}
			remain--;
		}
		return answer;
	}
}
