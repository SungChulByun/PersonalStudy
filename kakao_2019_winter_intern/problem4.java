package winter_intern_2019;

import java.util.*;

public class problem4 {

	
	public static void main(String args[]) {
		long k = 100;
		long[] room = {1,3,4,1,3,1};
		
		long[] answer = solution(k, room);
		
		for(long l : answer) {
			System.out.print(l + " ");
		}
	}
	
	static Map<Long, Long> map = new HashMap<>();
	static boolean debug = false;
	
	public static long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		for(int i=0;i<answer.length;i++) {
			answer[i] = find(room_number[i]);
		}
		
        return answer;
    }
	
	public static long find(long roomNumber) {
		if(!map.containsKey(roomNumber)) {
			map.put(roomNumber, roomNumber);
			return roomNumber;
		}
		else {
			long cur = map.get(roomNumber);
			map.put(roomNumber, find(cur+1));
			return map.get(roomNumber);
		}
	}

	
	public static void print(String text) {
		if(debug) {
			System.out.print(text);
		}
	}
	
	public static void println(String text) {
		if(debug) {
			System.out.println(text);
		}
	}
	
	public static void println() {
		if(debug) {
			System.out.println();
		}
	}
	
	public static void printlist(Iterator<Long> it) {
		while(it.hasNext()) {
			print(it.next() + " ");
		}
		println();
	}
}
