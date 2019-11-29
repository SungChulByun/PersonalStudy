package Line_Studio;
import java.util.*;
public class problem_2 {
	static boolean isError;
	public static void main(String args[]) {
//		System.out.println(check("adfbfaadsds{"));
		
		Scanner sc = new Scanner(System.in);
		String test = sc.next();
		System.out.println("input : "+test);
		System.out.println("output : "+solution(test));
	}
	public static String solution(String pw) {
        isError = false;
        String result = myfunc(pw);
        if(isError) {
        	return "ERROR";
        }
        else return result;
        
		
    }
	static String myfunc(String pw) {
		if(!hasParen(pw)) return pw;
		else if(!check(pw)) {
			isError=true;
			return pw;
		}
		else {
			int n = pw.length();
			String head = "";
			String tail = "";
			String time = "";
			String mid="";
			
			int cur=0;
			while(!isNum(pw, cur)&&cur<n){
				cur++;
			}
			head = pw.substring(0, cur);
			while(isNum(pw, cur)) {
				time+=pw.charAt(cur);
				cur++;
				if(time.length()>=3) isError=true; 
			}
			int end=cur;
//			System.out.println("end : "+pw.charAt(end));
			if(isParen(pw, end)) {
				int ct=1;
				end++;
				while(ct>0&&end<n) {
					if(pw.charAt(end)=='{') ct++;
					else if(pw.charAt(end)=='}') ct--;
					end++;
				}
			}
			mid = pw.substring(cur+1, end-1);
			tail = pw.substring(end);
//			System.out.println("---------------");
//			System.out.println("head : "+head);
//			System.out.println("tail : "+tail);
//			System.out.println("mid : "+mid);
//			System.out.println("time : "+time);
//			System.out.println("---------------");
			
			String answer = head;
			for(int i=0;i<toNum(time);i++) answer+=myfunc(mid);
			answer+=myfunc(tail);
			return answer;
		}
	}
	
	static int toNum(String x) {
		return Integer.parseInt(x);
	}
	static boolean isNum(String x, int y) {
		if(y>=x.length()) return false;
		else if(x.charAt(y)>='0'&&x.charAt(y)<'9') return true;
		else return false;
	}
	static boolean isParen(String x, int y) {
		if(y>=x.length()) return false;
		if(x.charAt(y)=='{'||x.charAt(y)=='}') return true;
		else return false;
	}
	static boolean hasParen(String x) {
		for(int i=0;i<x.length();i++) {
			if(isParen(x, i)) return true;
		}
		return false;
	}
	static boolean check(String x) {
		int ct=0;
		for(int i=0;i<x.length();i++) {
			if(x.charAt(i)=='{') ct++;
			else if(x.charAt(i)=='}') ct--;
		}
		return(ct==0);
	}
}
