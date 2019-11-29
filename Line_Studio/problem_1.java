package Line_Studio;
import java.util.*;
public class problem_1 {
	public static void main(String args[]) {
		int[] st1 = new int[] {0,1,3,5,6,8,12,17};
		int[] st2 = new int[] {0,1,2,3,4,8,9,11};
		System.out.println("st1 : "+solution(st1));
		System.out.println("st2 : "+solution(st2));
	}
	public static boolean solution(int[] stones) {
        int n = stones.length;
        Queue<int[]> qu = new LinkedList<int[]>();
        qu.add(new int[] {0, 1});
        while(!qu.isEmpty()) {
        	int[] temp = qu.poll();
        	int loc = temp[0];
        	int jp = temp[1];
        	if(loc==n-1) return true;
        	for(int i=loc+1;i<n;i++) {
        		int gap = stones[i]-stones[loc];
        		if(gap>=jp-1&&gap<=jp+1) {
        			qu.add(new int[] {i, gap});
        		}
        	}
        }
        
        return false;
    }
}
