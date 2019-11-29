package Line_Studio;
import java.util.*;
public class problem_3 {
	public static void main(String args[]) {
		int[] test = new int[] {1,5,0,0,0,0,0,5,6,6};
		System.out.println(solution(test));
	}
	public static int solution(int[] hList) {
        int answer = 0;
        int n = hList.length;
        int left=0;
        int right = n-1;
        int curh=0;
        while(left<right) {
        	while(hList[left]<curh) {
        		left++;
        		if(left>=n) break;
        	}
        	while(hList[right]<curh) {
        		right--;
        		if(right<=0) break;
        	}
        	for(int i=left;i<right;i++) {
        		if(hList[i]<curh) answer++;
        	}
        	curh++;
        }
        
        return answer;
    }
}
