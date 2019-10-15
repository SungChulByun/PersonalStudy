package kakao_online1;

import java.util.*;

public class problem4 {
	public static void main(String args[]) {
		String words[] = new String[] {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String que[] = new String[] {"fro??", "????o", "fr???", "fro???", "pro?"};
		int[] result = solution(words, que);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
	}
	public static int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		String[] rev = new String[words.length];
		for(int i=0;i<words.length;i++) {
			rev[i]=reverse(words[i]);
		}
		for(int i=0;i<queries.length;i++) {
			if(queries[i].charAt(0)=='?') {
				int len = queries[i].length();
				String key = remove(reverse(queries[i]));
				for(int j=0;j<words.length;j++) {
					if(rev[j].indexOf(key)==0&&rev[j].length()==len) {
						answer[i]++;
					}
				}
			}
			else {
				int len = queries[i].length();
				String key = remove(queries[i]);
				for(int j=0;j<words.length;j++) {
					if(words[j].indexOf(key)==0&&words[j].length()==len) {
						answer[i]++;
					}
				}
			}
		}
		return answer;
	}
	static String remove(String x) {
		String tp = "";
		for(int i=0;i<x.length();i++) {
			if(x.charAt(i)!='?') tp+=x.charAt(i);
			else i=x.length();
		}
		return tp;
	}
	static String reverse(String x) {
		String tp = "";
		for(int i=0;i<x.length();i++) {
			tp+=x.charAt(x.length()-i-1);
		}
		return tp;
	}
}