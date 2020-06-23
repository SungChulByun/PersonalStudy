package winter_intern_2019;

import java.util.*;

public class problem5 {

	public void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		long answer = solution(stones, k);
		System.out.println(answer);
	}
	
	Queue<Data> qu = new LinkedList<>();
	int max;
	long count = 0;
	

	public long solution(int[] stones, int k) {
        max = k;
		qu.add(new Data(stones, -1, 0));
		while(!qu.isEmpty()) {
			Data nData = qu.poll();
			jump(nData);
		}
		
        return count;
    }
	
	public void jump(Data cur) {
		for(int i=1;i<=max;i++) {
			if(cur.stones[cur.position + i] == 0) {
				count = Math.max(count, cur.pass);
				continue;
			}
			else {
				qu.add(nextData(cur, i));
			}
		}
	}
	
	public Data nextData(Data current, int jump) {
		if(current.position + jump >= current.len) {
			Data next = new Data(current.stones, 0, current.pass + 1);
			return next;
		}
		else {
			Data next = new Data(current.stones, current.position, current.pass);
			next.stones[next.position+jump]--;
			next.position+=jump;
			return next;
		}
	}
}

class Data{
	int[] stones;
	int len;
	int position;
	int pass;
	boolean avail;
	
	public Data(int[] s, int position, int pass) {
		this.stones = s;
		this.position = position;
		this.pass = pass;
		this.len = s.length;
		this.avail = true;
	}
	
	
}