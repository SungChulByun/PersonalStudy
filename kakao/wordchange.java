package kakao;

import java.util.*;
public class wordchange {
	public static void main(String args[]) {
		String[] test = new String[] {"hot", "dot", "dog", "lot", "log"};
		int result = solution("hit", "cog", test);
		System.out.println(result);
	}
	static Queue<int[]> qu = new LinkedList<int[]>();
	public static int solution(String begin, String target, String[] words) {
		int answer = 0;
		int n = words.length;
		boolean hastar=false;
		for(int i=0;i<n;i++) {
			if(words[i].equals(target)) hastar=true;
			if(isonedif(begin, words[i])) {
				qu.add(new int[] {i, 1});
			}
		}
		if(!hastar) return 0;
		while(!qu.isEmpty()) {
			int[] tp = qu.poll();
			int wd = tp[0];
			int t = tp[1];
			if(words[wd].equals(target)) {
				return t;
			}
			for(int i=0;i<n;i++) {
				if(isonedif(words[wd], words[i])) {
					qu.add(new int[] {i, t+1});
				}
			}
		}
		return 0;
	}
	static boolean isonedif(String x, String y) {
		int ct=0;
		for(int i=0;i<x.length();i++) {
			if(x.charAt(i)!=y.charAt(i)) ct++;
		}
		if(ct==1) return true;
		else return false;
	}
}
