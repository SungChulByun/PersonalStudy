package nhn;

import java.util.*;
public class nhn_problem1 {
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		boolean avail=true;
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			mapadd(sc.next());
		}
		int kind = map.size();
		int ct=0;
		int same=0;
		int cas=0;
		if(n%kind==0) { // nothing to add
			cas=0;
			int tar = n/kind;
			for(Map.Entry<String, Integer> elem : map.entrySet()) {
				int num = elem.getValue();
				if(num!=tar) avail=false;
			}
		}
		else {
			cas=1;
			if((n+1)%kind!=0) avail=false;
			int tar = (n+1)/kind;
			for(Map.Entry<String, Integer> elem : map.entrySet()) {
				int num = elem.getValue();
				if(num!=tar) ct++;
			}
			if(ct>1) avail=false;
		}
		
		if(avail) {
			System.out.println("Y");
			System.out.println(n+cas);
			System.out.println(kind);
		}
		else {
			System.out.println("N");
			System.out.println(n);
			System.out.println(kind);
		}
		
	}
	static void mapadd(String x) {
		if(map.containsKey(x)) {
			map.put(x, map.get(x)+1);
		}
		else {
			map.put(x, 1);
		}
	}
}
