package kakao;
import java.util.*;

public class eatingshow1 {
	public static void main(String args[]) {
		int[] test = new int[] {3, 1, 2};
		int result = solution(test, 5);
		System.out.println(result);
	}
	public static int solution(int[] food_times, long k) {
        Queue<food> qu = new LinkedList<food>();
		int answer = 0;
		long ct=0;
		int min = food_times[0];
		for(int i=1;i<food_times.length;i++) {
			min = Math.min(min, food_times[i]);
		}
		ct+=min*food_times.length;
		
		for(int i=0;i<food_times.length;i++) {
			if(food_times[i]>min) {
				qu.add(new food(i+1, food_times[i]-min));
			}

		}
		while(ct<k) {
			if(qu.isEmpty()) {
				break;
			}
			food x = qu.poll();
			long re = x.getRemain();
			if(re>1) {
				x.setRemain(re-1);
				qu.add(x);
			}
			ct++;
		}
		if(qu.isEmpty()) {
			answer=-1;
		}
		else {
			answer = (int) qu.poll().getNo();
		}
        return answer;
    }
}