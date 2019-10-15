package kakao;
import java.util.*;

public class eatingshow {
	public static void main(String args[]) {
		int[] test = new int[] {3, 1, 2};
		int result = solution(test, 6);
		System.out.println(result);
	}
	public static int solution(int[] food_times, long k) {
        Queue<food> qu = new LinkedList<food>();
		int answer = 0;
		long ct=0;
		for(int i=0;i<food_times.length;i++) {
			qu.add(new food(i+1, food_times[i]));

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

class food{
	private long no;
	private long remain;
	public food(long n, long re) {
		this.no=n;
		this.remain=re;
	}
	public void setNo(long n) {
		this.no=n;
	}
	public long getNo() {
		return this.no;
	}
	public void setRemain(long n) {
		this.remain=n;
	}
	public long getRemain() {
		return this.remain;
	}
}