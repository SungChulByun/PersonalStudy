package kakao;

public class auto_trie {
	public static void main(String args[]) {
		String[] test = new String[] {"word","war","warrior","world"};
		int result = solution(test);
		System.out.println(result);
	}
	public static int solution(String[] words) {
		int answer = 0;
		Trie trie = new Trie();
		int n = words.length;
		for(int i=0;i<n;i++) {
			trie.add(words[i]);
		}
		for(int i=0;i<n;i++) {
			int a = trie.type(words[i]);
//			System.out.println("--word : "+words[i]+", len : "+a);
			answer+=a;
		}
		
		return answer;
	}
	
}

class Trie{
	Trie[] sub = new Trie[26];
	boolean getnext=false;
	public void add(String word) {
		Trie tri;
		if(this.sub[chartoint(word.charAt(0))]==null) {
//			System.out.println("null word : "+word+", len : 0");
			tri = this.sub[chartoint(word.charAt(0))]=new Trie();
		}
		else {
//			System.out.println("notnull word : "+word+", len : 0");
			tri = sub[chartoint(word.charAt(0))];
			tri.getnext=true;
		}
		int len=1;
		while(len<word.length()) {
			int next = chartoint(word.charAt(len));
			if(tri.sub[next]==null) {
//				System.out.println("null word : "+word+", len : "+len);
				tri.sub[next]=new Trie();
			}
			else{
//				System.out.println("notnull word : "+word+", len : "+len);
				tri.sub[next].getnext=true;
			}
			tri = tri.sub[next];
			len++;
		}
	}
	public int type(String word) {
		int len=0;
		Trie tri = this.sub[chartoint(word.charAt(len))];
		len++;
		while(len<word.length()) {

			if(!tri.getnext) {
				break;
			}
			tri = tri.sub[chartoint(word.charAt(len))];
			len++;

		}
		return len;
	}
	
	public static int chartoint(char x) {
		return x-'a';
	}
}