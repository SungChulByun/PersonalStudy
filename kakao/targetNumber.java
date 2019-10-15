package kakao;
import java.util.*;
public class targetNumber {
	public static void main(String args[]) {
		int[] test = new int[] {1, 1, 1, 1, 1};
		int result = solution(test, 3);
		System.out.println(result);
	}
	public static int solution(int[] numbers, int target) {
		int answer=0;
		HashMap<Integer, Integer> leftmap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> rightmap = new HashMap<Integer, Integer>();
		int n = numbers.length, m=2/n ,r=n-m;
		for(int i=0;i<(1<<m);i++) {
			int tp = i;
			int sum=0;
			int loc=0;
			while(loc<m) {
				sum+=mul(numbers[loc], tp%2);
				tp/=2;
				loc++;
			}
			if(leftmap.containsKey(sum)) {
				leftmap.put(sum, leftmap.get(sum)+1);
			}
			else {
				leftmap.put(sum, 1);
			}
		}
		for(int i=0;i<(1<<r);i++) {
			int tp = i;
			int sum=0;
			int loc=0;
			while(loc<r) {
				sum+=mul(numbers[m+loc], tp%2);
				tp/=2;
				loc++;
			}
			if(rightmap.containsKey(sum)) {
				rightmap.put(sum, rightmap.get(sum)+1);
			}
			else {
				rightmap.put(sum, 1);
			}
		}
		for(Map.Entry<Integer, Integer> elem:leftmap.entrySet()) {
			int tp = target-elem.getKey();
			if(rightmap.containsKey(tp)) {
				answer+=elem.getValue()*rightmap.get(tp);
			}
		}
		return answer;
	}
	static int mul(int num, int isminus) {
		if(isminus==0) {
			return num;
		}
		else {
			return -num;
		}
	}
}
