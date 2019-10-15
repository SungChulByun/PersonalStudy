package kakao_online1;

public class problem1 {
	public static void main(String args[]) {
		System.out.println(solution("ababababababababababababababababababcdcdcdcdcdcdcdcd"));
	}
	public static int solution(String s) {
        int answer = s.length();
        for(int x=1;x<=(s.length()+1)/2;x++){
	        String wd = s;
	        String ans="";
	        while(wd.length()>=x) {
	        	String[] temp = zip(wd, x);
//	        	System.out.println("x : "+x+"//"+temp[0]+", "+temp[1]);
//	        	System.out.println("ans : "+ans);
	        	if(last(temp[0])==1) {
	        		ans+=temp[0].substring(0, temp[0].length()-1);
	        		wd = temp[1];
	        	}
	        	else {
	        		ans+=temp[0];
	        		wd=temp[1];
	        	}
	        }
	        ans+=wd;
//	        System.out.println("ans : "+ans+", len : "+ans.length()+", x : "+x);
	        answer=Math.min(answer, ans.length());
        }
        
        return answer;
    }
	static boolean isnum(char x) {
		if (x>='0'&&x<='9') return true;
		else return false;
	}
	static int last(String x) {
		String tp="";
		for(int i=0;i<x.length();i++) {
			if(isnum(x.charAt(x.length()-1-i))){
				tp=x.charAt(x.length()-1-i)+tp;
			}
		}
		return Integer.parseInt(tp);
	}
	static String[] zip(String wd, int x) {
		int ct=0;
		String tp = wd.substring(0, x);
		for(int i=0;i<wd.length()/x;i++) {
			if(wd.substring(i*x, (i+1)*x).equals(tp)) {
				ct++;
			}
			else {
				i=wd.length();
			}
		}
		return new String[] {tp+ct,wd.substring(ct*x)};
	}
}