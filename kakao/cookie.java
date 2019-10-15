package kakao;
import java.util.*;
public class cookie {
	public static void main(String args[]) {
		int[] test = new int[] {1,1,2,3};
		int result = solution(test);
		System.out.println(result);
	}
	public static int solution(int[] cookie) {
		int n = cookie.length;
		int fst=0;


		for(int i=0;i<n;i++) {
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int sum=0;
			for(int j=i;j<n;j++) {
				sum+=cookie[j];
				map.put(sum, j);
			}
			for(Map.Entry<Integer, Integer> elem1:map.entrySet()) {
				int val = elem1.getKey();
				int dval = 2*val;
				if(map.containsKey(dval)) {
					fst=Math.max(val, fst);
				}
			}
		}
		return fst;
	}
}
