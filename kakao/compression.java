package kakao;

import java.util.*;
public class compression {
	public static void main(String args[]) {
		String test = "THATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITIS";
		int[] result = solution(test);
		for(int i=0;i<result.length;i++) {
			System.out.println("result["+i+"] : "+result[i]);
		}
		System.out.println();
		System.out.println(result.length);
	}
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	static Queue<String> qu = new LinkedList<String>();
	public static int[] solution(String msg) {
		for(int i=0;i<26;i++) {
			String tp = Character.toString((char)('A'+i));
			map.put(tp, i+1);
		}
		String word = msg;
		while(word.length()>0) {
			word=nextWord(word);
		}
		int qsize=qu.size(); 
		int[] answer = new int[qsize];
//		for(int i=0;i<qu.size();i++) {
//			answer[i]=map.get(qu.poll());
//		}
		int i=0;
		while(!qu.isEmpty()){
			String tp = qu.poll();
//			System.out.println("word : "+tp+", val : "+map.get(tp));
			answer[i]=map.get(tp);
			i++;
		}
		return answer;
	}
	static String nextWord(String word) {
		String next="";
		if(word.length()==1) {
			qu.add(word);
//			System.out.println("word : "+word+", val : "+map.get(word));
			return next;
		}
		else {
			int ct=1;
			while(map.containsKey(word.substring(0, ct))) {
				if(ct==word.length()) break;
				ct++;
			}
			if(ct==word.length()) {
				qu.add(word.substring(0, ct));
				return next;
			}
			else {
				qu.add(word.substring(0, ct-1));
				map.put(word.substring(0, ct), map.size()+1);
	//			System.out.println("word : "+word.substring(0, ct-1)+", val : "+map.get(word.substring(0, ct-1)));
				next = word.substring(ct-1);
				return next;
			}
		}
	}
}