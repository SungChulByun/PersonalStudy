package backjoon;

import java.util.*;
public class String_2146 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m=sc.nextInt();
		HashSet<String> first = new HashSet<>();
		PriorityQueue<String> second = new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			first.add(sc.next());
		}
		for(int i=0;i<m;i++) {
			String temp = sc.next();
			if(first.contains(temp)) {
				second.add(temp);
			}
		}
		System.out.println(second.size());
		while(!second.isEmpty()) {
			System.out.println(second.poll());
		}
	}
}
