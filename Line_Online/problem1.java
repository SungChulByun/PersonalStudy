package Line_Online;

import java.util.*;
public class problem1 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean fin=false;
        Queue<Integer> qu = new LinkedList<Integer>();
        int[] consumer = new int[m];
        int ct=0;
        for(int i=0;i<n;i++) {
        	qu.add(sc.nextInt());
        }
        while(!fin) {
        	for(int i=0;i<m;i++) {
        		if(consumer[i]==0) consumer[i]=qu.poll();
        		if(qu.isEmpty()) {
        			fin=true;
        			i=m+n;
        		}
        	}
        	for(int i=0;i<m;i++) {
        		consumer[i]=Math.max(0, consumer[i]-1);
        	}
        	ct++;
        }
        int max=0;
        for(int i=0;i<m;i++) {
        	max=Math.max(max, consumer[i]);
        }
        System.out.println(max+ct);
    }
}
