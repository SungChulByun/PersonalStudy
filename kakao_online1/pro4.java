package kakao_online1;

public class pro4 {
	public static void main(String args[]) {
		
	}
	public static int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		return answer;
	}
}
class Trie{
	Trie[] sub = new Trie[26];
	boolean endofsome=false;
	public void add(String word) {
		Trie tri;
		if(this.sub[chartoint(word.charAt(0))]==null) {
			tri = this.sub[chartoint(word.charAt(0))]=new Trie();
		}
		else {
			tri = sub[chartoint(word.charAt(0))];
		}
		int len=1;
		while(len<word.length()) {
			int next = chartoint(word.charAt(len));
			if(tri.sub[next]==null) {

				tri.sub[next]=new Trie();
			}
			tri = tri.sub[next];
			len++;
		}
		tri.endofsome=true;
	}
	public int howmany(String word, int num) {
		int len=0;
		int tp = num;
		Trie tri = this.sub[chartoint(word.charAt(len))];
		len++;
		while(len<word.length()) {
			if(tri.sub[chartoint(word.charAt(len))]==null) {
				
			}
			tri = tri.sub[chartoint(word.charAt(len))];
			len++;
		}
		while(tp>0) {
			
		}
		return len;
	}
	
	public static int chartoint(char x) {
		return x-'a';
	}
}