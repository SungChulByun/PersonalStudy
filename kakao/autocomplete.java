package kakao;

import java.util.*;
public class autocomplete {
	public static void main(String args[]) {
		String[] test = new String[] {"word","war","warrior","world"};
		int result = solution(test);
		System.out.println(result);
	}
	public static int solution(String[] words) {
		String[] tp = words.clone();
		int answer = 0;
		int n = words.length;
		Arrays.sort(tp);
		if(include(tp[0], tp[1])){
			int a = tp[0].length();
			answer+=a;
//			System.out.println("include, tp[0] : "+tp[0]+", answer+ : "+a);
		}
		else {
			int a = common(tp[0], tp[1])+1;
			answer+=a;
//			System.out.println("common, tp[0] : "+tp[0]+", answer+ : "+a);
		}
		for(int i=1;i<n-1;i++) {
			boolean inc1 = include(tp[i-1], tp[i]);
			boolean inc2 = include(tp[i], tp[i+1]);
			if(inc2) {
				int a = tp[i].length();
				answer+=a;
//				System.out.println("include, tp["+i+"] : "+tp[i]+", answer+ : "+a);
			}
			else {
				int com1 = common(tp[i-1], tp[i]);
				int com2 = common(tp[i], tp[i+1]);
				int a = Math.max(com1, com2)+1;
				answer+=a;
//				System.out.println("common, tp["+i+"] : "+tp[i]+", answer+ : "+a);
			}
		}
		if(include(tp[n-2], tp[n-1])) {
			int a = tp[n-2].length()+1;
			answer+=a;
//			System.out.println("include, tp[n-1] : "+tp[n-1]+", answer+ : "+a);
		}
		else {
			int a = common(tp[n-2], tp[n-1])+1;
			answer+=a;
//			System.out.println("common, tp["+(n-1)+"] : "+words[n-1]+", answer+ : "+a);
		}
		return answer;
	}
	static boolean include(String small, String big) {
		if(big.indexOf(small)==0) {
			return true;
		}
		else return false;
	}
	static int common(String fst, String snd) {
		int min = Math.min(fst.length(), snd.length());
		int len = 0;
		for(int i=0;i<min;i++) {
			if(fst.charAt(i)==snd.charAt(i)) len++;
			else i=min;
		}
		return len;
	}
}