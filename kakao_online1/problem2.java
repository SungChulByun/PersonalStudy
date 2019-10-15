package kakao_online1;

public class problem2 {
	public static void main(String args[]) {
		String test = "(()())()";
		System.out.println(solution(test));
	}
	public static String solution(String p) {
		return operation(p);
	}
	static String reverse(String word) {
		String re="";
		for(int i=0;i<word.length();i++) {
			re+=rev(word.charAt(i));
		}
		return re;
	}
	static char rev(char x) {
		if(x=='(') return ')';
		else return '(';
	}
	static String operation(String wd) {
		if(wd.length()==0) return "";
		else {
			int cut = firstbalanced(wd);
			if(wd.charAt(0)=='(') {
				return wd.substring(0, cut)+operation(wd.substring(cut));
			}
			else {
				return '('+operation(wd.substring(cut))+')'+reverse(wd.substring(1, cut-1));
			}
		}
	}
	static int firstbalanced(String wd) {
		int ct=0;
		for(int i=0;i<wd.length();i++) {
			if(wd.charAt(i)=='(') ct++;
			else ct--;
			if(ct==0) return i+1;
		}
		return wd.length();
	}
}
