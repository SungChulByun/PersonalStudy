package kakao;
import java.util.*;
public class cache {
	public static void main(String args[]) {
		String[] test = new String[] {"Jeju","Pangyo","Seoul","NewYork","LA","Jeju","Pangyo","Seoul","NewYork","LA"};
		int result = solution(0, test);
		System.out.println(result);
	}
	static Queue<String> qu = new LinkedList<String>();
	public static int solution(int cacheSize, String[] cities) {
		if(cacheSize>0) {
			int answer=0;
			int n = cities.length;
			String[] city = cities.clone();
			for(int i=0;i<n;i++) {
				city[i]=city[i].toLowerCase();
			}
			for(int i=0;i<n;i++) {
				if(qu.contains(city[i])) {
					qu.remove(city[i]);
					qu.add(city[i]);
					answer+=1;
				}
				else {
					if(qu.size()==cacheSize) {
						qu.poll();
					}
					qu.add(city[i]);
					answer+=5;
				}
			}
			return answer;
		}
		else {
			return 5*cities.length;
		}
	}
}
