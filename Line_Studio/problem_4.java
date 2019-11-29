package Line_Studio;
import java.util.*;
public class problem_4 {
	static Stack<Integer> stk = new Stack<Integer>();
	public static void main(String args[]) {
		int[] test = new int[] {1, -1};
		System.out.println(solution(test));
	}
	public static int solution(int[] inputList) {
        int answer = 0;
        int n = inputList.length;
        answer = inputList[0];
        stk.add(answer-1);
        for(int i=1;i<n;i++) {
//        	System.out.println("--here : "+i+", "+answer);
        	if(answer==0) return 0;
        	else if(inputList[i]>0) answer = next(answer, inputList[i]);
        	else answer=back();
        	
        }
        return answer;
    }
	static int next(int x, int d) {
//		System.out.println("next : "+x+", "+d);
		if(d==0) return x;
		else {
			stk.add(x);
			if(x==4&&d>1) return next(6, d-2);
			else if(x==5) return next(20, d-1);
			else if(x==9&&d>1) return next(11, d-2);
			else if(x==10) return next(25, d-1);
			else if(x==21&&d>1) return next(23, d-2);
			else if(x==22) return next(27, d-1);
			else if(x==26) return next(22, d-1);
			else if(x==24) return next(15, d-1);
			else if(x==28||x==19) return next(0, d-1);
			else if(x==0) return 0;
			else return next(x+1, d-1);
		}
	}
	static int back() {
		return stk.pop();
	}
}
